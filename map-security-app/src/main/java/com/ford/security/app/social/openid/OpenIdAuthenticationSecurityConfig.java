package com.ford.security.app.social.openid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author : tom fang
 * @date : 2019/10/20 22:26
 * Description：校验openId的配置类---》将校验规则等配置到spring-security过滤器链中
 */
@Component
public class OpenIdAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationSuccessHandler fordAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler fordAuthenticationFailureHandler;

    @Autowired
    private SocialUserDetailsService fordDetailsService;

    @Autowired
    private UsersConnectionRepository nrscJdbcUsersConnectionRepository;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //UsersConnectionRepository usersConnectionRepository = new NrscJdbcUsersConnectionRepository();
        OpenIdAuthenticationFilter OpenIdAuthenticationFilter = new OpenIdAuthenticationFilter();
        OpenIdAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        OpenIdAuthenticationFilter.setAuthenticationSuccessHandler(fordAuthenticationSuccessHandler);
        OpenIdAuthenticationFilter.setAuthenticationFailureHandler(fordAuthenticationFailureHandler);

        OpenIdAuthenticationProvider OpenIdAuthenticationProvider = new OpenIdAuthenticationProvider();
        OpenIdAuthenticationProvider.setUserDetailsService(fordDetailsService);
        OpenIdAuthenticationProvider.setUsersConnectionRepository(nrscJdbcUsersConnectionRepository);

        http.authenticationProvider(OpenIdAuthenticationProvider)
                .addFilterAfter(OpenIdAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }
}