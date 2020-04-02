package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebStartController {

    //打开首页 默认访问 templates 下载login.html 用户需要登录
    // 也可以 这里不用Controller的方法 使用config/MyMvcConfig来配置mvc来注解
    /*
    @RequestMapping({"/","login.html"})
    public String index(){
        return "login";
    }
    */

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "webStrtController";
    }
}
