package com.zgx.blog.service.impl;

import com.zgx.blog.dao.OpenUserMapper;
import com.zgx.blog.model.OpenUser;
import com.zgx.blog.service.OpenUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/19 17:11
 */
@Service
public class OpenUserServiceImpl implements OpenUserService {


    @Autowired
    private OpenUserMapper openUserMapper;


    @Override
    public OpenUser insert(OpenUser openUser) {
        openUserMapper.insert(openUser);
        return openUser;
    }


    @Override
    public OpenUser selectOpenUserByOpenId(Long openId) {
        return openUserMapper.selectByOpenId(openId);
    }


    @Override
    public OpenUser save(OpenUser openUser) {
        OpenUser user = openUserMapper.selectByOpenId(openUser.getOpenId());
        if (null ==user){
            openUserMapper.insert(openUser);
        }else {
            //更新日期
            user.setUpdateTime(System.currentTimeMillis());
            user.setNickName(openUser.getNickName());
            user.setAvatar(user.getAvatar());
            user.setAccessToken(user.getAccessToken());
            openUserMapper.update(user);
        }
        return null;
    }
}
