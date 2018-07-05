package com.gupao.vip.reflect;


import com.gupao.vip.pojo.People;
import com.gupao.vip.pojo.Teacher;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 16:47
 * Description: 通过反射越过泛型检查
 */
public class Generics {

    public static void main(String[] args) throws Exception {

        /**
         * 通过反射越过泛型检查
         *
         * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值?
         */
        List<String> list = new ArrayList<String>();
        list.add("function");
        list.add("bbb");

        Class clazz = list.getClass();
        Method method = clazz.getMethod("add",Object.class);
        System.out.println(method);
        method.invoke(list,1);
        System.out.println(list);

        for (Object object : list){
            System.out.println(object);
        }

    }

}
