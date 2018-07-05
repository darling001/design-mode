package com.gupao.vip;


import com.gupao.vip.mapper.PermissionMapper;
import com.gupao.vip.pojo.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.util.List;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/5/31
 * Time: 15:27
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/app*.xml"})
public class PermissionTest {

    @Autowired
    PermissionMapper permissionMapper;


    @Test
    public void PermissionTest() throws FileNotFoundException {
        List<Permission> permissionList = permissionMapper.selectPermissionByRoleId("1");
        System.out.println(permissionList);
    }
}
