package com.gupao.vip;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/13
 * Time: 12:14
 * Description:
 */


public class getBeans implements ApplicationContextAware{

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        /**
         * 拿到IOC容器
         * applicationContext.getBean(arg0)
         * 只要继承了ApplicationContextAware接口，
         * 在org.springframework.context.support.AbstractApplicationContext中，
         * 执行refresh()中的postProcessBeanFactory(beanFactory)方法，扫描所有继承
         * ApplicationContextAware接口的类自动触发调用
         * setApplicationContext(ApplicationContext applicationContext)方法，
         * 所以在setApplicationContext(ApplicationContext applicationContext)方法中，
         * 可以通过applicationContext.getBean(arg0)拿到相应的bean对象。
         */
    }
}