package com.gupao.vip.mybatis.v2.executor;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 9:34
 * Description:
 */
public interface Executor {

//    <T> T query(MapperRegistry.MapperData mapperData, Object parameter);

    <T> T query(String statement, Class<?> classType, Object parameter);

    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler) throws SQLException;
}
