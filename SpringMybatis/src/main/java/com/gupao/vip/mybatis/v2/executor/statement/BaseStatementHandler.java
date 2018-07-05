package com.gupao.vip.mybatis.v2.executor.statement;


import com.gupao.vip.mybatis.v2.executor.parameter.DefaultParameterHandler;
import com.gupao.vip.mybatis.v2.executor.parameter.ParameterHandler;
import com.gupao.vip.mybatis.v2.session.Configuration;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/26
 * Time: 15:16
 * Description:
 */
public abstract class BaseStatementHandler implements StatementHandler {

    private final String sql;

    private final Object parameterObject;

    private final Configuration configuration;

    private final ParameterHandler parameterHandler;

    public BaseStatementHandler(String sql,Object parameterObject,Configuration configuration){

        this.sql = sql;
        this.parameterObject = parameterObject;
        this.configuration = configuration;

        this.parameterHandler = new DefaultParameterHandler(parameterObject,sql,configuration);
    }



}
