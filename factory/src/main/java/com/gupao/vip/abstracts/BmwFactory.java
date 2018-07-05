package com.gupao.vip.abstracts;

import com.gupao.vip.Bmw;
import com.gupao.vip.Car;
import com.gupao.vip.function.Factory;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 9:40
 * Description:
 */
public class BmwFactory extends AbstractFactory {


    protected Car getCar() {
        return new Bmw();
    }
}
