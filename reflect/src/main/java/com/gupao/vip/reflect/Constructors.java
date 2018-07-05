package com.gupao.vip.reflect;

import com.gupao.vip.pojo.People;

import java.lang.reflect.Constructor;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 13:59
 * Description: 通过反射获取构造方法
 */
public class Constructors {

    public static void main(String[] args) {

        try {
            //获取People类的Class对象
            Class clazz = Fields.getClassType();

            /**
             * 获取构造函数：
             * 1.getConstructors():返回一个数组包含Constructor物体反射所有的 类对象表示的类的公共构造函数.
             */
            System.out.println("*****所有公共构造函数*****");
            Constructor[] publicConstructors = clazz.getConstructors();
            for (Constructor constructor : publicConstructors){
                System.out.println(constructor);
            }
            System.out.println("--------------------------");
            System.out.println();

            /**
             * 2.getConstructor(Class<?>... parameterTypes):返回一个 Constructor对象反映指定的公共构造函数的 类对象表示的类。
             */
            System.out.println("*****获取单个的公共构造函数*****");
            Constructor publicConstructor = clazz.getConstructor(null);
            System.out.println(publicConstructor);
            Constructor publicConstructorParam = clazz.getConstructor(int.class,String.class);
            System.out.println(publicConstructorParam);
            System.out.println("--------------------------");
            System.out.println();

            /**
             * 3.getDeclaredConstructors():返回 Constructor物体反射所有的构造函数通过类对象表示的类中声明一个数组。
             * 这些都是公共的、受保护的、默认的（包）访问和私有构造函数。
             */
            System.out.println("*****获取所有的构造函数(包括私有、受保护、默认、公有)*****");
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor constructor : constructors){
                System.out.println(constructor);
            }
            System.out.println("--------------------------");
            System.out.println();

            System.out.println("*****获取某个构造函数(可以是私有的，或受保护、默认、公有)*****");
            Constructor constructor = clazz.getDeclaredConstructor(int.class);
            System.out.println(constructor);
            System.out.println("--------------------------");
            System.out.println();

            /**
             * 调用构造函数
             * Constructor-->newInstance(Object ... initargs)
             */
            //暴力访问(忽略掉访问修饰符)
            System.out.println("*****获取私有构造方法，并调用*****");
            constructor.setAccessible(true);
            People people = (People)constructor.newInstance(1);
            System.out.println(people);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
