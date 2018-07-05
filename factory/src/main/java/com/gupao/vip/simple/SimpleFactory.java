package com.gupao.vip.simple;

import com.gupao.vip.Audi;
import com.gupao.vip.Benz;
import com.gupao.vip.Bmw;
import com.gupao.vip.Car;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/3
 * Time: 18:02
 * Description:
 */
//简单工厂模式
//对这个工厂来说（太强大了）
//为什么？
//这个工厂啥都能干（不符合现实）
//编码也是一种艺术（融会贯通），艺术来源于生活，回归到生活的
public class SimpleFactory {

    //实现统一管理、专业化管理
    //如果没有工厂模式，小作坊，没有执行标准的
    //如果买到三无产品（没有标准）
    //卫生监督局的工作难度会大大减轻

    public Car getCar(String name){
        if("Bmw".equals(name)){
            return new Bmw();
        }else if("Benz".equals(name)){
            return new Benz();
        }else if("Audi".equals(name)){
            return new Audi();
        }else{
            System.out.println("这个产品生产不出来!");
            return null;
        }
    }
}
