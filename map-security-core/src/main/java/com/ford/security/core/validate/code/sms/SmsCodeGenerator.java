package com.ford.security.core.validate.code.sms;

import com.ford.security.core.properties.FordSecurityProperties;
import com.ford.security.core.validate.code.ValidateCode;
import com.ford.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author: tom fang
 * @date: 2020/2/15 12:29
 * @Description: 注意验证码+ 超时时间可以进行配置
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private FordSecurityProperties nrscSecurityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(nrscSecurityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, nrscSecurityProperties.getCode().getSms().getExpireIn());
    }
}
