package com.zgx.blog.validate;

import com.zgx.blog.validate.impl.IsVerificationCodeExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/17 14:28
 */
// 注解可以作用的位置：字段、方法
@Target({ElementType.FIELD, ElementType.METHOD})
// 运行时注解
@Retention(RetentionPolicy.RUNTIME)
// 制定注解判断逻辑所在的类，这个类必须实现了ConstraintValidator接口
@Constraint(validatedBy = IsVerificationCodeExistValidator.class)
public @interface IsVerificationCodeExist {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}