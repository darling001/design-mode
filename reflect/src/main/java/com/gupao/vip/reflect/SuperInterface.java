package com.gupao.vip.reflect;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 17:56
 * Description: 反射获取父接口或者父类
 */
public class SuperInterface {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("com.gupao.vip.pojo.Teacher");

        /**
         * 1.getAnnotatedInterfaces():返回 AnnotatedType对象代表类型指定的类对象表示的实体父接口使用一个数组。
         */
        AnnotatedType[] supperInterface = clazz.getAnnotatedInterfaces();
        for(AnnotatedType annotatedType : supperInterface){
            System.out.println(annotatedType.getType());
        }

        /**
         * 2.getAnnotatedSuperclass():返回一个 AnnotatedType表示指定类型的对象表示的实体类父类的使用。
         */
        AnnotatedType supperClass = clazz.getAnnotatedSuperclass();
        System.out.println(supperClass.getType());

        /**
         * 3.getClasses():返回一个数组包含代表所有的公共类和接口的类对象表示的类成员类对象。
         */
        Class<?>[] supperClassAndSupperInterface = clazz.getClasses();
        for(Class<?> supper : supperClassAndSupperInterface){
            System.out.println(supper);
        }
    }
}
