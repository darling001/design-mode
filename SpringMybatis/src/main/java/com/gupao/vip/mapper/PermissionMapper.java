package com.gupao.vip.mapper;

import com.gupao.vip.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/5/31
 * Time: 11:09
 * Description:
 */
public interface PermissionMapper {

    List<Permission> selectPermissionByRoleId(@Param(value = "roleId") String roleId);
}
