package com.zgx.blog.validate;



import com.zgx.blog.validate.impl.IsEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//说明该注解将被包含在javadoc中
@Documented
// 注解的作用目标 类上、方法上、属性上
@Target({ElementType.FIELD, ElementType.PARAMETER})
// 注解的保留位置　　
@Retention(RetentionPolicy.RUNTIME)
// 校验注解必须使用@Constraint
@Constraint(validatedBy = IsEmailValidator.class)
public @interface IsEmailValidater {


    boolean required() default true;

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
