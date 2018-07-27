package com.gupao.vip.annotationAspect;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/27
 * Time: 14:27
 * Description:
 */
@Service
public class LoveService {

    public void add(){
        System.out.println("这是添加的方法!");
    }


}
