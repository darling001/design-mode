package com.gupao.vip.mybatis.v2;

import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.ExceptionUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/26
 * Time: 10:02
 * Description:
 */
public class Plugin implements InvocationHandler {

    private final Object target;
    private final Interceptor interceptor;
    private final Map<Class<?>, Set<Method>> signatureMap;

    private Plugin(Object target, Interceptor interceptor, Map<Class<?>, Set<Method>> signatureMap) {
        this.target = target;
        this.interceptor = interceptor;
        this.signatureMap = signatureMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Set<Method> methods = signatureMap.get(method.getDeclaringClass());
            if (methods != null && methods.contains(method)) {
                return interceptor.intercept(new Invocation(target, method, args));
            }
            return method.invoke(target, args);
        } catch (Exception e) {
            throw ExceptionUtil.unwrapThrowable(e);
        }
    }

    public static Object wrap(Object target, Interceptor interceptor)  {
        Map<Class<?>,Set<Method>> signatureMap = getSignatureMap(interceptor);
        Class<?> type = target.getClass();
        Class<?> [] interfaces = getAllInterface(type, signatureMap);
        if (interfaces.length>0){
            System.out.println(Proxy.newProxyInstance(type.getClassLoader(), interfaces, new Plugin(target,interceptor,signatureMap)).getClass().getSuperclass());
            return Proxy.newProxyInstance(type.getClassLoader(), interfaces, new Plugin(target,interceptor,signatureMap));
        }
        return target;
    }

    public static Class<?> [] getAllInterface(Class<?> type, Map<Class<?>,Set<Method>> signatureMap){
        Set<Class<?>> Interface = new HashSet<>();
        while (null!=type){
            for(Class<?> c: type.getInterfaces()){
                if(signatureMap.containsKey(c)){
                    Interface.add(c);
                }
            }
            type = type.getSuperclass();
        }
        return Interface.toArray(new Class<?>[Interface.size()]);
    }

    public static Map<Class<?>,Set<Method>> getSignatureMap(Interceptor interceptor){
        Intercepts intercepts = interceptor.getClass().getAnnotation(Intercepts.class);
        Map<Class<?>, Set<Method>> signatureMap = new HashMap<Class<?>, Set<Method>>();
        Signature[] signatures = intercepts.value();
        Method method = null;
        Set<Method> methodSet;
        for (Signature signature : signatures){
            methodSet = new HashSet<>();
            try {
                method = signature.type().getMethod(signature.method(),signature.args());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            methodSet.add(method);
            signatureMap.put(signature.type(),methodSet);
        }
        return signatureMap;
    }


}
