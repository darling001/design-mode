package com.gupao.vip;

import lombok.Data;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/28
 * Time: 15:44
 * Description:
 */
public class Student {

    private String name;

    private Integer id;

    public Student(String name) {
        this.name = name;
    }

    public Student(){
    }

    public Student(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) throws IOException {
        Student student = new Student();
        Student student1 = new Student();
        System.out.println(student);
        System.out.println(student1);
        byte [] a = ProxyGenerator.generateProxyClass("student",new Class[]{student.getClass()});

        File file = new File("D:\\GrowingProject\\student.class");
        if(file.exists()){
            file.delete();
        }
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\GrowingProject\\student.class");
        fileOutputStream.write(a);
        fileOutputStream.close();
    }
}
