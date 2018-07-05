package com.gupao.vip;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/14
 * Time: 13:45
 * Description:
 */
public class PageHandler {

    private static final int PAGE_NO = 1;
    private static final int PAGE_SIZE = Integer.MAX_VALUE;

    private static Map<String, Integer> pageParamMap = new HashMap<>();

    static {
        pageParamMap.put("pageNo",PAGE_NO);
        pageParamMap.put("pageSize", PAGE_SIZE);
    }

    public static void pageSet(Integer pageNo, Integer pageSize) {
        pageParamMap.put("pageNo", pageNo);
        pageParamMap.put("pageSize", pageSize);
    }


}
