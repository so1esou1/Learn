package com.bjpowernode.java.annotation;
/*
关于JDK lang包下的Override注解
源代码：
public @interface Override {
}
标识性注解，编译器看到方法上有这个注解的时候，编译器会自动检查该方法是否重写了父类的方法
如果没有重写，报错


override这个注解只能注解方法
是给编译器参考的，只在编译期起作用，和运行阶段没有关系
凡是java中的方法带有这个注解的，编译器都会进行编译检查，如果这个方法不是重写父类的方法，编译器报错
 */
public class AnnotationTest02 {
    @Override
    public String toString() {
        return "toString";
    }
}
