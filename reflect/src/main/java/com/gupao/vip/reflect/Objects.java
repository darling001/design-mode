package com.gupao.vip.reflect;

import com.gupao.vip.pojo.People;
import com.gupao.vip.pojo.Teacher;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 14:17
 * Description: 获取对象的方法
 */
public class Objects {

    public static void main(String[] args) {


        try {
            //获取Teacher类的Class对象
            Class clazz = Class.forName("com.gupao.vip.pojo.Teacher");

            /**
             * 1.第一种获取对象的方法：Clazz.newInstance();
             */
            Teacher teacher = (Teacher)clazz.newInstance();
            System.out.println(teacher);

            /**
             * 2.第二种获取对象的方法：Clazz.newInstance();
             */
            Constructor c = clazz.getConstructor(null);
            Teacher teacher1 = (Teacher)c.newInstance();
            System.out.println(teacher1);
            Constructor c1 = clazz.getConstructor(int.class,String.class);
            Teacher teacher2 = (Teacher)c1.newInstance(0,"");
            System.out.println(teacher2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
