/*
package com.ford.security.config;

import com.ford.security.core.enums.SecurityConstants;
import com.ford.security.core.properties.FordSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    */
/**
     * Configure.
     *
     * @param http the http
     * @throws Exception the exception
     *//*

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/login.html").permitAll()
                //任何请求 都需要身份认证
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页的路径
                // .loginPage("/hello")
                //指定自定义form表单请求的路径
                //.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_OPENID)
                //.loginProcessingUrl("/authentication/form")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/index.html")
                //必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
                //这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
                .permitAll();
        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        http.csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

}
*/
