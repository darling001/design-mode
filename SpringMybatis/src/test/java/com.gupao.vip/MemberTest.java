package com.gupao.vip;

import com.gupao.vip.aspect.MemberService;
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
 * Time: 11:10
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/app*.xml"})
public class MemberTest {

    @Autowired
    MemberService memberService;

    @Test
    public void add(){
        memberService.add();
    }

}
