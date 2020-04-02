package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
        @PostMapping(value ="/user/login") //接收post请求
        //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
        //html页面上要传username与password 两个参数传给userName与 passWord
        public String login(
                @RequestParam("username") String userName,
                @RequestParam("password") String passWord,
                //定义一个存放错误消息的变量 map
                Map<String,Object> map,
                //定义一个 user_session 保存用户信息
                HttpSession user_session

        ){
            //如果 userName 不为空，并且 passWord == 123456 则为登录成功
            if(!StringUtils.isEmpty(userName) && "123456".equals(passWord)){
                //登录成功 : 为防止表单可以重复提交 可以重定向到主页 main.html
                //要使用重定向 必须要 先在配置文件MyMvcConfig.java 注解  registry.addViewController("/main.html").setViewName("main");
                //登录成功 保存用户名到 user_session中 key:loginUser 值就是userName
                user_session.setAttribute("loginUser",userName);
                return "redirect:/main.html";
            }else{
                //登录失败：返回登录页面，并传递 登录失败消息
                map.put("msg","用户名密码错误");
                return "login";
            }

        }
}
