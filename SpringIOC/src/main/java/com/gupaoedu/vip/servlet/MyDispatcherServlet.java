package com.gupaoedu.vip.servlet;

import com.gupaoedu.vip.context.MyApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/9
 * Time: 11:01
 * Description:
 */
public class MyDispatcherServlet extends HttpServlet {

    private static final String LOCATION = "contextConfigLocation";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    //在这里调用自己写的Controller的方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收请求完毕!");
    }



    //初始化容器
    @Override
    public void init(ServletConfig config) throws ServletException {
        MyApplicationContext applicationContext = new MyApplicationContext(config.getInitParameter(LOCATION));
        System.out.println("IOC 初始化 success!");
    }
}
