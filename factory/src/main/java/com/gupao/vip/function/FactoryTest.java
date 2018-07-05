package com.gupao.vip.function;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 9:43
 * Description:
 */
public class FactoryTest {

    public static void main(String[] args) {

        //工厂方法模式
        //各个产品的生产商，都拥有各自的工厂
        //生产工艺，生成的高科技程度都是不一样的
        Factory factoryAudi = new AudiFactory();
        System.out.println(factoryAudi.getCar());

        //需要用户关心，关心产品的生产商
        Factory factoryBenz = new BenzFactory();
        System.out.println(factoryBenz.getCar());

        //增加了代码的使用复杂度


    }
}
