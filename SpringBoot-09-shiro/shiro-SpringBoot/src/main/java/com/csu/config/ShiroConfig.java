package com.csu.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //三大核心要素:倒着配置，先创建realm对象，再接管对象DefaultWebSecurity，再连接前端ShiroFilterFactoryBean
    //ShiroFilterFactoryBean                      3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);      //同下一方法

        //添加shiro的内置过滤器
        /*
            anno:无须认证即可访问
            authc:必须认证才可访问
            user:必须拥有 “记住我” 功能才能用
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        //授权，未授权则会报401错误
        filterMap.put("/user/add","perms[user:add]");  //只有user才能访问add页面
        filterMap.put("/user/update","perms[user:update]");

        filterMap.put("/user/*","authc");    //给user下面的页面设置拦截功能
        bean.setFilterChainDefinitionMap(filterMap);


        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        //设置未授权页面的请求
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    //DefaultWebSecurity                          2
    @Bean(name="securityManager")        //方法名是getDefaultWebSecurityManager，太长了，把bean的名字改短
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);        //userRealm已经被spring接管了，不能直接调用，要使用@Qualifier注解

        return securityManager;
    }



    //创建realm对象，需要自定义类                   1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }



    //整合shiroDialect:用来整合shiro和thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
