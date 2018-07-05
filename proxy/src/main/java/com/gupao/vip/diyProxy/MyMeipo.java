package com.gupao.vip.diyProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/3
 * Time: 11:17
 * Description:
 */
public class MyMeipo implements MyInvocationHandler{

    private People target;//被代理对象的引用作为一个成员变量保存下来了

    public Object getInstance(People target) throws Exception{
        this.target = target;
        Class<?> clazz = target.getClass();
        return MyProxy.newInstance(new MyClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前的处理!");
        //调用的时候
        method.invoke(this.target,args);
        System.out.println("方法之后的处理!");
        return null;
    }
}
