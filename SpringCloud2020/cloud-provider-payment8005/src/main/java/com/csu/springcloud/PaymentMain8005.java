package com.csu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
    主启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8005.class,args);
    }
}
