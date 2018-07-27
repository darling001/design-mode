package com.gupao.vip.mybatis.v2.executor.result;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 15:39
 * Description:
 */
public class ResultHandler {

    public <T> T query(ResultSet rs, Class<T> classType) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        //获取对象的类型
        Object property = new DefaultObjectFactory().create(classType);
        if(rs.next()){
            for(Field field: classType.getDeclaredFields()){
//                int i=0;
 //               setValue(property, field, rs, i);
                setValue(property, field, rs);
            }
        }
        return (T)property;
    }

    public void setValue(Object property, Field field, ResultSet rs) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        Method setMethod = property.getClass().getMethod("set" + upperField(field.getName()),field.getType());
        setMethod.invoke(property,getValue(field,rs));
    }

    public Object getValue(Field field, ResultSet rs) throws SQLException {
        Object propertyType = field.getType();
        if(Integer.class==propertyType){
            return rs.getInt(field.getName());
        }
        if(String.class==propertyType){
            return rs.getString(field.getName());
        }
        return rs.getString(field.getName());
    }

    public Object upperField(String field){
        String header = field.substring(0,1);
        String tail = field.substring(1,field.length());
        return header.toUpperCase()+tail;
    }

}
