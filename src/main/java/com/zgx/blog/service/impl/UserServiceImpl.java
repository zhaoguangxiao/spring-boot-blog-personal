package com.zgx.blog.service.impl;

import com.zgx.blog.dao.UserMapper;
import com.zgx.blog.model.UserBean;
import com.zgx.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/17 16:50
 */
@Service
@CacheConfig(cacheNames = "userBean")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    @CachePut(key = "#userBean.userName")
    public UserBean insert(UserBean userBean) {
        userMapper.insert(userBean);
        return userBean;
    }


    //    @Cacheable(key = "#userName", unless = "#result == null || #userName == null ")
    @Override
    public UserBean findUserBeanByUserName(String userName) {
        return userMapper.selectUserBeanByUserName(userName);
    }
}
