package com.csu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    自定义负载均衡策略
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule MyRule(){
        return new RandomRule();    //定义为随机负载均衡模式
    }
}
