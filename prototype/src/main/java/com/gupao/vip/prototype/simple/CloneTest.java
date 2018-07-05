package com.gupao.vip.prototype.simple;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 17:12
 * Description:
 */
public class CloneTest {

    public static void main(String[] args) {
        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(23);
        cp.setName("haha");
        cp.list.add("xixi");
        ConcretePrototype copy = null;
        try {
            copy = (ConcretePrototype)cp.clone();
            System.out.println(copy == cp);
            System.out.println(cp.getAge() == copy.getAge());
            System.out.println(cp.getName() == copy.getName());
            System.out.println(cp.list == copy.list);
            System.out.println(copy.getAge());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        copy.setName("aa");
        System.out.println(copy.getName());
        System.out.println(cp.getName());
//        System.out.println(cp.getName());






    }
}
