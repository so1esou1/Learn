package com.bjpowernode.java.annotation5;
//用反射测试元注解
@MyAnnotation
public class MyAnnotationTest {

    //@MyAnnotation,这里不行（属性位置）
    int i;

    @MyAnnotation  //这里可以
    public void doSome(){
        //@MyAnnotation  这里也不行
        int i;
    }
}
