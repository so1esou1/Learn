package com.csu.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component   //等价于<bean id="user" class="com.csu.pojo.User" />
//Component:组件
@Scope
public class User {

    public String name;

    @Value("lily")    //相当于<properties name="name" value="lily" />
    public void setName(String name) {
        this.name = name;
    }
}
