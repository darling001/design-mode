package com.gupao.vip.WeChat;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/2
 * Time: 10:02
 * Description: oauth方式获取微信用户信息的返回结果
 */
@Getter
@Setter
public class GetOauthUserInfoVO {

    /**
     * 用户的accessToken
     */
    private String accessToken;

    /**
     * 关注者唯一标识码，微信提供
     */
    private String openId;

    /**
     * 关注状态：0.未关注 1.已关注
     */
    private int subscribeType;

    /**
     * 绑定状态：0.未绑定 1.已绑定
     */
    private int bindType;

    /**
     * 用户手机号码
     */
    private String phone;
}
