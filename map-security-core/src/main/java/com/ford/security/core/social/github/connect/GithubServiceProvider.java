package com.ford.security.core.social.github.connect;

import com.ford.security.core.social.github.api.Github;
import com.ford.security.core.social.github.api.GithubImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @author : tom fang
 * @date : 2019/8/5 23:47
 * Description：利用利用Api和Oauth2Operation对象组装ServiceProvider对象
 */
public class GithubServiceProvider extends AbstractOAuth2ServiceProvider<Github> {

    private String appId;

    /**
     *  "https://github.com/login/oauth/authorize?client_id="+CLIENT_ID+"&state=STATE&redirect_uri="+CALLBACK+"";
     * 对应于OAuth2协议第一步,即将用户导向QQ认证授权页面的url
     */
    private static final String URL_AUTHORIZE = "https://github.com/login/oauth/authorize";

    /**
     * "https://github.com/login/oauth/access_token?client_id="+CLIENT_ID+"&client_secret="+CLIENT_SECRET+"&code=CODE&redirect_uri="+CALLBACK+"";
     * 对应于Oauth2协议中拿着授权码获取Access Token这一步的url
     */
    private static final String URL_ACCESS_TOKEN = "https://github.com/login/oauth/access_token";

    /**
     * 必须要有一个构造,否则会报错
     *
     * @param appId
     * @param appSecret
     */
    public GithubServiceProvider(String appId, String appSecret) {
        /**
         * 用我们自己的QQOAuth2Template对象来构建ServiceProvider对象
         */
        super(new GithubOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public Github getApi(String accessToken) {
        return new GithubImpl(accessToken, appId);
    }


}
