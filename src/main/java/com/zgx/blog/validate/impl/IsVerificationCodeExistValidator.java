package com.zgx.blog.validate.impl;

import com.zgx.blog.validate.IsVerificationCodeExist;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 判断验证码是否与当前页面验证码一致
 *
 * @author Administrator
 * @version 1.0
 * @date 2019/9/17 14:29
 */
public class IsVerificationCodeExistValidator implements ConstraintValidator<IsVerificationCodeExist, String> {

    @Override
    public void initialize(IsVerificationCodeExist isVerificationCodeExist) {

    }


    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        //获取当前用户对象
        Subject subject = SecurityUtils.getSubject();
        //获取验证码
        String validateCode = (String) subject.getSession().getAttribute("validateCode");
        return StringUtils.isBlank(code) ? true : validateCode.equals(code);
    }
}
