package com.csu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//本身就是spring的一个组件

//程序的主入口
@SpringBootApplication   //标注这个类是一个spring boot的应用:启动类下的所有资源被导入
public class DemoApplication {

    public static void main(String[] args) {
        //将springboot应用启动
        //SpringApplication类
        //run方法
        SpringApplication.run(DemoApplication.class, args);
    }
}
