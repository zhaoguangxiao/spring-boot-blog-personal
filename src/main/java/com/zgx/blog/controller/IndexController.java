package com.zgx.blog.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/7 14:13
 */
@Controller
@Api(value = "基础控制器")
public class IndexController {


    @GetMapping(value = "/")
    public String index() {
        return "index";
    }



    @GetMapping("category")
    public String category(){
        return "pages/category/list";
    }

    @GetMapping("archive")
    public String archive(){
        return "pages/archive/list";
    }

    @GetMapping("label")
    public String label(){
        return "pages/label/list";
    }



    @GetMapping("link")
    public String link(){
        return "pages/link/list";
    }


    @GetMapping("about")
    public String about(){
        return "pages/about/list";
    }


    @GetMapping("article/detail")
    public String article(){
        return "pages/article/list";
    }





}
