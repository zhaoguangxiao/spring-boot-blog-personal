package com.zgx.blog.validate.impl;

import com.zgx.blog.validate.UserNameValidater;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/17 11:38
 */
public class UserNameValidator implements ConstraintValidator<UserNameValidater, String> {

    /**
     * 初始化的方法
     * @param constraintAnnotation 我们自定义的注解
     */
    @Override
    public void initialize(UserNameValidater constraintAnnotation) {

    }

    /**
     * 判断的具体逻辑
     * @param email 注解所作用的对象
     * @param constraintValidatorContext 上下文
     * @return
     */
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(email);
        if (email.equals("123")){
            return false;
        }
        return true;
    }
}
