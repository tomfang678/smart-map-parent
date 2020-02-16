package com.ford.security.domain;


import lombok.Data;

import java.util.Date;

/**
 * 该类就是实际生产中我们自己的user类了,它对应于我们数据库中的用户信息表
 */
@Data
public class UserInfo {

    private String username;

    private String password;

    private Date birthday;

    /**
     * 电话
     */
    private String mobile;

    /**
     * email
     */
    private String email;

}
