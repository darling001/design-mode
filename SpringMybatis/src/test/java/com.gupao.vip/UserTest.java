package com.gupao.vip;

import com.gupao.vip.mapper.UserMapper;
import com.gupao.vip.pojo.User;
import com.gupao.vip.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/5/31
 * Time: 15:20
 * Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
        ({"/spring/app*.xml"})
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;


    @Test
    public void UserTest1嵌套查询() throws FileNotFoundException {
        User user = userService.selectUserAndRole1("1");
        System.out.println(user);
    }

    @Test
    public void UserTest2嵌套结果() throws FileNotFoundException {
        User user1 = userMapper.selectUserAndRole2("1");
        System.out.println(user1);
    }
}
