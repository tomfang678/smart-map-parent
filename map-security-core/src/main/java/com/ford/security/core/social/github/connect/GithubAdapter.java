package com.ford.security.core.social.github.connect;

import com.ford.security.core.social.github.api.Github;
import com.ford.security.core.social.github.api.GithubInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author : tom fang
 * @date : 2019/8/7 20:21
 * Description:
 */
public class GithubAdapter implements ApiAdapter<Github> {
    /**
     * 用来测试当前服务是否是通的，这里假设服务一直是通的
     *
     * @param api
     * @return
     */
    @Override
    public boolean test(Github api) {
        return true;
    }

    /**
     *
     * 将我们从QQ获取的用户信息设置成Connection对象相对应的字段信息
     * 记住：connection对象的字段是固定的
     * @param api
     * @param values
     */
    @Override
    public void setConnectionValues(Github api, ConnectionValues values) {
        GithubInfo userInfo = api.getUserInfo();
        values.setDisplayName(userInfo.getLogin());
        values.setImageUrl(null);
        values.setProfileUrl(null);
        values.setProviderUserId(userInfo.getId());
    }

    /**
     * 同上面的方法一样也是通过api拿到一个标准的用户信息---》之后会讲
     * @param api
     * @return
     */
    @Override
    public UserProfile fetchUserProfile(Github api) {
        return null;
    }

    /***
     * 微博等更新主页信息---这里不用管
     * @param api
     * @param message
     */
    @Override
    public void updateStatus(Github api, String message) {
        //do nothing
    }
}
