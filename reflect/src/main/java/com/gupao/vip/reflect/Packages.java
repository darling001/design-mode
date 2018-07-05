package com.gupao.vip.reflect;

import java.net.URL;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/28
 * Time: 9:35
 * Description:
 */
public class Packages {

    public static void main(String[] args) {

        Class clazz = Fields.getClassType();
        Package  packages = clazz.getPackage();
        System.out.println(packages);


    }
}
