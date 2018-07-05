package com.gupao.vip.mybatis.v2;

import org.apache.ibatis.plugin.Invocation;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/26
 * Time: 10:09
 * Description:
 */
public interface Interceptor {

    public Object intercept(Invocation invocation) throws Throwable;

    Object plugin(Object target);

    void setProperties(Properties properties);
}
