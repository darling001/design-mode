package com.gupao.vip.myProxy;

import com.gupao.vip.Person;
import com.gupao.vip.Zhangsan;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/2
 * Time: 17:29
 * Description:
 */
public class GPMeipo implements GPInvocationHandler {

    private Person target;

    //获取被代理人的个人资料
    public Object getInstance(Person target) throws IOException {
        this.target = target;
        Class<?> clazz = target.getClass();
        Class<?> classss = clazz.getInterfaces()[0];
        String name = classss.getName();
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(this.target,args);
        return null;
    }
}
