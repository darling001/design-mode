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
 * Time: 9:54
 * Description:
 */
public enum CarType {

    AUDI("AUDI"),
    BENZ("BENZ"),
    BMW("BMW");

    private String carName;

    CarType(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
