package com.bjpowernode.java2.reflect;

import com.bjpowernode.java2.bean.People;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    调用修改运行时类中指定的结构4:构造器1
 */
public class ReflectTest13 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = People.class;

        //1、获取构造器:
        //IDEA中推荐方法:clazz.getDeclaredConstructor().newInstance()
        Constructor dc = clazz.getDeclaredConstructor(String.class);    //参数指明构造器的参数列表

        //2、保证此构造器是可访问的:
        dc.setAccessible(true);

        //3、调用此构造器创建运行时类的对象:
        People p = (People) dc.newInstance("zhangsan");
        System.out.println(p);
    }
}
