package com.gupaoedu.vip.service.impl;

import com.gupaoedu.vip.annotation.MyAutowired;
import com.gupaoedu.vip.annotation.MyController;
import com.gupaoedu.vip.annotation.MyService;
import com.gupaoedu.vip.controller.UserController;
import com.gupaoedu.vip.service.InfoService;
import com.gupaoedu.vip.service.UserService;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/9
 * Time: 14:39
 * Description:
 */
@MyService
public class UserServiceImpl implements UserService {

    @MyAutowired
    UserController myController;

    @MyAutowired("infoS")
    InfoService infoService;

}
