package com.csu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/*
    feign的日志打印功能的配置
 */
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;   //开启FULL级别的日志
    }
}
