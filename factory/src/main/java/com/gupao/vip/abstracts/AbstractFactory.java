package com.gupao.vip.abstracts;

import com.gupao.vip.Audi;
import com.gupao.vip.Benz;
import com.gupao.vip.Bmw;
import com.gupao.vip.Car;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 9:50
 * Description:
 */
public abstract class AbstractFactory {

    protected abstract Car getCar();

    public Car getCar(String name){
        if("Bmw".equalsIgnoreCase(name)){
            //Spring中的工厂模式
            //Bean
            //BeanFactory（生产Bean）
            //单例的Bean、被代理过的Bean、最原始的Bean（原型）、List类型的Bean、作用域不同的Bean

            //getBean
            //非常紊乱，维护困难
            //解耦（松耦合开发）
            return new Bmw();
        }else if("Benz".equalsIgnoreCase(name)){
            return new Benz();
        }else if("Audi".equalsIgnoreCase(name)){
            return new Audi();
        }else{
            System.out.println("这个产品生产不出来!");
            return null;
        }
    }

}
