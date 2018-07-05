package com.gupao.vip.reflect;

import org.hibernate.validator.constraints.NotBlank;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 17:35
 * Description: 读取注解的信息
 */
public class Annotations {

    public static void main(String[] args) throws NoSuchFieldException {
        Class clazz = Fields.getClassType();
        Field field = clazz.getDeclaredField("name");
        NotBlank notBlank = field.getAnnotation(NotBlank.class);
        String message = notBlank.message();
        for (Class<?> clazzType : notBlank.groups()){
            System.out.println(clazzType);
        }
        System.out.println(message);

        Annotation[] annotations = field.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }
}
