package com.gupao.vip.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/27
 * Time: 11:03
 * Description:
 */
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    public void before(){
        logger.info("方法在调用之前!");
    }

    public void after(){
        logger.info("方法在调用之后!");
    }

    public void afterReturn(Object rvt){
        logger.info("方法在获得返回值之后!");
    }

    public void throwsException(){
        logger.info("出现异常之后调用!");
    }



}
