package com.gupao.vip.mybatis.v2.executor.statement;

import com.gupao.vip.mybatis.v2.executor.result.ResultHandler;
import com.gupao.vip.mybatis.v2.session.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 15:38
 * Description:
 */
public class SimpleStatementHandler extends BaseStatementHandler{

    private Configuration configuration = new Configuration();

    private final String className = "com.mysql.jdbc.Driver";

    private final String url = "jdbc:mysql://127.0.0.1:3306/gp";

    private final String user = "root";

    private final String password = "123456";

    public SimpleStatementHandler(String sql, Object parameterObject, Configuration configuration) {
        super(sql, parameterObject, configuration);
    }

//    public <T> T query(MapperRegistry.MapperData mapperData, Object parameter) {
//        Connection connection = null;
//        PreparedStatement pstm = null;
//        try {
//            connection = getConnection();
//            String statement = mapperData.getSql();
//            pstm = connection.prepareStatement(String.format(statement, Integer.parseInt(String.valueOf(parameter))));
//            ResultSet rs = pstm.executeQuery();
//            ResultHandler resultHandler = new ResultHandler();
//            return (T)resultHandler.query(rs, mapperData.getClassType());
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if(null!=connection){
//                    connection.close();
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }

    public <T> T query(String statement, Class<?> classType, Object parameter) {
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = getConnection();
            pstm = connection.prepareStatement(statement);
            pstm.setInt(1,Integer.parseInt(String.valueOf(parameter)));
            ResultSet rs = pstm.executeQuery();
            ResultHandler resultHandler = configuration.newResultHandler();
            return (T)resultHandler.query(rs, classType);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(null!=connection){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }



    public Connection getConnection() throws Exception {
        Class.forName(className);
        Connection conn = DriverManager.getConnection(url,user, password);
        return conn;
    }
}
