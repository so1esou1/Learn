package com.csu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
    手写的轮询算法类
 */
@Component      //让容器能够扫描得到
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncreme(){
        int current;    //当前正在遍历的机器(的下标)
        int next;       //下一个机器(的下标)
        do {
            current = this.atomicInteger.get();     //得到当前的值，是0
            next = current >= 2147483647 ? 0 : current+1;   //防止越界
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("******第几次访问，次数next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncreme() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
