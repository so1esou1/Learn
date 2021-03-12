package com.bjpowernode.java2.reflect;

import com.bjpowernode.java2.bean.People;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    调用修改运行时类中指定的结构3:方法1
 */
public class ReflectTest12 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = People.class;
        //1、创建运行时类的对象:
        People p =(People) clazz.newInstance();

        //2、获取指定的某个方法:
        Method method = clazz.getDeclaredMethod("show",String.class);       //参数是方法名和形参

        //3、记得将方法设置为可访问
        method.setAccessible(true);
        /*
            4、invoke()参数一:方法的调用者  参数二：给方法赋值的实参
         */
        method.invoke(p,"中");
        //invoke()的返回值即为对应类中调用的方法的返回值
        System.out.println("===================================");




        //如何调用静态方法?
        Method find = clazz.getDeclaredMethod("find");
        find.setAccessible(true);
        Object invoke = find.invoke(People.class);//注意：这里使用当前的类去调用!!!(其实任意对象都可以，因为是静态方法)
        System.out.println(invoke);     //如果调用的运行时类中的方法没有返回值，此invoke()返回null
    }
}
