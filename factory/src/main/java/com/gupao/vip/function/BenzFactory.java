package com.gupao.vip.function;

import com.gupao.vip.Benz;
import com.gupao.vip.Car;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 9:39
 * Description:
 */
public class BenzFactory implements Factory {

    public Car getCar() {
        return new Benz();
    }

}
