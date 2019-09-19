package com.zgx.blog.springbootblog.service;

import com.zgx.blog.model.UserBean;
import com.zgx.blog.service.UserService;
import com.zgx.blog.springbootblog.SpringBootBlogApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/19 9:22
 */
public class UserServiceTestCase extends SpringBootBlogApplicationTests {



    @Autowired
    private UserService userService;


    @Test
    public void assertNotNull(){
        Assert.assertNotNull(userService);
    }




    @Test
    public void insert(){
        UserBean userBean = new UserBean();
        userBean.setUserName("张三");
        userBean.setEmail("1764773283@qq.com");
        userBean.setCreateTime(System.currentTimeMillis());
        userBean.setUpdateTime(System.currentTimeMillis());
        userBean.setImg("图片路径");
        userBean.setPwd("123456");
        userService.insert(userBean);
    }


    @Test
    public void findByUserBeanByUserName(){
        UserBean beanByUserName = userService.findUserBeanByUserName("Null");
        Assert.assertNotNull(beanByUserName);
    }

}
