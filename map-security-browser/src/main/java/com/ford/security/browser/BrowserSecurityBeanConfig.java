package com.ford.security.browser;

import com.ford.security.browser.logout.FordLogoutSuccessHandler;
import com.ford.security.browser.session.FordExpiredSessionStrategy;
import com.ford.security.browser.session.FordInvalidSessionStrategy;
import com.ford.security.core.properties.FordSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @author : tom fang
 * @date : 2019/9/21 21:01
 * Description：
 */
@Configuration
public class BrowserSecurityBeanConfig {

    @Autowired
    private FordSecurityProperties fordSecurityProperties;

    @Bean
    //用户可以通过实现一个InvalidSessionStrategy类型的bean来覆盖掉默认的实现--》NRSCInvalidSessionStrategy
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy(){
        return new FordInvalidSessionStrategy(fordSecurityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
        return new FordExpiredSessionStrategy(fordSecurityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

    @Bean
    @ConditionalOnMissingBean(LogoutSuccessHandler.class)
    public LogoutSuccessHandler logoutSuccessHandler(){
        return new FordLogoutSuccessHandler(fordSecurityProperties.getBrowser().getSignOutUrl());
    }
}
