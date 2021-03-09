package com.csu.visitor;

import java.util.LinkedList;
import java.util.List;

/*
    数据结构类，维护了一个集合,管理很多的人，有man和woman
 */
public class ObjectStructure {
    private List<Person> persons = new LinkedList<>();

    //增加到List
    public void attach(Person p){
        persons.add(p);
    }

    //移除
    public void detach(Person p){
        persons.remove(p);
    }

    //显示测评的情况
    public void display(Action action){
        for (Person p : persons){
            p.accept(action);
        }
    }
}
