package com.zgx.blog.validate;

import com.zgx.blog.validate.impl.IsEmailValidator;
import com.zgx.blog.validate.impl.IsPwdVerificationRuleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/17 15:12
 */
// 注解可以作用的位置：字段、方法
@Target({ElementType.FIELD, ElementType.METHOD})
// 运行时注解
@Retention(RetentionPolicy.RUNTIME)
// 校验注解必须使用@Constraint
@Constraint(validatedBy = IsPwdVerificationRuleValidator.class)
public @interface IsPwdVerificationRule {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}