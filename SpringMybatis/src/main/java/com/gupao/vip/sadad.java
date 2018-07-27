package com.gupao.vip;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/9
 * Time: 11:12
 * Description:
 */
public class sadad {

    public static void main(String[] args) {
        //取模：%：取余数.结果的符号取决于被模数的符号
        int i1 = 12 % 5;
        int i2 = -12 % 5;
        int i3 = 12 % (-5);
        int i4 = -12 % (-5);
        System.out.println(i1);    //2
        System.out.println(i2);    //-2
        System.out.println(i3);    //2
        System.out.println(i4);    //-2
    }
}
