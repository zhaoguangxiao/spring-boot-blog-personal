package com.zgx.blog.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/17 11:10
 */
@Data
@ApiModel(value = "登录验证用户实体类")
public class LoginUserBean extends BaseBean {


    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(required = true, value = "用户名")
    private String userName;


    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(required = true, value = "密码", notes = "密码")
    private String pwd;


}
