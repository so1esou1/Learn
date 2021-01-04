package com.bjpowernode.java.annotation5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//只允许该注解可以标注类、方法
@Target(value = {ElementType.TYPE,ElementType.METHOD}) //表示以下注解只能出现在类和方法上
//希望这个注解可以被反射
@Retention(value = RetentionPolicy.RUNTIME)  //表示可以被反射到
public @interface MyAnnotation {
    String value() default "北京大兴区";
}
