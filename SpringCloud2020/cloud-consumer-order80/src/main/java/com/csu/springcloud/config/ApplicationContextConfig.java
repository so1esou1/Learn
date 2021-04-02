package com.csu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*

 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced       //启动默认的负载均衡机制,赋予RestTemplate负载均衡的能力,要自己写算法的话需要注销掉这个注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

