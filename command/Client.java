package com.csu.command;

public class Client {
    public static void main(String[] args) {
        //使用命令设计模式完成通过遥控器对电灯的操作:
        //1、创建电灯的对象:
        LightReceiver lightReceiver = new LightReceiver();
        //2、创建电灯相关的开关命令:
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        //3、电灯关闭的命令:
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        //4、需要一个遥控器:
        RemoteController remoteController = new RemoteController();
        //5、给我们的遥控器设置命令，比如no=0是使电灯的开关操作
        remoteController.setCommand(0,lightOnCommand,lightOffCommand);

        System.out.println("------------按下灯的开的按钮-----------");
        remoteController.onButtonWasPushed(0);
        System.out.println("------------按下灯的关的按钮-----------");
        remoteController.offButtonWasPushed(0);
        System.out.println("------------撤销按钮------------");
        remoteController.undoButtonWasPushed();
    }
}
