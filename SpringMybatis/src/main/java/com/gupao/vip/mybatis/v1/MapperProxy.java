package com.gupao.vip.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 9:38
 * Description:
 */
public class MapperProxy<T> implements InvocationHandler{

    public SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(Configuration.MapperRegister.NAME_SPACE)){
            String statement = Configuration.MapperRegister.mapperSqlRelation.get(method.getName());
            return sqlSession.<T>selectOne(statement, args[0]);
        }
        return method.invoke(this,args);
    }
}
