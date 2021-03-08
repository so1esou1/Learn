package com.csu.proxy.dynamic;
/*
    依赖ProxyFactory，通过ProxyFactory返回一个代理对象
 */
public class Client {
    public static void main(String[] args) {
        //1、先创建一个目标对象:
        ITeacherDao target = new TeacherDao();
        //2、给目标对象创建代理对象,可以转成ITeacherDao类型
        ITeacherDao proxyInstance = (ITeacherDao)new ProxyFactory(target).getProxyInstance();

        System.out.println("proxyInstance=" + proxyInstance.getClass());
        //proxyInstance=class com.sun.proxy.$Proxy0,有$符号说明这是一个代理对象
        //说明从内存中动态生成了代理对象

        //通过代理对象调用目标对象的方法:
        proxyInstance.teach();
        proxyInstance.sayHello("tom");

    }
}
