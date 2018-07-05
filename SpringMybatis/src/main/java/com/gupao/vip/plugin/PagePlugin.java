package com.gupao.vip.plugin;


import com.gupao.vip.pojo.BasePojo;
import com.gupao.vip.pojo.BillRead;
import com.gupao.vip.util.JSONUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/5/24
 * Time: 13:46
 * Description:
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class}),
        @Signature( type = Executor.class, method = "query",args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })
})
public class PagePlugin implements Interceptor {

    private static final String SELECT_ID="selectbybillread";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        BoundSql boundSqls = handler.getBoundSql();
        String obj = boundSqls.getParameterObject().toString();
        String a = obj.replace("=","\":").replace("{","{\"").replace(",",",\"").replace("'","\"");
        int num = a.indexOf("{");
        String b = a.substring(num);
        BillRead ab = JSONUtil.toPOJO(b,BillRead.class);
        if (invocation.getTarget() instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            MappedStatement mappedStatement=(MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
            String selectId = mappedStatement.getId();
            String method = selectId.substring(selectId.lastIndexOf(".")+1).toLowerCase();
            BillRead bl = (BillRead)invocation.getArgs()[1];
            if(SELECT_ID.equals(method)){
                BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
                // 分页参数作为参数对象parameterObject的一个属性
                String sql = boundSql.getSql();
                BasePojo basePojo =(BasePojo)(boundSql.getParameterObject());
                // 重写sql
                String countSql = concatCountSql(sql);
                String pageSql = concatPageSql(sql,basePojo);
                System.out.println("重写的 count  sql        :"+ countSql);
                System.out.println("重写的 select sql        :"+ pageSql);
                Connection connection = (Connection) invocation.getArgs()[0];
                PreparedStatement countStmt = null;
                ResultSet rs = null;
                int totalCount = 0;
                try {
                    countStmt = connection.prepareStatement(countSql);
                    countStmt.setObject(1,ab.getBillId());
                    rs = countStmt.executeQuery();
                    if (rs.next()) {
                        totalCount = rs.getInt(1);
                    }
                } catch (SQLException e) {
                    System.out.println("Ignore this exception"+e);
                } finally {
                    try {
                        rs.close();
                        countStmt.close();
                    } catch (SQLException e) {
                        System.out.println("Ignore this exception"+ e);
                    }
                }
                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
                //绑定count
                basePojo.setCount(totalCount);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof StatementHandler){
            return Plugin.wrap(target,this);
        }else{
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }

    public String concatCountSql(String sql){
        StringBuffer sb=new StringBuffer("select count(*) from ");
        sql = sql.toLowerCase();
        if(sql.lastIndexOf("order")>sql.lastIndexOf(")")){
            sb.append(sql.substring(sql.indexOf("from")+4, sql.lastIndexOf("order")));
        }else{
            sb.append(sql.substring(sql.indexOf("from")+4));
        }
        return sb.toString();
    }

    public String concatPageSql(String sql,BasePojo basePojo){
        StringBuffer sb = new StringBuffer();
        sb.append(sql);
        sb.append(" limit ").append(basePojo.getPagebegin()).append(" , ").append(basePojo.getPagesize());
        return sb.toString();
    }

    public void setPageCount(){

    }



}
