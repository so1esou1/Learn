package com.bjpowernode.java.annotation6;

import java.lang.reflect.Method;

/*
通过反射机制获取注解对象的属性
 */
public class MyAnnotationTest {
    @MyAnnotation(username = "admin",password = "123")
    public void doSome(){

    }

    public static void main(String[] args) throws Exception{
        //获取MyAnnotationTest的doSome()方法上面的注解信息
        //先拿这个类
        Class c = Class.forName("com.bjpowernode.java.annotation6.MyAnnotationTest");
        //获取doSome方法
        Method doSomeMethod = c.getDeclaredMethod("doSome");
        //判断该方法上是否存在这个注解
        if (doSomeMethod.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation = doSomeMethod.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation.username());
            System.out.println(myAnnotation.password());
        }
    }
}
