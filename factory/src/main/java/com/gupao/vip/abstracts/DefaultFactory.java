package com.gupao.vip.abstracts;

import com.gupao.vip.Car;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 10:11
 * Description:
 */
public class DefaultFactory extends AbstractFactory {

    private AudiFactory factory = new AudiFactory();

    protected Car getCar() {
        return factory.getCar();
    }

}
