package com.csu.proxy.cglib;
//这里的目标对象不用再实现接口了

public class TeacherDao {
    public void teach(){
        System.out.println("老师授课中，cglib代理，不需要实现接口");
    }
}
