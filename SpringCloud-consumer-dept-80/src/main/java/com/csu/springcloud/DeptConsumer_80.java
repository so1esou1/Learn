package com.csu.springcloud;

import com.csu.myrule.CsuRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//ribbon和Eureka整合以后，客户端可以直接调用，不用关心ip地址和端口号

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name="SPRINGCLOUD-PROVIDER-DEPT",configuration = CsuRule.class)   //在微服务启动的时候就能加载我们自定义的ribbon类
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
        //服务端访问不用写端口号了，直接这样写：localhost/consumer/dept/list
    }
}


