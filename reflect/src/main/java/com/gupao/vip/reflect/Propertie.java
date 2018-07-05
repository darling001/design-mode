package com.gupao.vip.reflect;


import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 16:27
 * Description: 通过反射运行配置文件内容
 */
public class Propertie {

    public static void main(String[] args) throws Exception {

        String PackageName = getValue("PackageName");
        String ClassName = getValue("ClassName");
        Class clazz = Class.forName(PackageName+"."+ClassName);
        Method method = clazz.getMethod(getValue("MethodName"));
        method.invoke(clazz.newInstance());

    }



    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();//获取配置文件的对象
        FileReader in = new FileReader("D:\\GrowingProject\\composite\\reflect\\src\\main\\resources\\file.properties");//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }
}
