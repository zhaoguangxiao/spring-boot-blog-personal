package com.zgx.blog.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/4 17:39
 */
@Configuration
public class ShiroConfig {


    /**
     * 创建shiroFilterFactorBean
     *
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro内置过滤器(实现对URL进行拦截)
        //常见过滤器
        //anon :无需认证(登录)就能访问
        //authc : 必须认证才可以访问
        //user : 如果使用remember的功能可以直接访问
        //perms : 必须授以资源权限才能访问
        //role : 该资源必须得到角色权限才可以访问
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();

        //让某些资源不拦截
        hashMap.put("/", "anon");
        //放行登录请求
        hashMap.put("/save", "anon");
        //放行注册请求
        hashMap.put("/insert", "anon");
        //放行注册用户请求
        hashMap.put("/addUserBean", "anon");
        //放行swagger.html
        hashMap.put("/swagger-ui.html", "anon");
        //放行请求验证码
        hashMap.put("/validateCode", "anon");


        //授权
        hashMap.put("/list", "perms[user:add]");
        //        hashMap.put("/form", "authc");
        //        hashMap.put("/list", "authc");也可以下面这样写
        hashMap.put("/*", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(hashMap);
        //修改跳转的登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //跳转未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");


        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManage
     *
     * @param userRealm
     * @return
     */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        //关联realm
        webSecurityManager.setRealm(userRealm);
        return webSecurityManager;
    }


    /**
     * 创建Realm
     *
     * @return
     */
    @Bean(name = "userRealm")
    public UserRealm getUserRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher hashedCredentialsMatcher) {
        UserRealm userRealm = new UserRealm();
        //设置密码加密
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return userRealm;
    }


    /*
     * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 所以我们需要修改下doGetAuthenticationInfo中的代码; )
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 散列的次数，比如散列两次，相当于md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }


    /**
     * 配置ShiroDialect 用于thymeleaf 与 shiro 标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }


}
