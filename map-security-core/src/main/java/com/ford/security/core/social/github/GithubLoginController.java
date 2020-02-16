package com.ford.security.core.social.github;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class GithubLoginController {

    //回调地址
    @RequestMapping("/callback")
    public String callback(String code, String state, Model model, HttpServletRequest req) throws Exception {

        if (!StringUtils.isEmpty(code) && !StringUtils.isEmpty(state)) {
            //拿到我们的code,去请求token
            //发送一个请求到
            String token_url = GithubConstant.TOKEN_URL.replace("CODE", code);
            //得到的responseStr是一个字符串需要将它解析放到map中
            String responseStr = HttpClientUtils.doGet(token_url);
            // 调用方法从map中获得返回的--》 令牌
            String token = HttpClientUtils.getMap(responseStr).get("access_token");

            //根据token发送请求获取登录人的信息  ，通过令牌去获得用户信息
            String userinfo_url = GithubConstant.USER_INFO_URL.replace("TOKEN", token);
            responseStr = HttpClientUtils.doGet(userinfo_url);//json
            Map<String, String> responseMap = HttpClientUtils.getMapByJson(responseStr);
            // 成功则登陆
            return "/index.html";
        }
        // 否则返回到登陆页面
        return "/login.html";
    }
}
