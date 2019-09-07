package com.zgx.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/9/7 14:13
 */
@Controller
public class IndexController {


    @GetMapping(value = "/")
    public String index() {
        return "index";
    }



    @GetMapping("category")
    public String category(){
        return "pages/category/list";
    }


}
