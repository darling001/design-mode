package com.gupao.vip.plugin;

import com.gupao.vip.mybatis.v2.Interceptor;
import com.gupao.vip.mybatis.v2.Plugin;
import com.gupao.vip.mybatis.v2.executor.Executor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/5/24
 * Time: 10:37
 * Description:
 */
@Intercepts({@Signature(type= Executor.class,method="query",args = {String.class, Class.class, Object.class})})
public class MyPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String sql = String.valueOf(invocation.getArgs()[0]);
        Object paramObj = invocation.getArgs()[2];
        System.out.println(String.format("sql = %s , param = %s ",sql,paramObj));
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
