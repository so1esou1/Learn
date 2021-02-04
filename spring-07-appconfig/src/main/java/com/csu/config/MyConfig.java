package com.csu.config;

import com.csu.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration    //这个也会被spring容器托管，注册到容器中，因为它本来就是一个@Component
                  //@Configuration 代表这是一个配置类，就和我们之前看的beans.xml是一样的，能做beans.xml能做的一切
@ComponentScan("com.csu.pojo")                //扫描这个包
@Import(MyConfig2.class)       //引入另一个配置文件，进行融合
public class MyConfig {
    @Bean                  //就相当于我们之前写的一个bean标签，这个方法的名字就相当于bean标签中的id属性，这个方法的返回值就相当于bean标签中的class属性
    public User getUser(){
        return new User();        //返回当前要注入到bean的对象
    }
}
