package com.gupao.vip.service.impl;

import com.gupao.vip.mapper.UserMapper;
import com.gupao.vip.pojo.User;
import com.gupao.vip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/5
 * Time: 16:06
 * Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public User selectUserAndRole1(String userId) {
        return userMapper.selectUserAndRole1(userId);
    }



}
