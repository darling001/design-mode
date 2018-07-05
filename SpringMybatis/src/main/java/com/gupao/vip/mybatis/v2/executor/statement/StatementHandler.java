package com.gupao.vip.mybatis.v2.executor.statement;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/26
 * Time: 15:13
 * Description:
 */
public interface StatementHandler {

    public <T> T query(String statement, Class<?> classType, Object parameter);
}
