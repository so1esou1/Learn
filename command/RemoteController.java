package com.csu.command;
/*
    命令的发布者、调用者(invoke类),一个按钮代表一个命令
 */
public class RemoteController {
    //开按钮的命令数组
    Command[] onCommands;
    Command[] offCommands;

    //执行撤销的命令
    Command undoCommand;

    //构造器完成对按钮的初始化
    public RemoteController(){
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0;i < 5;i ++){
            onCommands[i] = new NoCommand();    //一开始定义为空操作
            offCommands[i] = new NoCommand();
        }
    }

    //给按钮设置需要的命令
    public void setCommand(int no,Command onCommand,Command offCommand){
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    //按下开的按钮:
    public void onButtonWasPushed(int no){
        //找到你按下的开的按钮，并调用对应的方法
        onCommands[no].execute();
        //记录这次的操作用于撤销:
        undoCommand = onCommands[no];
    }
    //按下关的按钮
    public void offButtonWasPushed(int no){
        //找到你按下的开的按钮，并调用对应的方法
        offCommands[no].execute();
        //记录这次的操作用于撤销:
        undoCommand = offCommands[no];
    }

    //按下撤销的按钮
    public void undoButtonWasPushed(){
        undoCommand.undo();
    }
}
