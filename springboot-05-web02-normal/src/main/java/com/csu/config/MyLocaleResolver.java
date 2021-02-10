package com.csu.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//这个方法控制i18n汉语与英语的切换
public class MyLocaleResolver implements LocaleResolver {
    //模仿源码中的写法

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数链接
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();       //如果没有请求就使用默认的：汉语

        //如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(language)){
            //zh_CN
            String[] split = language.split("_");//进行封装，得到一个数组
            //国家，地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }
    //写完之后把这个放到一个bean里面

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
