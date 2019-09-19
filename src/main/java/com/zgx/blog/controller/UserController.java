package com.zgx.blog.controller;

import com.zgx.blog.model.LoginUserBean;
import com.zgx.blog.model.UserBean;
import com.zgx.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/17 10:56
 */
@Controller
@Api(value = "用户控制器")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("login")
    @ApiOperation(value = "跳转登录页面")
    public String login(Model model) {
        model.addAttribute("loginUserBean", new LoginUserBean());
        return "pages/login";
    }


    @PostMapping("login")
    @ApiOperation(value = "登录方法", notes = "登录流程控制")
    public String login(@Valid LoginUserBean loginUserBean,
                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            //如果有错误,就跳转form表单
            return "pages/login";
        }

        System.out.println(loginUserBean);
        return null;
    }


    @GetMapping("insert")
    @ApiOperation(value = "跳转到注册页面")
    public String insert(Model model) {
        model.addAttribute("userBean", new UserBean());
        return "pages/insert";
    }


    @PostMapping("insert")
    @ApiOperation(value = "注册用户方法", notes = "注册流程控制")
    public String insert(@Valid UserBean userBean,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pages/insert";
        }
        //设置创建日期
        userBean.setCreateTime(System.currentTimeMillis());
        //设置更新日期
        userBean.setUpdateTime(System.currentTimeMillis());
        //对密码进行加密
        userBean.setPwd(encryptionPassword(userBean.getPwd(), userBean.getUserName()));
        //设置默认头像
        userBean.setImg("picture/box.png");
        userService.insert(userBean);
        //跳转登录页面
        return "redirect:/login";
    }


    /**
     * 返回加密后的密码
     *
     * @param pwd
     * @return
     */
    private String encryptionPassword(String pwd, String salt) {
        //加密方式
        String hashAlgorithmName = "MD5";
        //盐：为了即使相同的密码不同的盐加密后的结果也不同
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        //密码
        Object source = pwd;
        //加密次数
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName, source, byteSalt, hashIterations);
        return result.toString();
    }

}
