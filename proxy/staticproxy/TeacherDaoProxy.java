package com.csu.proxy.staticproxy;
//代理对象(静态代理)，也要实现接口
public class TeacherDaoProxy implements ITeacherDao{

    private ITeacherDao target;         //我们的目标对象(被代理的目标)，通过接口来聚合
    //构造器:
    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("代理老师授课中");
        target.teach();
        System.out.println("代理结束");
    }
}
