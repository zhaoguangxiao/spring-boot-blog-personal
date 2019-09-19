package com.zgx.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Administrator
 * @date 2019年9月17日14:55:41
 */
@EnableWebMvc
@EnableCaching
@SpringBootApplication
@MapperScan(value = "com.zgx.blog.dao")
public class SpringBootBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBlogApplication.class, args);
    }

}
