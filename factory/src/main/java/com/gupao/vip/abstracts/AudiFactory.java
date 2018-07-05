package com.gupao.vip.abstracts;

import com.gupao.vip.Audi;
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
public class AudiFactory extends AbstractFactory {

    protected Car getCar() {
        return new Audi();
    }


}
