package com.ford.security.core.authorize;

import com.ford.security.core.enums.SecurityConstants;
import com.ford.security.core.properties.BrowserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 核心模块的授权配置提供器,安全模块涉及的url的授权配置在这里
 *
 * @author tom fang
 */
@Component
@Order(Integer.MIN_VALUE)  //确保先读取权限模块内的配置
public class FordAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private BrowserProperties browserProperties;

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers(
                SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                browserProperties.getLoginPage(),
                SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                SecurityConstants.GITHUB_LOGIN,
                browserProperties.getSignUpUrl(),
                browserProperties.getSession().getSessionInvalidUrl(),
                browserProperties.getSignOutUrl())
                .permitAll();
        return true;
    }
}
