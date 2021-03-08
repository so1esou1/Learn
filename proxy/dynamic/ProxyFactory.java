package com.csu.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
    ***代理工厂
 */
public class ProxyFactory {
    //首先要维护一个目标对象
    private Object target;
    //构造器，对目标对象进行初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }


    //核心方法:返回代理对象的方法,根据传入的对象(TeacherDao),利用反射机制，返回一个代理对象，通过代理对象调用目标对象的方法
    public Object getProxyInstance(){
        //需要重写newProxyInstance方法
        //参数介绍:
        //1、ClassLoader loader:指定当前目标对象使用的类加载器，获取加载器的方法固定
        //2、Class<?>[] interfaces:目标对象实现的接口类型，使用泛型的方式确认类型
        //3、InvocationHandler h:事件处理，执行目标对象方法时，会触发事件处理器的方法。会把当前执行的目标对象方法作为参数传入
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    //这里是重写的InvocationHandler方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理开始");
                        //通过反射机制调用目标对象的方法:
                        Object returnVal = method.invoke(target, args);

                        System.out.println("JDK代理中");
                        return returnVal;
                    }
                });
    }
}
