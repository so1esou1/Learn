package com.csu.memento.theory;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    //在list集合中有很多备忘录状态
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

    //获取状态
    public Memento get(int index){
        return mementoList.get(index);      //获取到第index个Originator的备忘录对象，即原先保存的状态
    }
}
