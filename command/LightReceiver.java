package com.csu.command;
/*
    命令的接收者，知道如何实施和执行一个请求的相关操作,on()和off()命令
 */
public class LightReceiver {
    public void on(){
        System.out.println("电灯打开了");
    }
    public void off(){
        System.out.println("电灯关闭了");
    }
}
