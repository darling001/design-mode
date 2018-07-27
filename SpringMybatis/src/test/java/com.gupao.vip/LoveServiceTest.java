package com.gupao.vip;

import com.gupao.vip.annotationAspect.LoveService;
import org.aspectj.lang.annotation.AfterReturning;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/7/27
 * Time: 14:27
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/app*.xml"})
public class LoveServiceTest {

    @Autowired
    LoveService loveService;

    @Test
    public void add(){
        loveService.add();
    }
}
