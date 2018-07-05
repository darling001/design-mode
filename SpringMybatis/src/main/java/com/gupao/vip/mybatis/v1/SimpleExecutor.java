package com.gupao.vip.mybatis.v1;
import com.gupao.vip.pojo.People;

import java.sql.*;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/21
 * Time: 10:17
 * Description:
 */
public class SimpleExecutor implements Executor {


    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gp","root", "123456");
        return conn;
    }

    public <T> T selectOne(String statement, Object parameter) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement pstm;
            pstm = connection.prepareStatement(String.format(statement,Integer.parseInt(String.valueOf(parameter))));
            ResultSet rs = pstm.executeQuery();
            People people = new People();
            while (rs.next()){
                people.setId(rs.getInt(1));
                people.setName(rs.getString(2));
                people.setAge(rs.getInt(3));
                people.setSex(rs.getString(4));
                people.setJob(rs.getString(5));
            }
            return (T)people;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }




}
