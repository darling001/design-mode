package com.gupao.vip;

import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/13
 * Time: 14:12
 * Description:
 */
public class tokenizeToStringArray {

        public static void main(String[] args){
        String CONFIG_LOCATION_DELIMITERS = ",; \t\n";
        String a = "aaa;com.gupao.vip.bbbb,cccc\taass";
        Object [] arrays = StringUtils.tokenizeToStringArray(a, CONFIG_LOCATION_DELIMITERS);
        for(Object o : arrays){
            System.out.println(o);
        }
    }


}
