package com.csu.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {     //@Configuration 相当于spring中的applicationContext.xml
    @Bean
    @LoadBalanced               //配置负载均衡实现RestTemplate,ribbon的作用,基于客户端访问的
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }



/*IRule中自定义负载均衡的方法:
AvailabilityFilteringRule : 会先过滤掉，跳闸或访问故障的服务，对剩下的进行轮询
RoundRobinRule:轮询(默认)
RandomRule : 随机
RetryRule:会先按照轮询获得服务，获取失败，则会在指定时间内进行重试
.....剩下的自己看源码
 */

//使用随机的算法:
    @Bean
    public IRule myRule(){
        return new RandomRule();

    }
//正常情况下不应该在这个位置定义算法，应该与springcloud的包同级
}


