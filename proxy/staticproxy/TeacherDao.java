package com.csu.proxy.staticproxy;
//实现教学接口的类,也要聚合代理类
public class TeacherDao implements ITeacherDao{

    @Override
    public void teach() {
        System.out.println("老师授课中");
    }
}
