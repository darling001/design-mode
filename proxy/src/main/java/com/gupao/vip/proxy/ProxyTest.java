package com.gupao.vip.proxy;

import com.gupao.vip.pojo.Person;
import com.gupao.vip.pojo.Student;
import com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationPerORB;
import sun.misc.ProxyGenerator;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/28
 * Time: 9:53
 * Description:
 */
public class ProxyTest {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        Person student = new Student();
        Person p = (Person)new Agency().getInstance(student);
        System.out.println(p.getClass());
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\GrowingProject\\proxy.class");
        fileOutputStream.write(bytes);
        fileOutputStream.close();








    }
}
