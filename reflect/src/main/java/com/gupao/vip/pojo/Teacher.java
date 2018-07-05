package com.gupao.vip.pojo;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/27
 * Time: 14:27
 * Description:
 */
public class Teacher extends Daddy implements Father,Mother{

    public int id;

    private String name;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Teacher() {
    }

    public class Age{

    }

    public interface size{

    }
}
