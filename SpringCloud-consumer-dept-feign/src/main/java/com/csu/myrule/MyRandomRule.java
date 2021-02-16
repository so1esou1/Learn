package com.csu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

//自己自定义一个随机数
public class MyRandomRule extends AbstractLoadBalancerRule {

    //每个机器访问5次，之后换下一个服务

    //total=0,默认=0,如果=5，我们指向下一个服务节点
    //index=0,默认=0，如果total=5，那么index+1

    private int total = 0;   //被调用的次数
    private int currentIndex = 0;    //当前是谁在提供服务

    public MyRandomRule() {
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();         //获得活着的服务
                List<Server> allList = lb.getAllServers();              //获得全部的服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.chooseRandomInt(serverCount);             //生产区间随机数
//                server = (Server)upList.get(index);                         //从活着的服务中随机获取一个


                //====================================
                if (total<5){
                    Server server1 = upList.get(currentIndex);
                    total++;
                }else {
                    total = 0;
                    currentIndex++;
                    if (currentIndex> upList.size()){
                        currentIndex = 0;
                    }
                    server = upList.get(currentIndex);    //从活着的服务中，获取指定的服务来进行操作
                }

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }


    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
