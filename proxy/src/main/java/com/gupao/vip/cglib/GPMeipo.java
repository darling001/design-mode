package com.gupao.vip.cglib;

import com.gupao.vip.diyProxy.People;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/3
 * Time: 16:13
 * Description: CGLIB方式
 */
public class GPMeipo implements MethodInterceptor{


    public Object getInstance(Class target) throws Exception{

        Enhancer enhancer = new Enhancer();
        //把父类设置为谁?
        //这一步就是告诉cglib，生成的子类需要继承哪个类
        enhancer.setSuperclass(target);
        //设置回调
        enhancer.setCallback(this);
        //第一步、生成源代码
        //第二步、编译成class文件
        //第三步、加载到JVM中，并返回被代理对象
        return enhancer.create();
    }

    //同样是做了字节码重组这样一件事情
    //对于使用API的用户来说，是无感知的
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("在前面");
        //这个o的引用是由CGLIb给我们new出来的
        //cglib new出来的对象,是被代理对象的子类（继承了我们自己写的那个类）
        //OOP，在new子类之前，实际上默认调用了我们super()方法的,
        //new了子类的同时，必须先new出来父类，这就相当于是间接的持有了我们父类的引用
        //子类重写了父类所有的方法
        //我们改变子类对象的某些属性，是可以间接的操作到父类的属性的
        methodProxy.invokeSuper(o,objects);
        System.out.println("在后面");
        return null;
    }
}
