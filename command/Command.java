package com.csu.command;
/*
    命令的接口，需要执行的所有命令都在这里，可以是接口和抽象类
 */
public interface Command {
    public void execute();      //执行动作的命令
    public void undo();         //撤销某个动作
}
