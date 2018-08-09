package com.gupao.vip.WeChat;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/2
 * Time: 10:37
 * Description:
 */
@Component
public interface UserMapper {

    /**
     * 通过openId查询用户是否关注
     * @param openId
     * @return
     */
    public GetOauthUserInfoDTO getOauthUserInfoByOpenid(@Param("openId") String openId);
}
