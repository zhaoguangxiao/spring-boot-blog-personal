package com.zgx.blog.service;

import com.zgx.blog.model.OpenUser;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/19 17:10
 */
public interface OpenUserService {


    OpenUser insert(OpenUser openUser);


    OpenUser selectOpenUserByOpenId(Long openId);


    OpenUser save(OpenUser openUser);

}
