package com.gupao.vip.mybatis.v1;



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

    public SqlSession(Executor executor, Configuration configuration){
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz, SqlSession sqlSession){
        return configuration.getMapper(clazz, sqlSession);
    }

    public <T> T selectOne(String statement, Object parameter){
        return executor.selectOne(statement, parameter);
    }


}
