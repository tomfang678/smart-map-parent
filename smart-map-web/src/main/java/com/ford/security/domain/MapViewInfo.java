package com.ford.security.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * map search return
 * <p>
 * [{"title":"中国石化加油站(川沙站)","point":"121.703297，31.206485",
 * "url":"http://map.baidu.com/?s=inf%26uid%3Dd146b388df9e61df7402697d%26c%3D289&i=0&sr=1",
 * "detailUrl":"http://api.map.baidu.com/place/detail?uid=d146b388df9e61df7402697d&output=html&source=jsapi",
 * "address":"上海市浦东新区华夏东路2311号","city":"上海市","province":"上海市","type":0,
 * "isAccurate":false,"distance":"692.58","keyword":"中石化加油站"}]
 */
@Slf4j
@Data
public class MapViewInfo {
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
    private String keyword;
    /**
     * tag 0: 福特4s店 ，1 加油站
     */
    private String tag;

    private Integer times;
}


