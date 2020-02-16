package com.ford.security.app.config;

import com.ford.security.app.social.openid.OpenIdAuthenticationSecurityConfig;
import com.ford.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.ford.security.core.properties.FordSecurityProperties;
import com.ford.security.core.enums.SecurityConstants;
import com.ford.security.core.social.SocialConfig;
import com.ford.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author : tom fang
 * @date : 2019/10/15 10:57
 * Description: 资源服务器
 */
@Configuration
@EnableResourceServer
public class FordResourcesServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    //openId校验配置类
    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    /**
     * @see SocialConfig#nrscSocialSecurityConfig()
     */
    @Autowired
    private SpringSocialConfigurer springSocialSecurityConfig;


    @Autowired
    private FordSecurityProperties fordSecurityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler);

        //将验证码校验逻辑放开
        http.apply(validateCodeSecurityConfig)
                .and()
                    .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                    .apply(springSocialSecurityConfig)
                .and()
                    .apply(openIdAuthenticationSecurityConfig)
                .and()
                    .authorizeRequests()
                    .antMatchers(
                            SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                            SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                            SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_OPENID,
                            fordSecurityProperties.getBrowser().getLoginPage(),
                            SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
                            fordSecurityProperties.getBrowser().getSignUpUrl(),
                            fordSecurityProperties.getBrowser().getSession().getSessionInvalidUrl(),
                            fordSecurityProperties.getBrowser().getSignOutUrl(),
                            "/user/register","/social/signUp")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .csrf().disable();
    }
}
