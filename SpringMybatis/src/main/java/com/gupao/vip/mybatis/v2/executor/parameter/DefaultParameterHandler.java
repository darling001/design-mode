package com.gupao.vip.mybatis.v2.executor.parameter;


import com.gupao.vip.mybatis.v2.session.Configuration;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/26
 * Time: 15:00
 * Description:
 */
public class DefaultParameterHandler implements ParameterHandler {

    private Object parameterObject;

    private String sql;

    private Configuration configuration;

    public DefaultParameterHandler(Object parameterObject, String sql, Configuration configuration) {
        this.parameterObject = parameterObject;
        this.sql = sql;
        this.configuration = configuration;
    }
}
