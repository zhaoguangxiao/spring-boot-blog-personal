package com.zgx.blog.validate.impl;

import com.zgx.blog.validate.IsPwdVerificationRule;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/17 15:13
 */
public class IsPwdVerificationRuleValidator implements ConstraintValidator<IsPwdVerificationRule, String> {

    @Override
    public void initialize(IsPwdVerificationRule constraintAnnotation) {

    }

    @Override
    public boolean isValid(String pwd, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isBlank(pwd) ? true : pwdFormat(pwd);
    }


    /**
     * 验证输入密码格式是否正确
     *
     * @param password
     * @return 是否合法
     */
    public static boolean pwdFormat(String password) {
        boolean tag = true;
        final String passRegex = "^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\\(\\)])+$)([^(0-9a-zA-Z)]|[\\(\\)]|[a-zA-Z]|[0-9]){6,16}$";
        final Pattern pattern = Pattern.compile(passRegex);
        final Matcher mat = pattern.matcher(password);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }
}

