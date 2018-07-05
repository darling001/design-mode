package com.gupao.vip.mapper;

import com.gupao.vip.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/5/30
 * Time: 20:14
 * Description:
 */
@Repository
public interface UserMapper {

    User selectUserAndRole1(@Param(value = "userId") String userId);

    User selectUserAndRole2(@Param(value = "userId") String userId);


}
