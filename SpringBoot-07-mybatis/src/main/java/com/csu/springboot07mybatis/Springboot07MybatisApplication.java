package com.csu.springboot07mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("xxx.xxx.xxx")     //扫描一个包
public class Springboot07MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot07MybatisApplication.class, args);
    }

}
