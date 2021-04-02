package com.csu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author so1esou1
 * @ClassName
 * @Date 2021.1.4
 * @TODO
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosMain83 {
    public static void main(String[] args)
    {
        SpringApplication.run(OrderNacosMain83.class,args);
    }
}
