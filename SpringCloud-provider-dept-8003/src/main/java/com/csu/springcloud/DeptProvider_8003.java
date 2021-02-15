package com.csu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//启动类,springboot的，我们自己写一个
@SpringBootApplication
@EnableEurekaClient    //开启eureka注解，在服务启动后自动注册到eureka中    先启动7001，再启动8001
@EnableDiscoveryClient         //让别人发现自己的微服务的注解
public class DeptProvider_8003 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8003.class,args);
    }
}
