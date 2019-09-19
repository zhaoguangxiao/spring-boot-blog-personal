package com.zgx.blog.config;

import com.zgx.blog.model.UserBean;
import com.zgx.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 *
 * @author Administrator
 * @version 1.0
 * @date 2019/9/4 17:42
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权已经执行");
//        Subject subject = SecurityUtils.getSubject();
//        //获取当前登录的用户信息
//        UserBean user = (UserBean) subject.getPrincipal();
//        //根据用户信息查出用户权限
//
//
//        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//        //从数据库查出权限
//        if (user.getId()==6){
//            info.addStringPermission("user:add");
//        }
//
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //判断用户名与密码是否正确
       // 1,判断用户名
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //判断数据库是否存在这个用户
        UserBean userBean = userService.findUserBeanByUserName(usernamePasswordToken.getUsername());

        if (null == userBean) {
            //用户名不存在
            //底层会抛出UnknownAccountException异常
            return null;
        }
        //取出盐并编码
        ByteSource salt = ByteSource.Util.bytes(userBean.getUserName());

        //2,判断密码
        //保存用户信息 保存用户字段 userBean
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userBean,
                userBean.getPwd(),
                salt,
                this.getName()
        );
        //当前用户保存在session中
        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userBean", userBean);

        return info;
    }
}
