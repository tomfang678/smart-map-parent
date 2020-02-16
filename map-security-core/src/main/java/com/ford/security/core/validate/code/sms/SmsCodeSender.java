package com.ford.security.core.validate.code.sms;

/**
 * @author: tom fang
 * @date: 2020/2/15 19:46
 * Description: 短信发送接口 ----  不同供应商可能不同
 */
public interface SmsCodeSender {

    /**
     * 向手机发送短信验证码
     *
     * @param mobile
     * @param code
     */
    void send(String mobile, String code);
}
