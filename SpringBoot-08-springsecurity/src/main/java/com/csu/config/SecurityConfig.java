package com.csu.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity    //这个类已经被spring托管了
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //链式编程
    //代码格式见SpringSecurity官方文档

    //授权
    @Override          //注意，重写的方法不要选错了
    protected void configure(HttpSecurity http) throws Exception {
        //需求：首页所有人都可以访问，但是功能页需要有想要的权限才能访问
        //认证请求首页可以访问,各等级访问需要各级权限：
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");     //死代码

        //没有权限会默认登录页面,需要开启登录的页面:
            //    /login
        //定制登录页面loginPage("/toLogin")
        http.formLogin().loginPage("/toLogin");

        //网站安全相关:
        http.csrf().disable();         //关闭防止csrf(跨站请求伪造),登出失败可能就是因为有csrf防护

        //注销功能,跳到首页
        //http.logout().deleteCookies("remove").invalidateHttpSession(true);      //移除完整的cookies
        http.logout().logoutSuccessUrl("/");        //指定首页


        //开启记住我功能     实质是cookie的实现   默认保存两周
        http.rememberMe().rememberMeParameter("remember");
        //要在前端login.html中添加记住我的按钮
    }


    //认证的规则
    //springsecurity5.0+中，新增了很多的加密方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //以下数据正常应该在数据库中取得
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())          //从内存中验证，也可以选中从jdbc中进行验证.passwordEncoder给密码编码
                .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()          //and()进行拼接
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");

    }
}
