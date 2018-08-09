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
public class GetOauthUserInfoDTO {



    /**
     * 账户的id,绑定用户之后存在此字段
     */
    private String accountId;

    /**
     * 关注状态：0.未关注 1.关注
     */
    private String subscribeType;

    /**
     * 用户手机号码
     */
    private String phone;


}
