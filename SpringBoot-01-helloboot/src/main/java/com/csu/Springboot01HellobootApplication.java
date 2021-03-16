package com.csu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//这个类本身就是Spring的组件
@SpringBootApplication
public class Springboot01HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01HellobootApplication.class, args);
    }
}
