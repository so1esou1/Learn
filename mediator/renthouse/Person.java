package com.csu.mediator.renthouse;
/*
    抽象同事类
 */
public abstract class Person {
    protected String name;      //租房者、房主名字
    protected Mediator mediator;
    //构造器:
    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
