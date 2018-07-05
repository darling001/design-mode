package com.gupao.vip.jdk;

import com.gupao.vip.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/2
 * Time: 16:20
 * Description:
 */
//媒婆
public class MeiPo implements InvocationHandler {

    public Person target;

    //获取被代理人的个人资料
    public Object getInstance(Person target){
        this.target = target;
        Class<?> clazz = target.getClass();
        ClassLoader classLoader = clazz.getClassLoader();
        Class<?> []classInterface = clazz.getInterfaces();
        return Proxy.newProxyInstance(classLoader,classInterface,this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(this.target,args);
        return null;
    }

}
