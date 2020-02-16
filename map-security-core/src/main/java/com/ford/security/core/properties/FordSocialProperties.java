package com.ford.security.core.properties;

import lombok.Data;

/**
 * @author : tom fang
 * @date : 2020/2/15 20:45
 * Description:
 */
@Data
public class FordSocialProperties {
    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WeiXinProperties weixin = new WeiXinProperties();
}
