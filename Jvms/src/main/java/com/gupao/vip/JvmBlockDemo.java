package com.gupao.vip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/29
 * Time: 9:36
 * Description:
 */
public class JvmBlockDemo {

    private static List<int[]> bigObj = new ArrayList<int[]>();

    private static List<char[]> bigCharObj = new ArrayList<char[]>();

    public static int[] generate1M(){
        return new int[1024 * 256 * 40 ];
    }

    public static char[] generate1MChar(){
        return new char[1024 * 1024];
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        int i = 0;
        while (i<1000){
            if(i==0){
                Thread.sleep(5001);
                System.out.println("start = [" + new Date() + "]");
            }else{
                Thread.sleep(4001);
            }
            bigObj.add(generate1M());
                i++;
        }
        System.in.read();
    }
}
