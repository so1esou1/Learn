package com.bjpowernode.java.annotation4;
/*
注解当中的属性可以是哪些类型？
 */
public @interface MyAnnotation {
    //byte short int long float double boolean char
    //String Class 枚举
    //属性的类型可以是以上的每一种以及其数组形式。
    //其他类型都不可以
}
