package com.gupao.vip.annotationAspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/27
 * Time: 14:18
 * Description:
 */
@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution( * com.gupao.vip.annotationAspect..*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        logger.info("" + joinPoint);
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        logger.info("" + joinPoint);
    }

    @AfterReturning("pointCut()")
    public void afterReturning(JoinPoint joinPoint){
        logger.info("" + joinPoint);
    }

}
