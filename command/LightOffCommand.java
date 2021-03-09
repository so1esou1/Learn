package com.csu.command;
/*
    电灯关闭的命令实现类
 */
public class LightOffCommand implements Command{

    LightReceiver light;
    //构造器
    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.off();     //调用接收者的方法，
    }

    @Override
    public void undo() {
        light.on();    //这里是认为撤销就是关灯，执行就是开灯，实际情况看设计者是怎么想的
    }
}
