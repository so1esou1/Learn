package com.csu.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsuRule {
    @Bean
    public IRule myRule(){
        return new MyRandomRule();   //默认是轮询，现在我们自定义策略为MyRandomRule
    }
}
