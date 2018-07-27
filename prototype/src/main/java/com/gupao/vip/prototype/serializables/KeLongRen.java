package com.gupao.vip.prototype.serializables;



import java.io.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/6
 * Time: 16:34
 * Description:
 */
public class KeLongRen extends People implements Cloneable,Serializable{

    public String name;

    public Telephone telephone;

    public KeLongRen() {
        this.birthday = new Date();
        this.telephone = new Telephone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    public Object deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            KeLongRen k = (KeLongRen)ois.readObject();
            return k;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
