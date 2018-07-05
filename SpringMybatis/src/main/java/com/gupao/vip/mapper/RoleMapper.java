package com.gupao.vip.mapper;


import com.gupao.vip.pojo.Role;
import com.gupao.vip.resultMap.RolePermissionsResultMap;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

    Role selectByPrimaryKey(@Param(value = "roleId") String roleId);

    RolePermissionsResultMap selectRolePermissions(@Param(value = "roleId") String roleId);

}