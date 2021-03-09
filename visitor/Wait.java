package com.csu.visitor;
/*
    新增一种待定的状态
 */
public class Wait extends Action{
    @Override
    public void getManResult(Man man) {
        System.out.println("男性给的评价是该歌手待定");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女性给的评价是该歌手待定");
    }
}
