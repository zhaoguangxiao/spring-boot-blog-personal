package com.zgx.blog.dao;

import com.zgx.blog.model.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/18 11:13
 */
@Mapper
public interface UserMapper {


    @Insert({
            "insert into tb_user (`email`,`pwd`,`create_time`,`update_time`,`user_name`,`img`) values (#{email},#{pwd},#{createTime},#{updateTime},#{userName},#{img})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(UserBean userBean);


    @Select({
            "select * from tb_user where user_name = #{userName}"
    })
    UserBean selectUserBeanByUserName(String userName);
}
