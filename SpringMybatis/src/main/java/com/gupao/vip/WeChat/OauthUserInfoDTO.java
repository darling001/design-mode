package com.gupao.vip.WeChat;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/2
 * Time: 9:59
 * Description: oauth方式获取微信用户信息的DTO参数
 */
@Getter
@Setter
public class OauthUserInfoDTO {

    /**
     * 换取微信信息的code
     */
    private String code;

    /**
     * 推广渠道的状态
     */
    private String state;
}
