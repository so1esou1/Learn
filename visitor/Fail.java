package com.csu.visitor;
/*
    失败的方法
 */
public class Fail extends Action{
    @Override
    public void getManResult(Man man) {
        System.out.println("男人评价该歌手是很失败");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人评价该歌手是很失败");
    }
}
