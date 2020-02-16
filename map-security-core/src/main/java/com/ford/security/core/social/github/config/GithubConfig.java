package com.ford.security.core.social.github.config;

import com.ford.security.core.properties.FordSecurityProperties;
import com.ford.security.core.properties.GithubProperties;
import com.ford.security.core.properties.QQProperties;
import com.ford.security.core.social.configutils.SocialAutoConfigurerAdapter;
import com.ford.security.core.social.github.connect.GithubConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

import javax.annotation.Resource;

/**
 * @author : tom fang
 * @date : 2019/8/7 20:38
 * Description:
 */
@Configuration
@ConditionalOnProperty(prefix = "ford.security.social.github", name = "client_id")
public class GithubConfig extends SocialAutoConfigurerAdapter {

    @Resource
    private FordSecurityProperties fordSecurityProperties;

    protected ConnectionFactory<?> createConnectionFactory() {
        GithubProperties githubProperties = fordSecurityProperties.getSocial().getGithub();
        return new GithubConnectionFactory(githubProperties.getProviderId(), githubProperties.getAppId(), githubProperties.getAppSecret());
    }

//    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
//    @ConditionalOnMissingBean(name = "weixinConnectedView")
//    public View weixinConnectedView() {
//        return new NrscConnectView();
//    }

}
