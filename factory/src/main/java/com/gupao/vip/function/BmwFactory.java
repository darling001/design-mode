package com.gupao.vip.function;

import com.gupao.vip.Bmw;
import com.gupao.vip.Car;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 9:40
 * Description:
 */
public class BmwFactory implements Factory {

    public Car getCar() {
        return new Bmw();
    }

}
