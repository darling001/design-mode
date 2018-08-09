package com.gupao.vip.reinforceJDBC;



import com.gupao.vip.People;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/3
 * Time: 9:57
 * Description: 加强版JDBC
 */
public class reinforceJDBC {

    public static void main(String[] args) {
        //原生的JDBC如何操作?
        try {
            //被封装成了DataSource，放入到了连接池
            //目的是为了提高程序响应速度
            //C3P0 DBCP
            //1、加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //2、建立连接
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gp","root","123456");


            //3、创建语句集
            PreparedStatement pstm = con.prepareStatement("select * from people");
            //4、执行语句集
            ResultSet rs = pstm.executeQuery();



            //封装了，做成了一个ORM的过程
            //Object Relation Mapping 对象关系映射
            //自动变成一个我们显而易见的普通的我们写的Java对象（实体类）

            int len = rs.getMetaData().getColumnCount();
            //5、获取结果集
            List<Object> list = new ArrayList<Object>();
            while (rs.next()){
                Class clazz = People.class;
                Object people = clazz.newInstance();
                for(int i=1;i<=len;i++){
                    String columnName = rs.getMetaData().getColumnName(i);
                    Field field = clazz.getDeclaredField(columnName);
                    //前提条件是属性名和字段名一致（约定）
                    field.setAccessible(true);
                    Class type = field.getType();
                    if(type == Integer.class){
                        field.set(people,rs.getInt(columnName));
                    }else{
                        field.set(people,rs.getString(columnName));
                    }
                    list.add(people);
                }
                System.out.println(people);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
