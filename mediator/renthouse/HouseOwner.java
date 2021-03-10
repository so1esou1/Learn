package com.csu.mediator.renthouse;
/*
    房主类，具体的同事角色类
 */
public class HouseOwner extends Person{
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    //和中介联系沟通的方法
    public void constact(String message){
        mediator.constact(message,this);        //把自己(Tenant)传过去
    }

    //获取信息的方法:
    public void getMessage(String message){
        System.out.println("房主" + name + "获取到的信息是:" + message);
    }
}
