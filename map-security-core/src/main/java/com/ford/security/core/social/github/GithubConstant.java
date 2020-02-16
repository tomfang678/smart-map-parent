package com.ford.security.core.social.github;

public class GithubConstant {
    // 这里填写在GitHub上注册应用时候获得 CLIENT ID
    public static final String  CLIENT_ID="e0cfc929b51669ca339e";
    //这里填写在GitHub上注册应用时候获得 CLIENT_SECRET
    public static final String CLIENT_SECRET="464e043912c3d07807a53f5880a6da8071fe4900";
    // 回调路径
    public static final String CALLBACK = "http://localhost:8081/callback";

    //获取code的url
    public static final String CODE_URL = "https://github.com/login/oauth/authorize?client_id="+CLIENT_ID+"&state=STATE&redirect_uri="+CALLBACK+"";
    //获取token的url
    public static final String TOKEN_URL = "https://github.com/login/oauth/access_token?client_id="+CLIENT_ID+"&client_secret="+CLIENT_SECRET+"&code=CODE&redirect_uri="+CALLBACK+"";
    //获取用户信息的url
    public static final String USER_INFO_URL = "https://api.github.com/user?access_token=TOKEN";

    String str="https://github.com/login/oauth/authorize?client_id=e0cfc929b51669ca339e&state=STATE&redirect_uri=http://localhost:8081/callback;";
}
