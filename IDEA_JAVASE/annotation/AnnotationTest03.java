package com.bjpowernode.java.annotation;

import java.lang.annotation.Annotation;

/*
表示这个类已过时@Deprecated
    主要是向其他程序员传递一个信息，告知已过时，有更好的解决方案存在
 */

public class AnnotationTest03 {
    public static void main(String[] args) {
        AnnotationTest03 at = new AnnotationTest03();
        at.doSome();
    }

    @Deprecated
    public void doSome(){
        System.out.println("do something!");
    }
    @Deprecated
    public static void doOther(){
        System.out.println("do other...");
    }
}
class T{
    public static void main(String[] args) {
        AnnotationTest03 at = new AnnotationTest03();
        at.doSome();

        AnnotationTest03.doOther();
    }
}
