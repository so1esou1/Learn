package com.bjpowernode.java.annotation4;

public class OtherAnnotationTest {
    @OtherAnnotation(age = 25,email = {"zhangsan@qq.com","lisi@qq.com"})  //数组是大括号
    public void doSome(){

    }

    @OtherAnnotation(age = 25,email = "zhangsan@qq.com")  //如果数组只有一个，大括号可以省略
    public void doOther(){

    }
}
