package com.bjpowernode.java.annotation2;

public class MyAnnotationTest {

    //这里报错的原因：如果一个注解中有属性，必须给属性赋值(除非该属性使用了default指定了默认值。)
    /*@MyAnnotation
    public void doSome(){

    }*/
    //@MyAnnotation(属性名=属性值，属性名=属性值，属性名=属性值)

    //指定name属性的值就好了
    @MyAnnotation(name="zhangsan",color = "红色")
    public void doSome(){

    }
}
