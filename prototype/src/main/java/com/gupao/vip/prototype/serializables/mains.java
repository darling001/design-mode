package com.gupao.vip.prototype.serializables;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/6
 * Time: 17:07
 * Description:
 */
public class mains {

    public static void main(String[] args) throws CloneNotSupportedException {
        KeLongRen keLongRen = new KeLongRen();
        keLongRen.setName("aiqing");

        KeLongRen k = (KeLongRen)keLongRen.clone();

        System.out.println(k.name);
        System.out.println(keLongRen.name);
        System.out.println(k.name==keLongRen.name);

        System.out.println(keLongRen.telephone == k.telephone);
    }
}
