package com.springboot.web.config;


import com.springboot.web.component.LoginHandlerInterceptor;
import com.springboot.web.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 所有的WebMvcConfigure组件都会一起起作用
     * 这里使用 addViewControllers 注解 页面跳转
     * 当访问网站根目录或"index.html"时，跳转到 login.html 页面 用户后台登录页面
     * localhost:8080 或 localhost:8080/index.html
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("main");
    }

    /**
     * 注册一个拦截器 addInterceptors
     * @return
     */
     @Override
     public void addInterceptors(InterceptorRegistry registry){
         //添加一个名为 LoginHandlerInterceptor的拦截器

        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**") // “/**”这个意思是拦截所有路径
                // 放开首页访问，提交用户登录信息请求,/asserts/** 静态资源（css.js,图片等）
                .excludePathPatterns("/","index.html","/user/login","/asserts/**");
     }


    // 配置 localeResover注解 让 mvc 使用自已编写的 MyLocaleResolver.java 来实现 语言的切换
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
