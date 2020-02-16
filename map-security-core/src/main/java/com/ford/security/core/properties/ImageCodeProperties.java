package com.ford.security.core.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: tom fang
 * @date: 2020/02/15 16:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ImageCodeProperties extends SmsCodeProperties {

    /**验证码的宽度*/
    private int width = 67;

    /**验证码的高度*/
    private int height = 23;

    /**保证初始化ImageCodeProperties时length的默认值为4*/
    public ImageCodeProperties() {
        setLength(4);
    }
}
