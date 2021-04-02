package com.csu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/*
    之后手写的轮询算法要实现这个类
 */
public interface LoadBalancer {
    //这个抽象方法之后可以用来获取机器总数
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
