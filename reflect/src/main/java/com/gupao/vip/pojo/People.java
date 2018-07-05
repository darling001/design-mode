package com.gupao.vip.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 11:00
 * Description:
 */
@Data
public class People implements Serializable{

    public int id;

    public int age;

    @NotBlank(message = "姓名不能为空!",groups = {Student.class,Teacher.class})
    @NotEmpty(message = "hahaha")
    protected String name;

    String sex;

    private String job;

    public People() {
    }

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private People(int id) {
        this.id = id;
    }

    People(String name) {
        this.name = name;
    }

    protected People(int id, String name, String sex, String job) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.job = job;
    }

    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void findNameAndAge(String name, int age){
        System.out.println("姓名："+name+",年龄："+age);
    }

    public static void staticMethod(String name){
        System.out.println("姓名："+name);
    }
}
