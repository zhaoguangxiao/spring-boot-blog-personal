package com.zgx.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.zgx.blog.config.CaptchaUsernamePasswordToken;
import com.zgx.blog.model.OpenUser;
import com.zgx.blog.service.OpenUserService;
import com.zgx.blog.utils.HttpsUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zgx.blog.model.OpenUser.GITHUB_VARIABLE;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/19 17:07
 */
@Slf4j
@Controller
@Api(value = "github回调跳转逻辑处理")
public class GitHubController {

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.client.directurl}")
    private String redirectUrl;

    @Value("${github.request.url}")
    private String request_https;

    @Value("${github.user.url}")
    private String request_user_http;


    @Autowired
    private OpenUserService openUserService;


    @GetMapping("github")
    @ApiOperation(value = "把请求转发到github登录上")
    public void requestGitHub(HttpServletResponse response) {
        String url = "https://github.com/login/oauth/authorize?client_id=CLIENT_ID&redirect_uri=REDIRECT_URI&scope=user&state=1";
        String getGitHub = url.replace("CLIENT_ID", clientId).replace("REDIRECT_URI", redirectUrl);
        try {
            response.sendRedirect(getGitHub);
        } catch (IOException e) {
            log.error("github调换异常" + e.getMessage());
        }
    }


    @GetMapping("callback")
    @ApiOperation(value = "github用户回调获取当前登录用户信息")
    public String getGitHubCallBack(@RequestParam("code") String code,
                                    @RequestParam("state") String state) {
        // Step2：通过 Authorization Code 获取 AccessToken
        String token = getToken(code);
        String userResult = getGitHubUser(token);
        if (StringUtils.isNotBlank(userResult)) {
            JSONObject jsonObject = JSONObject.parseObject(userResult);
            //填充登录对象
            OpenUser user = new OpenUser();
            user.setOpenType(GITHUB_VARIABLE);
            user.setNickName(jsonObject.getString("name"));
            user.setAccessToken(token);
            user.setAvatar(jsonObject.getString("avatar_url"));
            user.setOpenId(jsonObject.getLong("id"));
            user.setCreateTime(System.currentTimeMillis());
            user.setUpdateTime(System.currentTimeMillis());
            //查询数据库是否存在这个github用户
            openUserService.save(user);
            //这里拿用户昵称，作为用户名，openid作为密码（正常情况下，在开发时候用openid作为用户名，再自己定义个密码就可以了）
            Subject subject = SecurityUtils.getSubject();
            CaptchaUsernamePasswordToken passwordToken = new CaptchaUsernamePasswordToken(user.getOpenId(), "123");
            passwordToken.unpass = true;
            subject.login(passwordToken);
        } else {
            log.error("没有获取到github当前用户信息");
        }
        return null;
    }


    private String getToken(String code) {
        String url = request_https +
                "?client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&code=" + code +
                "&redirect_uri=" + redirectUrl;
        String accessToken = HttpsUtils.get(url);
        return accessToken.split("&")[0].split("=")[1];
    }


    private String getGitHubUser(String token) {
        String getUserTokenUrl = request_user_http.replace("ACCESS_TOKEN", token);
        return HttpsUtils.get(getUserTokenUrl);
    }


}
