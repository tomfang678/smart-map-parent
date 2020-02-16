package com.ford.security.core.social.github.connect;

import com.ford.security.core.social.github.api.Github;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author : tom fang
 * @date : 2019/8/7 20:29
 * Description: 组装ConnectionFactory对象---》ConnectionFactory对象由ServiceProvider和Adapter对象组成
 */
public class GithubConnectionFactory extends OAuth2ConnectionFactory<Github> {

    /**
     * 除了ServiceProvider和Adapter对象还需要一个providerId---》提供商的唯一标识
     *
     * @param providerId
     * @param appId
     * @param appSecret
     */
    public GithubConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new GithubServiceProvider(appId, appSecret), new GithubAdapter());
    }
}
