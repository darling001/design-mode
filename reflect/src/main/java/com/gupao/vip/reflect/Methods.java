package com.gupao.vip.reflect;

import com.gupao.vip.pojo.People;
import sun.management.counter.perf.PerfInstrumentation;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 14:09
 * Description: 获取成员方法
 */
public class Methods {

    public static void main(String[] args) {
        try {
            Class clazz = Fields.getClassType();
            People people = (People)clazz.newInstance();

            /**
             * 1.getDeclaredMethods():返回一个数组包含 方法物体反射所有声明的方法的类或接口的 类对象，
             * 代表包括公众、保护，默认（包）的访问，和私有方法，但不包括继承的方法。
             */
            System.out.println("*****获取所有的成员方法，包括私有的(不包括继承的)*****");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            System.out.println("--------------------------");
            System.out.println();

            /**
             * 2.getMethods():返回一个数组包含方法物体反射所有的类或接口的类对象表示的公共方法，
             * 包括那些由类或接口的超类和超接口继承的声明。
             */
            System.out.println("*****获取所有公有方法:(包含了父类的方法也包含Object类)*****");
            Method[] publicMethods = clazz.getMethods();
            for (Method method : publicMethods){
                System.out.println(method);
            }
            System.out.println("--------------------------");
            System.out.println();

            /**
             * 3.getDeclaredMethod(String name, 类<?>... parameterTypes):
             * 返回一个方法对象反映指定声明方法的类或接口的类对象表示。
             */
            System.out.println("*****获取单个的成员方法:包括私有的(不包括继承的)*****");
            Method method = clazz.getDeclaredMethod("findNameAndAge",String.class,int.class);
            System.out.println(method);
            System.out.println("--------------------------");
            System.out.println();

            /**
             * 4.getMethod(String name, 类<?>... parameterTypes):
             * 返回一个方法对象反映的类或接口的类对象表示的指定公共成员方法。
             */
            System.out.println("*****获取单个的公有方法:(包含了父类的方法也包含Object类)*****");
            Method publicMethod = clazz.getMethod("notifyAll");
            System.out.println(publicMethod);
            System.out.println("--------------------------");
            System.out.println();

            /**
             * invoke(Object obj,Object... args):
             * 参数说明：obj : 要调用方法的对象
             *          args:调用方式时所传递的实参
             */
            System.out.println("*****调用方法*****");
            method.invoke(people,"沈佳庆",25);

            Method staticMethod = clazz.getMethod("staticMethod",String.class);
            staticMethod.invoke(null,"陈世美");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
