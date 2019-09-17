package com.zgx.blog.model;

import com.zgx.blog.validate.IsEmailValidater;
import com.zgx.blog.validate.IsVerificationCodeExist;
import com.zgx.blog.validate.UserNameValidater;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/17 10:23
 */
@Data
@ApiModel(value = "用户实体类")
public class UserBean extends LoginUserBean {

    @ApiModelProperty(required = true, value = "主键", notes = "id自动增长")
    private Long id;

    @NotBlank(message = "邮箱不能为空")
    @IsEmailValidater(message = "邮箱格式不正确")
    @ApiModelProperty(required = true, value = "邮箱", notes = "邮箱不能为空")
    private String email;

    @ApiModelProperty(value = "用户创建时间")
    private Long createTime;

    @ApiModelProperty(value = "用户更新时间")
    private Long updateTime;

    @Override
    @UserNameValidater(message = "用户名已经存在")
    public String getUserName() {
        return super.getUserName();
    }


    @NotBlank(message = "验证码不能为空")
    @IsVerificationCodeExist(message = "验证码不正确")
    @ApiModelProperty(value = "验证码", required = true)
    public String verificationCode;


}
