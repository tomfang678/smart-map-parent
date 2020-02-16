package com.ford.security.controller;

import com.ford.security.core.properties.FordSecurityProperties;
import com.ford.security.domain.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private FordSecurityProperties fordSecurityProperties;

    @GetMapping("/hello")
    public String sayHello() {
        return "hello spring-security";
    }

    @GetMapping("/me1")
    public Object getCurrentUser1() {
        //方式1，直接从SecurityContextHolder中拿到Authentication对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    @GetMapping("/me2")
    public Object getCurrentUser2(Authentication authentication, HttpServletRequest request) throws UnsupportedEncodingException {
        //方式2---方式1的简写版
        //从请求头中获取到JWT
        String token = StringUtils.substringAfter(request.getHeader("Authorization"), "bearer ");
        //对JWT进行解析,注意由于JWT生成时编码格式用的UTF-8（看源码可以追踪到）
        //但Jwts工具用到的默认编码格式不是，所以要设置其编码格式为UTF-8
        Claims claims = Jwts.parser()
                .setSigningKey(fordSecurityProperties.getOauth2().getJwtSigningKey().getBytes("UTF-8"))
                .parseClaimsJws(token).getBody();
        //取出扩展信息，并打印
        String company = (String) claims.get("ford");

        System.err.println(company);
        return authentication;
    }

    /**
     * 获取用户认证信息
     * 同getCurrentAuthentication spring 会帮我们注入
     *
     * @param authentication
     * @return
     */
    @GetMapping("authentication/auto")
    public Authentication getCurrentAuthentication2(Authentication authentication) {
        return authentication;
    }

    /**
     * 社交注册 regist
     */
    @PostMapping("/register")
    public void register(UserInfo user, HttpServletRequest request) {
        //注册用户相关逻辑-----》即向用户表里插入一条用户数据-----》这里不写了

        //不管是注册用户还是绑定用户，都会拿到一个用户唯一标识，如用户名。
        String userId = user.getUsername();
        //将用户userId和第三方用户信息建立关系并将其插入到userconnection表
        //providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));

        //使用我们自己的utils将用户userId和第三方用户信息建立关系、将该关系插入到userconnection表
        //和删掉redis中保存的deviceId信息
        //appSignUpUtils.doPostSignUp(new ServletWebRequest(request), userId);
    }
}
