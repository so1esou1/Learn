package com.bjpowernode.javase.exception;
/*
1、java的异常处理机制
    1.1 异常在java中以类和对象的形式存在。那么异常的继承结构是怎样的？
    我们可以用UML图来描述继承结构
    画UML图有很多工具，例如Rational Rose（收费）、starUML等。。。
2、什么是UML，有什么用？
    UML（Unified Modeling Language）是一种统一建模语言，一种图标式语言（画图）
    只要是面向对象的编程语言都有UML，一般画UML的都是软件架构师或系统分析师这些级别的人使用的

    在UML图中可以描述类与类间的关系，程序执行的流程，对象的状态等。

    盖大楼-->建筑师设计图纸（标注专业标准的语言）-->施工

    软件设计/分析师负责设计类，java软件开发人员必须要能看懂
 */
public class ExceptionTest03 {
    public static void main(String[] args) {
        System.out.println(100/0);
        //这里的helloworld没有执行，因为程序执行到上面发生了java.lang.ArithmeticException异常
        //底层new了一个ArithmeticException异常对象，然后抛给了main方法，main方法没有处理，抛给了JVM
        //JVM最终终止程序的执行
        //ArithmeticException继承RuntimeException，属于运行时异常，在编写程序阶段不需要进行预先的处理
        System.out.println("helloworld");
    }
}
