package com.ford.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/***
 * "大盒子"类-----------------用于统一管理项目中所有由yml或properties文件传入的变量值
 * @author : tom fang
 * @date : 2020/2/15 22:13
 */
@Service("fordSecurityProperties") //将此类注入到spring容器中
@Data //不用写get set方法了
@ConfigurationProperties(prefix = "system.security") //指定以 ford.security开头的配置会射入到该类中
public class FordSecurityProperties {
    /***封装浏览器相关的属性*/
    private BrowserProperties browser = new BrowserProperties();

    /***验证码相关的属性---可能包含图形验证码，短信验证码等，所以对其进行了又一次封装*/
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /***springsocial相关的配置*/
    private FordSocialProperties social = new FordSocialProperties();

    /***认证服务器相关的配置*/
    private Oauth2ServerProperties oauth2 = new Oauth2ServerProperties();

}
