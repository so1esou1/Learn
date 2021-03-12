package com.bjpowernode.java2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
    动态代理
 */
public class ProxyAction {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance就是代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);//superMan被代理

        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("大铁盆");
    }
}


interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe what";
    }
    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/*
    想要实现动态代理，需要解决的问题:
        1、如何根据加载到内存中的被代理类，动态地创建一个代理类及其对象？
        2、当通过代理类的对象调用方法时，如何动态地去调用被代理类中的同名方法?
 */
//动态代理类
class ProxyFactory{
    //调用此方法返回一个代理类的对象，解决问题1
    public static Object getProxyInstance(Object obj){     //obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                handler);
    }
}


//定义接口的实现类
class MyInvocationHandler implements InvocationHandler{
    private Object obj;     //赋值时也需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动调用如下的方法:invoke()
    //将被代理类要执行的方法a的功能声明在invoke()方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类对象调用的方法，此方法也就被作为了被代理类对象要调用的方法
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}