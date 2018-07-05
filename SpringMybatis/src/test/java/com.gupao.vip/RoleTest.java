package com.gupao.vip;

import com.gupao.vip.mapper.RoleMapper;
import com.gupao.vip.resultMap.RolePermissionsResultMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/5/31
 * Time: 15:21
 * Description:
 */
//@Ignore //不希望执行
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/app*.xml"})
public class RoleTest {

    @Autowired
    RoleMapper roleMapper;

    /**
     * N+1问题，通过懒加载解决的示例
     * @throws Exception
     */
    @Test
    public void roleDemo() throws Exception {
        RolePermissionsResultMap role = roleMapper.selectRolePermissions("1");
        System.out.println(role.getRoleName());
        Thread.sleep(5000);
        System.out.println(role.getPermissionList());
    }
}
