package com.ford.security.security.validate;

import com.ford.security.core.validate.code.ValidateCodeGenerator;
import com.ford.security.core.validate.code.image.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created By: tom fang
 * Created Date: 2020/02/15 19:03
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
