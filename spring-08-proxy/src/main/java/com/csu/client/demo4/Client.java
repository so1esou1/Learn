package com.csu.client.demo4;

import com.csu.client.demo2.UserService;
import com.csu.client.demo2.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色，不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setTarget(userService);    //设置要代理的对象
        //动态生成代理类
        UserService proxy = (UserService)pih.getProxy();

        proxy.add();
    }
}
