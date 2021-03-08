package com.csu.flyweight;
/*
    给不同的用户创建不同的外部状态
 */
public class User {
    private String name;        //用户的名字
    public User(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
