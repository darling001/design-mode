package com.gupao.vip.myProxy;

import com.gupao.vip.Person;
import com.gupao.vip.Zhangsan;
import com.gupao.vip.jdk.MeiPo;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/2
 * Time: 17:30
 * Description:
 */
public class TestGPFindLove {

    public static void main(String[] args) throws IOException {
        Person person = (Person)new GPMeipo().getInstance(new Zhangsan());
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
