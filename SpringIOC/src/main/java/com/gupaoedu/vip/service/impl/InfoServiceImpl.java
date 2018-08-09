package com.gupaoedu.vip.service.impl;

import com.gupaoedu.vip.annotation.MyAutowired;
import com.gupaoedu.vip.annotation.MyService;
import com.gupaoedu.vip.controller.InfoController;
import com.gupaoedu.vip.service.InfoService;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/9
 * Time: 14:45
 * Description:
 */
@MyService("infoS")
public class InfoServiceImpl implements InfoService{

    @MyAutowired
    InfoController infoController;


}
