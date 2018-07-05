package com.gupao.vip.mybatis.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 9:30
 * Description:
 */
public class Configuration {

    public <T> T getMapper(Class<T> clazz, SqlSession sqlSession) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));
    }

    public static class MapperRegister {

        public final static String NAME_SPACE = "com.unhz.generator.mapper.PeopleMapper";

        public final static Map<String,String> mapperSqlRelation = new HashMap<String, String>();

        static {
            mapperSqlRelation.put("selectPeopleById","select * from people where id = %d");
        }

    }


}
