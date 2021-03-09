package com.csu.command;
/*
    实现接口，实现execute()和undo()方法，同时聚合Reciever，调用接收者
 */
public class LightOnCommand implements Command{
    //聚合LightReceiver
    LightReceiver light;
    //构造器
    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.on();     //调用接收者的方法，
    }

    @Override
    public void undo() {
        light.off();    //这里是认为撤销就是关灯，执行就是开灯，实际情况看设计者是怎么想的
    }
}
