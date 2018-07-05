package com.gupao.vip.mybatis.v2.binding;


import com.gupao.vip.mybatis.v2.session.SqlSession;
import org.apache.ibatis.annotations.Select;

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

        String Sql = method.getAnnotation(Select.class).value()[0];
        Class<?> classType = method.getReturnType();
        if(null!=Sql){
            return sqlSession.<T>selectOne(Sql,classType, args[0]);
        }
        //解析MapperRegistry注册容器
//        MapperRegistry.MapperData mapperData = MapperRegistry.mapperRegistry.get(method.getDeclaringClass().getName() + "." + method.getName());
//        if(null!=mapperData){
//            return sqlSession.<T>selectOne(mapperData, args[0]);
//        }
        return method.invoke(this,args);
    }
}
