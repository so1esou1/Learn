package com.csu.mediator.renthouse;
/*
    抽象中介者
 */
public abstract class Mediator {
    //沟通的方法，需要传递沟通信息和同事类顶层父类
    public abstract void constact(String message,Person person);

}
