package com.ford.security.core.properties;

import com.ford.security.core.social.configutils.SocialProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : tom fang
 * @date : 2020/2/15 22:33
 * Description：
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WeiXinProperties extends SocialProperties {
    private String providerId = "weixin";
}
