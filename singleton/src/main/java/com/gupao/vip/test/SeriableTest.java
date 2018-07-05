package com.gupao.vip.test;


import com.gupao.vip.seriable.Seriable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Tom on 2018/3/8.
 */
public class SeriableTest {
    public static void main(String[] args) {

        Seriable s1 = null;
        Seriable s2 = Seriable.getInstance();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Seriable.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();


            FileInputStream fis = new FileInputStream("Seriable.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (Seriable)ois.readObject();
            ois.close();

            s1.name = "1";
            System.out.println(s1.name);
            System.out.println(s2.name);
            System.out.println(s1 == s2);
            s1.name = "11";
            System.out.println(s1.name);
            System.out.println(s2.name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
