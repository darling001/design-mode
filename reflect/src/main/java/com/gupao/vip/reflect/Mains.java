package com.gupao.vip.reflect;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 16:00
 * Description: 反射获取main方法
 */
public class Mains {

    public static void main(String[] args) {
        try {
            /**
             *  1、获取Student对象的字节码
             */
            Class clazz = Class.forName("com.gupao.vip.pojo.Student");

            /**
             * 2、获取main方法
             */
            System.out.println("*****main方法*****");
            Method methodMain = clazz.getMethod("main",String[].class);
            System.out.println(methodMain);
            System.out.println();

            /**
             * 3、调用main方法
             *    methodMain.invoke(null, new String[]{"a","b","c"});
             *    第一个参数，对象类型，因为方法是static静态的，所以为null可以
             *    第二个参数是String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数
             */

            System.out.println("*****方式1*****");
            methodMain.invoke(null,(Object)new String[]{"a","b"});
            System.out.println();
            System.out.println("*****方式2*****");
            methodMain.invoke(null,new Object[]{new String[]{"a","b"}});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
