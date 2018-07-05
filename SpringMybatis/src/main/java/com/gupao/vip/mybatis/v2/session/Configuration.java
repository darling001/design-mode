package com.gupao.vip.mybatis.v2.session;

import com.gupao.vip.mybatis.v2.InterceptorChain;
import com.gupao.vip.mybatis.v2.binding.MapperProxy;
import com.gupao.vip.mybatis.v2.executor.parameter.ParameterHandler;
import com.gupao.vip.mybatis.v2.executor.result.ResultHandler;
import com.gupao.vip.mybatis.v2.executor.statement.SimpleStatementHandler;

import java.lang.reflect.Proxy;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 9:30
 * Description:
 */
public class Configuration {

    private InterceptorChain interceptorChain = new InterceptorChain();

    private ResultHandler resultHandler = new ResultHandler();


    public <T> T getMapper(Class<T> clazz, SqlSession sqlSession) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));
    }

    public SimpleStatementHandler newStatementHandler(String sql, Object patamObject){
        SimpleStatementHandler simpleStatementHandler = new SimpleStatementHandler(sql,patamObject,this);
        simpleStatementHandler = (SimpleStatementHandler)interceptorChain.pluginAll(simpleStatementHandler);
        return simpleStatementHandler;
    }

    public ResultHandler newResultHandler(){
        resultHandler = (ResultHandler)interceptorChain.pluginAll(resultHandler);
        return resultHandler;
    }

    public ParameterHandler newParameterHandler(){

        return null;
    }




}
