package com.csu.proxy.staticproxy;
//创建代理对象，创建TeacherDao对象，将TeacherDao对象交给TeacherDaoProxy对象，执行相关方法
public class Client {
    public static void main(String[] args) {
        //1、先创建目标对象(被代理对象)
        TeacherDao teacherDao = new TeacherDao();
        //2、创建代理对象，同时将被代理对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        //3、通过代理对象调用被代理对象的方法,执行的是代理对象的方法，代理对象再去执行被代理对象的方法
        teacherDaoProxy.teach();
    }
}
