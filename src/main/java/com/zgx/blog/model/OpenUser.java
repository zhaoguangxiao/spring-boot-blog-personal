package com.zgx.blog.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/19 16:58
 */
@Data
@ApiModel(value = "github实体类")
public class OpenUser {

    /**
     * github 标识
     */
    public static final int GITHUB_VARIABLE = 2;
    /**
     * qq 标识
     */
    public static final int QQ_VARIABLE = 1;


    @ApiModelProperty(value = "主键", notes = "自增", required = true)
    private Long id;
    @ApiModelProperty(value = "登录类型", notes = "目前qq/github登录")
    private int openType;
    @ApiModelProperty(value = "token", notes = "调用接口需要用到的token，比如利用accessToken发表微博等，如果只是对接登录的话，这个其实没啥用")
    private String accessToken;
    @ApiModelProperty(value = "用户名")
    private String nickName;
    @ApiModelProperty(value = "用户头像路径")
    private String avatar;
    @ApiModelProperty(value = "登录唯一标识")
    private Long openId;
    @ApiModelProperty(value = "创建时间", required = false)
    private Long createTime;
    @ApiModelProperty(value = "更新日期", required = false)
    private Long updateTime;


}
