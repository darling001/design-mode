package com.gupao.vip;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/2
 * Time: 16:14
 * Description:
 */
public class Zhangsan implements Person {

    private String sex = "男";

    private String name = "张三";

    public void findLove() {
        System.out.println("我叫" + this.name + ",性别:" + this.sex);
        System.out.println("长的漂亮的");
        System.out.println("有房有车");
        System.out.println("白富美");
        System.out.println("身高1.6m，体重160kg");
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

}
