package com.csu.visitor;
/*
    这里我们使用到了双分派，即首先在客户端程序中将具体的状态作为参数传递到Man，完成第一次分派
    然后Man这个类调用了作为参数的具体方法中的getManResult,同时将自己(this)作为参数传入，完成了第二次分派
 */
public class Man extends Person{

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
