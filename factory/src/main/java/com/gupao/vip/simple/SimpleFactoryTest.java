package com.gupao.vip.simple;

import com.gupao.vip.Car;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/3
 * Time: 18:03
 * Description:
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {

        //这边就是我们的消费者
        Car car = new SimpleFactory().getCar("Bmw");
        System.out.println(car.gerName());
    }
}
