package com.ford.security.core.social.qq.config;

import com.ford.security.core.properties.FordSecurityProperties;
import com.ford.security.core.properties.QQProperties;
import com.ford.security.core.social.configutils.SocialAutoConfigurerAdapter;
import com.ford.security.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@ConditionalOnProperty(prefix = "ford.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Resource
    private FordSecurityProperties fordSecurityProperties;

    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = fordSecurityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
    }

//    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
//    @ConditionalOnMissingBean(name = "weixinConnectedView")
//    public View weixinConnectedView() {
//        return new NrscConnectView();
//    }

}
