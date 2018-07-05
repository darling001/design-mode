package com.gupao.vip.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/5/24
 * Time: 10:37
 * Description:
 */
@Intercepts({@Signature(type= Executor.class,method="query",args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class SqlPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
        BoundSql boundSql = mappedStatement.getBoundSql(invocation.getArgs()[1]);
        String sql = boundSql.getSql();
        System.out.println(sql);
        System.out.println(String.format("sql = %s , param = %s , List<bill = %s",boundSql.getSql(),boundSql.getParameterObject(),boundSql.getParameterMappings()));
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof Executor){
            return Plugin.wrap(target,this);
        }else{
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        properties.setProperty("lazyLoadingEnabled","true");
    }
}
