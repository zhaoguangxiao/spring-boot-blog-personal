package com.zgx.blog.config;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/20 14:53
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {

    /**
     * 判断是否为第三方登录
     */
    public boolean unpass;

    public boolean isUnpass() {
        return unpass;
    }

    public void setUnpass(boolean unpass) {
        this.unpass = unpass;
    }


    public CaptchaUsernamePasswordToken(Long username, String password) {
        super(String.valueOf(username),password);
    }
}
