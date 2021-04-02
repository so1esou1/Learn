package com.csu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    手动配置路由网关映射
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_csu",r -> r.path("/guonei").
                uri("http://news.baidu.com/guonei")).build();

        //配置了一个路由规则，当访问地址为http://localhost:9527/guonei时
        //会自动转发到地址:http://news.baidu.com/guonei

        return routes.build();
    }

}
