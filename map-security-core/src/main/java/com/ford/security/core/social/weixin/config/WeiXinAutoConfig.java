package com.ford.security.core.social.weixin.config;

import com.ford.security.core.properties.FordSecurityProperties;
import com.ford.security.core.properties.WeiXinProperties;
import com.ford.security.core.social.FordConnectView;
import com.ford.security.core.social.configutils.SocialAutoConfigurerAdapter;
import com.ford.security.core.social.weixin.connect.WeiXinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;

/**
 * @author : tom fang
 * @date : 2020/2/15 22:56
 * Description：将微信连接工厂注入到spring容器
 */
@Configuration
@ConditionalOnProperty(prefix = "ford.security.social.weixin", name = "app-id")
public class WeiXinAutoConfig extends SocialAutoConfigurerAdapter {

    @Resource
    private FordSecurityProperties fordSecurityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeiXinProperties weiXinProperties = fordSecurityProperties.getSocial().getWeixin();
        return new WeiXinConnectionFactory(weiXinProperties.getProviderId(), weiXinProperties.getAppId(),
                weiXinProperties.getAppSecret());
    }

    /***
     * connect/weixinConnected 绑定成功的视图
     * connect/weixinConnect 解绑的视图
     *
     * 两个视图可以写在一起，通过判断Model对象里有没有Connection对象来确定究竟是解绑还是绑定
     */
    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
    //下面的注解的意思是当程序里有名字为weixinConnectedView的bean
    // 我写的默认的weixinConnectedView这个bean不会生效，也就是你可以写一个更好的bean来覆盖掉我的
    @ConditionalOnMissingBean(name = "weixinConnectedView")
    public View weixinConnectedView() {
        return new FordConnectView();
    }

}
