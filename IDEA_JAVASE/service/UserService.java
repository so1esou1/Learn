package com.bjpowernode.java.service;
/*
用户业务类
 */
public class UserService {
    /**
     * 登录方法
     * @param name 用户名
     * @param password 密码
     * @return true成功，false失败
     */
    public boolean login(String name,String password){
        if ("admin".equals(name) && "123".equals(password)){
            return true;
        }
        return false;
    }

    /**
     * 退出系统的方法
     */
    public void login(){
        System.out.println("系统已经安全退出！");
    }
}
