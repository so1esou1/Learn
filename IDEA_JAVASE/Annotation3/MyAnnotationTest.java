package com.bjpowernode.java.Annotation3;

public class MyAnnotationTest {

    @MyAnnotation(value = "hehe")
    public void doSome(){

    }

    @MyAnnotation("haha")//可以看到属性名是value的话，属性名可以不写（有两个属性的话也不能省略，比较苛刻）
    public void doOther(){

    }
}
