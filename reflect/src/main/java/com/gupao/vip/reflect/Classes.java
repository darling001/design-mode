package com.gupao.vip.reflect;

import com.gupao.vip.pojo.People;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 14:01
 * Description: Class对象:获取Class对象的方法
 */
public class Classes {

    public static void main(String[] args) {
        /**
         * 1.调用某个对象的getClass()方法:
         */
        People people = new People();
        Class clazz1 = people.getClass();
        System.out.println(clazz1);

        /**
         * 2.调用某个类的class属性来获取该类对应的Class对象
         */
        Class clazz2 = People.class;
        System.out.println(clazz2);

        /**
         * 3.使用Class类中的forName()静态方法; (最安全/性能最好):
         * Class clazz=Class.forName("类的全路径"); (最常用)
         */
        Class clazz3 = null;
        try {
            clazz3 = Class.forName("com.gupao.vip.pojo.People");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz3);
    }
}
