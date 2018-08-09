package com.gupao.vip.WeChat;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/8/2
 * Time: 10:14
 * Description:
 */
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public GetOauthUserInfoVO getOauthUserInfo(OauthUserInfoParam command) {
        GetOauthUserInfoVO getOauthUserInfoVO = new GetOauthUserInfoVO();
        //TODO:1.验证参数不能为空

        //TODO:2.利用code调取接口获取access_token与openid
        String openId = null;
        String accessToken = null;

        if(openId==null){
            //openId为空的情况，用户未关注，前端需要提示微信用户去关注
            getOauthUserInfoVO.setSubscribeType(0);
            getOauthUserInfoVO.setBindType(0);
            return getOauthUserInfoVO;
        }
        GetOauthUserInfoDTO getOauthUserInfoDTO = userMapper.getOauthUserInfoByOpenid(openId);
        if(getOauthUserInfoDTO.getAccountId()==null){
            //accountId为空的情况，用户未绑定，前端需要提示微信用户去绑定
            getOauthUserInfoVO.setBindType(0);
        }else{
            //accountId不为空的情况，返回微信用户的信息
            getOauthUserInfoVO.setBindType(1);
            getOauthUserInfoVO.setPhone(getOauthUserInfoDTO.getPhone());
        }
        getOauthUserInfoVO.setOpenId(openId);
        getOauthUserInfoVO.setAccessToken(accessToken);
        return getOauthUserInfoVO;
    }

}
