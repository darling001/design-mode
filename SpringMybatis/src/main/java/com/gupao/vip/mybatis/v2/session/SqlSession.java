package com.gupao.vip.mybatis.v2.session;

import com.gupao.vip.mybatis.v2.InterceptorChain;
import com.gupao.vip.mybatis.v2.executor.Executor;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 9:29
 * Description:
 */
public class SqlSession {

    private Executor executor;

    private Configuration configuration;

    private InterceptorChain interceptorChain = new InterceptorChain();

    public SqlSession(Executor executor, Configuration configuration){
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz, SqlSession sqlSession){
        return configuration.getMapper(clazz, sqlSession);
    }

    public Object selectOne(String statement, Class<?> classType, Object parameter) {
        executor = (Executor)interceptorChain.pluginAll(executor);
        return executor.query(statement, classType, parameter);
    }

//    public <T> T selectOne(MapperRegistry.MapperData mapperData, Object parameter){
//        return executor.query(mapperData, parameter);
//    }


}
