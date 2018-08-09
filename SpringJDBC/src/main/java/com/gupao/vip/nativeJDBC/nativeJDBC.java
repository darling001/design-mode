package com.gupao.vip.nativeJDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/3
 * Time: 10:47
 * Description:
 */
public class nativeJDBC {
    public static void main(String[] args) {
        //原生的JDBC如何操作?
        try {
            //1、加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //2、建立连接
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gp","root","123456");
            //3、创建语句集
            PreparedStatement pstm = con.prepareStatement("select * from people");
            //4、执行语句集
            ResultSet rs = pstm.executeQuery();
            //5、获取结果集
            while (rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getString("sex"));
                System.out.println(rs.getString("job"));
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

