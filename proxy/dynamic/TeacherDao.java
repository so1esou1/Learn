package com.csu.proxy.dynamic;
/*
    实现接口中的方法
 */
public class TeacherDao implements ITeacherDao{

    @Override
    public void teach() {
        System.out.println("老师正在授课中");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello" + name);
    }
}
