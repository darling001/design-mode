package com.gupao.vip.diyProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/3
 * Time: 14:46
 * Description:
 */
public class Tests {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method var3 = People.class.getDeclaredMethod("sum", Integer.TYPE, Integer.TYPE);
        System.out.println(var3);
        int a = (Integer)var3.invoke(new Lisi(),new Object[]{1,2});
        System.out.println(a);
    }
}
