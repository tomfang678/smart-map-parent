package com.ford.security.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MapHistory {
    private Integer Id;
    private String userId;
    private Date createTime;
    /**
     * map search 返回
     */
    private String title;
    private String point;
    private String url;
    private String detailUrl;
    private String province;
    private String city;
    private String address;
    private String distance;
    private String phoneNumber;
    private String postcode;
    /**
     * tag 0: 福特4s店 ，1 加油站
     */
    private String tag;

    private Integer times;
}
