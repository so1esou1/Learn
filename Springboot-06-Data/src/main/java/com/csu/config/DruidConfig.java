package com.csu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    //与yaml配置文件中的datasource绑定
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控功能，都是死代码.    相当于web.xml
    //因为SpringBoot内置了servlet容器，所有没有web.xml，替代方法:ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //只要访问这个可以直接进入别人写好的后台监控页面
        //后台需要有人登录，账号密码配置
        HashMap<String,String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername","admin");     //登录的key是固定的loginUsername，不要写其他的
        initParameters.put("loginPassword","123456");

        //允许谁可以访问
        initParameters.put("allow","localhost");     //只有本机的人可以访问

        //禁止谁能访问
        //initParameters.put("kuangshen","192.168.11.123");    禁止这个ip地址的访问

        bean.setInitParameters(initParameters);    //设置初始化参数
        return bean;
        //启动后进入http://localhost:8080/druid网页，login和index页面阿里提供，这个页面可以监控我们其他页面的操作
    }


    //过滤功能filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //可以过滤哪些请求呢?
        Map<String,String> initParameters = new HashMap<>();
        initParameters.put("exclusion","*.js,*.css,/druid/*");     //这些不进行统计

        bean.setInitParameters(initParameters);
        return bean;
    }

}
