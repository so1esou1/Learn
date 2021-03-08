package com.csu.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
    实现cglib.jar包中的MethodInterceptor接口
    getInstance()给目标对象target创建一个代理对象
    重写interceptor方法，实现对被代理对象(目标对象)方法的调用
 */
public class ProxyFactory implements MethodInterceptor {
    //维护一个目标对象
    private Object target;
    //构造器，传入一个被代理的对象
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回一个代理对象:是target对象的代理对象
    public Object getProxyInstance(){
        //1、创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2、设置一个父类
        enhancer.setSuperclass(target.getClass());
        //3、设置回调函数
        enhancer.setCallback(this);
        //4、创建子类对象，即代理对象
        return enhancer.create();
    }


    //重写intercept方法，这个方法会调用目标对象的方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理模式开始");
        Object returnVal = method.invoke(target, objects);
        System.out.println("cglib代理模式~提交");
        return returnVal;
    }
}
