package com.gupao.vip.reflect;

import com.gupao.vip.pojo.People;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 11:08
 * Description: 获取成员变量
 */
public class Fields {

    public static void main(String[] args) {
        try {
            /**
             * Constructor.newInstance():获取类的对象
             */
            Class<?> classType = getClassType();
            Object obj = classType.getConstructor(null).newInstance();
            People people = (People) obj;
            /**
             * 1.getDeclaredFields():返回 Field物体反射所有字段的类或接口的 类对象表示声明数组。
             * 这包括公共的、受保护的、默认的（包）访问和私有字段，但不包括继承的字段。
             */
            System.out.println("*****获取所有字段，包括：私有、受保护、默认、公有*****");
            Field[] fields = classType.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println("--------------------------");
            System.out.println();

            /**
             * 2.getDeclaredField(String name):返回一个对象，反映了 Field指定声明字段的类
             * 或接口的类对象表示的name参数是一个String指定所需字段的简单的名字。
             */
            System.out.println("*****获取某个字段(私有、受保护、默认、公有)*****");
            Field field = classType.getDeclaredField("job");
            System.out.println(field);
            System.out.println("--------------------------");
            System.out.println();

            /**
             * 3.getFields():返回一个数组包含Field物体反射的类或接口的类对象代表所有可访问的公共领域。
             */
            System.out.println("*****获取所有的公有字段*****");
            Field[] publicFields = classType.getFields();
            for (Field field1 : publicFields) {
                System.out.println(field1);
            }
            System.out.println("--------------------------");
            System.out.println();

            /**
             * 3.getField(String name):返回一个Field对象反映的类或接口的类对象表示的指定公共成员。
             */
            System.out.println("*****获取某个公有的字段*****");
            Field publicField = classType.getField("id");
            System.out.println(publicField.getName() + " " + publicField.getType());
            publicField.setInt(obj, 1);
            System.out.println(((People) obj).id);
            System.out.println("--------------------------");
            System.out.println();

            /**
             * Field.get(Object obj):反射通过get方法取值，
             */
            System.out.println("*****调用get方法获取值*****");
            Object o = publicField.get(obj);
            System.out.println(o);
            System.out.println("--------------------------");
            System.out.println();

            /**
             * Field.set(Object obj, Object value):反射通过set方法设值，
             * 注：不能直接拥有访问权限的需要Field.setAccessible(true);
             * 参数说明：1.要设置的字段所在的对象
             *          2.value:要为字段设置的值
             */
            System.out.println("*****调用set方法获设值*****");
            field.setAccessible(true);
            field.set(obj, "java开发");
            System.out.println(people.getJob());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Class getClassType() {
        Class clazz = null;
        try {
            clazz = Class.forName("com.gupao.vip.pojo.People");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
