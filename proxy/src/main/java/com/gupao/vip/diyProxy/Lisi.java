package com.gupao.vip.diyProxy;



/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/3
 * Time: 11:14
 * Description:
 */
public class Lisi implements People,Father,Mother {

    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public String regix(String a, String b, String c) {
        return "a";
    }

    @Override
    public void makeAir() {
        System.out.println("我是通过代理得来的方法!");
    }


    @Override
    public void up() {
        System.out.println("爸爸我爱你!");
    }

    @Override
    public void hahaa() {
        System.out.println("妈妈我爱你!");
    }
}
