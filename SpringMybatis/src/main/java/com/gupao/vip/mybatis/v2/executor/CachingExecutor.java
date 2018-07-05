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
 * @date : 2018/6/25
 * Time: 11:08
 * Description:
 */
public class CachingExecutor implements Executor {
    @Override
    public <T> T query(String statement, Class<?> classType, Object parameter) {
        return null;
    }

    @Override
    public <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler) throws SQLException {
        return null;
    }
}
