package com.gupao.vip.function;

import com.gupao.vip.Car;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 9:38
 * Description:
 */
//工厂接口，就定义了所有工厂的执行标准
public interface Factory {

    //符合汽车上路标准(总结：必须符合工厂生产标准)
    Car getCar();


}
