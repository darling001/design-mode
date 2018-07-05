package com.gupao.vip;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/12
 * Time: 9:39
 * Description:
 */

public class FinalStringTest {

    private final String a = "function";

    private String b = "bbb";

    @Test
    public void finalString(){

    }

    public static void main(String[] args) {
        String dateStr = "2018-04-10";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sf.parse(dateStr);
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
