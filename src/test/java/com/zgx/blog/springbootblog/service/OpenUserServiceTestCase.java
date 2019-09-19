package com.zgx.blog.springbootblog.service;

import com.zgx.blog.service.OpenUserService;
import com.zgx.blog.springbootblog.SpringBootBlogApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/19 17:13
 */
public class OpenUserServiceTestCase extends SpringBootBlogApplicationTests {


    @Autowired
    private OpenUserService openUserService;


    @Test
    public void assertNotNull(){
        Assert.assertNotNull(openUserService);
    }




}
