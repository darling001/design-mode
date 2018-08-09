package com.gupao.vip.WeChat;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/2
 * Time: 9:57
 * Description: oauth方式获取微信用户信息的接收参数
 */
@Getter
@Setter
public class OauthUserInfoParam {

    /**
     * 换取微信信息的code
     */
    @NotBlank(message = "code不能为空")
    private String code;

    /**
     * 推广渠道的状态
     */
    @NotBlank(message = "state不能为空")
    private String state;
}
