package com.springboot.web.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 获取用户切换语言的方法
 * 可以在连接上带区域的信息
 */
public class MyLocaleResolver implements LocaleResolver {
    //实现 LocaleResolver 的两个方法
    @Override
    // 用resolveLocale来解释 链接带上的区域信息
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String lg = httpServletRequest.getParameter("lg");
        Locale locale = httpServletRequest.getLocale(); //如果链接上没有带语言参数 就默认使用 Locale.getDefault系统的默认的语言信息 httpServletRequest.getLocale() 使用 浏览器上的语言
        if(!StringUtils.isEmpty(lg)){  //lg 不为空 带上了区城信息
            String[] split = lg.split("_"); //把zh_CN 切分为数组 split[0] :zh 语言 split[1] : CN 国家
            locale = new Locale(split[0],split[1]);  //Locale(BaseLocale baseLocale, LocaleExtensions extensions)默认访问传两个值 ，第一个语言（zh）,第二个国家（CN）
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
