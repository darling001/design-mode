package com.gupao.vip.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/4
 * Time: 16:54
 * Description:
 */
public class MyListTest {

    public static void main(String[] args) {
        List<Long> numbers = new ArrayList<Long>();

        Collections.sort(numbers, new Comparator<Long>() {
            public int compare(Long o1, Long o2) {
                return 0;
            }
        });
    }
}
