package com.gupao.vip.jdk;

import com.gupao.vip.Person;
import com.gupao.vip.Zhangsan;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/2
 * Time: 16:19
 * Description:
 */
public class TestFindLove {

    public static void main(String[] args) {
        Person person = (Person)new MeiPo().getInstance(new Zhangsan());
        System.out.println(person.getClass());
        System.out.println(person);
        person.findLove();
        try {
        //获取字节码内容
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        FileOutputStream os = null;
        os = new FileOutputStream("D:\\$Proxy0.class");
        os.write(data);
        os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
