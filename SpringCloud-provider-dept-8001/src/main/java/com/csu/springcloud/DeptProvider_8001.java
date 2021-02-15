package com.csu.springcloud;

import com.netflix.hystrix.Hystrix;
import com.netflix.hystrix.HystrixMetrics;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//启动类,springboot的，我们自己写一个
@SpringBootApplication
@EnableEurekaClient    //开启eureka注解，在服务启动后自动注册到eureka中    先启动7001，再启动8001
@EnableDiscoveryClient         //让别人发现自己的微服务的注解
public class DeptProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001.class,args);
    }


    //增加一个dashboard的Bean
    @Bean
    public ServletRegistrationBean HystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream ");     //豪猪页面提示过了这个地址
        return registrationBean;
    }   //固定的代码
}
