package com.zgx.blog.dao;

import com.zgx.blog.model.OpenUser;
import org.apache.ibatis.annotations.*;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/19 17:12
 */
@Mapper
public interface OpenUserMapper {


    @Insert({
            "INSERT INTO `blog`.`tb_openuser`(`open_type`, `access_token`, `nick_name`, `avatar`, `openId`, `create_time`,`update_time`) VALUES (#{openType},#{accessToken},#{nickName},#{avatar},#{openId},#{createTime},#{updateTime});"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(OpenUser openUser);


    @Select({
            "select * from tb_openuser where openId = #{openId}"
    })
    OpenUser selectByOpenId(Long openId);


    @Update({
            "UPDATE `blog`.`tb_openuser` SET  `access_token` = #{accessToken}, `nick_name` = #{nickName}, `avatar` = #{avatar},  `update_time` = #{updateTime} WHERE `openId` = #{openId}"
    })
    void update(OpenUser user);
}
