package com.zgx.blog.service;

import com.zgx.blog.model.UserBean;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/17 16:50
 */
public interface UserService {


    public UserBean insert(UserBean userBean);


    UserBean findUserBeanByUserName(String userName);


}
