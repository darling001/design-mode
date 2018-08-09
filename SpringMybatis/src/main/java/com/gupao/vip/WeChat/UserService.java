package com.gupao.vip.WeChat;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/2
 * Time: 10:14
 * Description:
 */
public interface UserService {

    public GetOauthUserInfoVO getOauthUserInfo(OauthUserInfoParam command);

}
