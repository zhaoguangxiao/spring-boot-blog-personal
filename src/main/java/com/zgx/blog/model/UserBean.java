package com.zgx.blog.model;

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
public class UserBean {

    @ApiModelProperty(required = true, value = "主键", notes = "id自动增长")
    private Long id;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(required = true, value = "用户名")
    private String userName;

    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty(required = true, value = "邮箱", notes = "邮箱不能为空")
    private String email;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(required = true, value = "密码", notes = "密码")
    private String pwd;


    @ApiModelProperty(value = "用户创建时间")
    private Long createTime;

    @ApiModelProperty(value = "用户更新时间")
    private Long updateTime;


}
