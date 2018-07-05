package com.gupao.vip.mybatis.v2.executor;

import com.gupao.vip.mybatis.v2.executor.statement.SimpleStatementHandler;
import com.gupao.vip.mybatis.v2.session.Configuration;
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
 * Time: 10:17
 * Description:
 */
public class SimpleExecutor implements Executor {

    private Configuration configuration = new Configuration();

//    public <T> T query(MapperRegistry.MapperData mapperData, Object parameter) {
//        SimpleStatementHandler statementHandler = new SimpleStatementHandler();
//        return (T)statementHandler.query(mapperData, parameter);
//    }

    public <T> T query(String statement, Class<?> classType, Object parameter) {
        SimpleStatementHandler simpleStatementHandler = configuration.newStatementHandler(statement,parameter);
        return (T)simpleStatementHandler.query(statement, classType, parameter);
    }

    @Override
    public <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler) throws SQLException {
        return null;
    }


}
