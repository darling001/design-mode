package com.gupao.vip.abstracts;

import com.gupao.vip.Car;

import javax.sound.midi.Soundbank;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 10:03
 * Description:
 */
public class AbstractTest {

    public static void main(String[] args) {

        DefaultFactory factory = new DefaultFactory();
        System.out.println(factory.getCar());

        System.out.println(factory.getCar(CarType.BENZ.getCarName()));
        //设计模式的经典之处，就在于，解决了编写代码的人和调用代码的人双方的痛楚
        //解放我们的双手
    }
}
