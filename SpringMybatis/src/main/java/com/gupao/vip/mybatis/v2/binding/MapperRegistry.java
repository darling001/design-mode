package com.gupao.vip.mybatis.v2.binding;



import com.gupao.vip.pojo.People;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 15:42
 * Description:
 */
public class MapperRegistry {

    public final static String NAME_SPACE = "com.unhz.generator.mapper.PeopleMapper.selectPeopleById";

    public final static Map<String,MapperData> mapperRegistry = new HashMap<>();

    static {
        mapperRegistry.put(NAME_SPACE,new MapperData("select * from people where id = %d", People.class));
    }

    public static class MapperData<T>{

        private String Sql;

        private Class<T> classType;

        public MapperData(String Sql, Class<T> classType){
            this.Sql =  Sql;
            this.classType = classType;
        }

        public String getSql() {
            return Sql;
        }

        public void setSql(String sql) {
            Sql = sql;
        }

        public Class<T> getClassType() {
            return classType;
        }

        public void setClassType(Class<T> classType) {
            this.classType = classType;
        }
    }
}
