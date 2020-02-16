package com.ford.security.core.social.weixin.api;

/**
 * @author : tom fang
 * @date : 2020/2/15 22:45
 * Description：
 */
public interface WeiXin {

    // QQ是获取完accessToken，然后拿着accessToken去换openId
    // 微信是在获取accessToken的同时也会获取到openId

    WeiXinUserInfo getUserInfo(String openId);
}
