package com.bjpowernode.java.annotation5;

public class ReflectAnnotationTest {
    public static void main(String[] args) throws Exception{
        //获取类
        Class c = Class.forName("com.bjpowernode.java.annotation5.MyAnnotationTest");
        //判断类上面是否有@MyAnnotation
        //System.out.println(c.isAnnotationPresent(MyAnnotation.class));  //判断是否有注释存在的方法
        if (c.isAnnotationPresent(MyAnnotation.class)){
            //获取该注解对象
            MyAnnotation myAnnotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);  //还要转型
            System.out.println("类上面的注解对象" + myAnnotation);

            //怎么获取注解对象的属性？和调接口没区别
            String value = myAnnotation.value();
            System.out.println(value);
        }
    }
}
