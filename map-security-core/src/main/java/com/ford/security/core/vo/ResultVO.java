package com.ford.security.core.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * Created By: tom fang
 * Created Date: 2020/2/1519:26
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -2512067269292159149L;

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
