package com.gupao.vip.diyProxy;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/3
 * Time: 13:24
 * Description:
 */
public class MeiPoTest {

    public static void main(String[] args) {
        People people = null;
        try {
            people = (People)new MyMeipo().getInstance(new Lisi());
        } catch (Exception e) {
            e.printStackTrace();
        }
        people.makeAir();
    }

}
