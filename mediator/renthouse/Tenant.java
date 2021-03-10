package com.csu.mediator.renthouse;
/*
    租房者,具体的同事角色类
 */
public class Tenant extends Person{
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    //和中介联系沟通的方法
    public void constact(String message){
        mediator.constact(message,this);        //把自己(Tenant)传过去
    }

    //获取信息的方法:
    public void getMessage(String message){
        System.out.println("租房者" + name + "获取到的信息是:" + message);
    }
}
