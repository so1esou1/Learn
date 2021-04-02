package com.csu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
    主启动类
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix      //启动类上加这个注解
public class OrderHystrixMain80 {
    public static void main(String[] args)
    {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
