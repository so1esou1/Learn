package com.csu.testrenwu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAsync        //开启异步功能的注解
@EnableScheduling   //开启定时功能的注解
@SpringBootApplication
public class Springboot10TestRenwuApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot10TestRenwuApplication.class, args);
    }

}
