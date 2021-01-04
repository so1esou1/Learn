package com.bjpowernode.java.annotation;
/*
1、注解或称注释类型：Annotation
2、Annotation是一种引用数据类型，编译后生成xxx.class文件
3、怎么自定义注解呢？语法格式？
    [修饰符列表] @interface 注解类型名{

    }
4、注解怎么用？用在什么地方？
    （1）注解使用时的语法格式：
        @注解类型名
    （2）注解可以出现在类上、属性上、方法上、变量上等，甚至注解类型上
 */
@MyAnnotation
public class AnnotationTest01 {
    @MyAnnotation
    private int no;

    public AnnotationTest01(){

    }

    public static void m1(){
        @MyAnnotation
        int i = 100;
    }
    public void m2(@MyAnnotation
                   String name,
                   @MyAnnotation
                   int k  ){

    }

}
@MyAnnotation
interface MyInterface{

}
@MyAnnotation
enum Season{
    SPRING,SUNMMER,AUTUMN,WINTER
}
