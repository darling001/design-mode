package com.gupao.vip.service;

import com.gupao.vip.pojo.User;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/5
 * Time: 16:05
 * Description:
 */
public interface UserService {

    User selectUserAndRole1(String userId);

    //default用于接口扩展业务，从而使得接口在进行扩展的时候，不会破坏与接口相关的实现类代码。
    default void sadd(){
        System.out.println("function");
    }
}
