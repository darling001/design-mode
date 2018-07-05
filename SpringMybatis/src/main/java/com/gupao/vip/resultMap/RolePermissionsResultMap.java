package com.gupao.vip.resultMap;


import com.gupao.vip.pojo.Permission;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/5/31
 * Time: 10:49
 * Description:
 */
@Data
public class RolePermissionsResultMap {

    private String roleId;

    private String roleName;

    private String userId;

    private List<Permission> permissionList;


}
