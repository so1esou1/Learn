package com.csu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.Locale;


//扩展springMVC：
@Configuration
//@EnableWebMvc    这个注解会导入一个类，DelegatingWebMvcConfiguration:从容器中获取所有的webmvcconfig,这个类继承了WebMvcComfigurationSupport类，会使自动配置失效(底层源码的设置)，所以最好不要随便添加这个注解，除非要自研start
public class MyMvcConfig implements WebMvcConfigurer {     //必须实现这个接口

    /*//ViewResolver 实现了视图解析器接口的类，就可以把它看作视图解析器
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }
    //自定义了一个自己的视图解析器MyViewResolver
    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
     */

    //如果我们想要扩展MVC，官方建议我们这样去做：
    //视图跳转：
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/csu").setViewName("test");   //输入csu，会跳转到test页面
    }
}

//结论：如果想diy一些定制化的功能，只需要写这个组件，然后将它交给springboot，然后springboot就会帮我们自动装配