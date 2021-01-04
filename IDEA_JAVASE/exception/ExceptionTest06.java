package com.bjpowernode.javase.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;

/*                  代码的执行顺序
处理异常的第一种方式，谁调用我这个方法我就抛给谁。抛给调用者来处理
处理异常的第二种方式：。。。。
    **注意：只要异常没有捕捉，此方法的后续代码不会执行
      另外需要注意try语句块某一行出现异常，该行后面的代码不会执行。
      try...catch捕捉异常之后后续代码可以执行。
 */
public class ExceptionTest06 {
    //一般不建议在main方法上使用throws，因为这个异常如果真的发生了，一定会抛给JVM来处理，JVM只有终止
    //异常处理机制的作用就是增强程序的健壮性。怎么做到的，异常发生了也不影响程序的执行，
    //所以一般异常的处理建议使用try...cacth进行捕捉，main就不要继续上抛了
    public static void main(String[] args) {
        System.out.println("main begin");
        try {
            m1();
            //以上代码出现异常，直接进入catch语句块中执行。
            System.out.println("hello world!");
        } catch (Exception e) {   //catch后面的好像一个方法的形参，e是一个内存地址
            //这个分支中可以使用e引用，e保存的内存地址是那个new出来的异常对象的内存地址
            //在catch分支中干什么？处理异常
            //catch是捕捉异常之后走的分支
            System.out.println("文件不存在，可能路径错误，也可能该文件被删除了！");
            System.out.println(e);//java.io.FileNotFoundException: F:\JAVA学习\jdk api 中文帮助文档1.8_China (拒绝访问。)
        }
        //try..catch抓住之后，这里的代码会继续执行
        System.out.println("main over");
        //后面的over都不再执行了
    }

    private static void m1() throws Exception {
        System.out.println("m1 begin");
        m2();
        //如果出现异常，下面一行无法执行
        System.out.println("m1 over");
    }

    //private static void m2() throws ClassCastException,FileNotFoundException{  也可以写多个异常，中间用逗号隔开
    private static void m2() throws Exception{  //或者继续上抛,可以直接写Exception，它包括所有的异常
        System.out.println("m2 begin");
        //编译器报错的原因是：m3方法声明位置上有throws FileNotFoundException
        //我们在这里调用m3()没有进行预处理，所以编译器报错
        m3();
        //捕捉
        /*try {
            m3();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        System.out.println("m2 over");
    }

    private static void m3() throws FileNotFoundException {
        //调用SUN jdk中的某个类的构造方法，这个类后期IO流的时候就知道了,创建一个输入流，指向一个文件
        //new FilterInputStream("F:\\JAVA学习\\jdk api 中文帮助文档1.8_China");
        //思考这里为什么这里是报错
        //编译报错的原因是:1、这里调用了一个构造方法，FilterInputStream（String name）
        //2、这个构造方法的声明位置上有：throws FileNotFoundException
        //3、通过类的继承结构看到： FileNotFoundException父类是IOException,IOException的父类是Exception
        //最终得知：FileNotFoundException是编译时异常。
        //采用第一种方式：方法上抛，方法声明位置上使用throws继续上抛
        //如果一个方法体中的代码出现异常之后，如果上报的话，此方法结束，与return方法类似
        new FileInputStream("F:\\JAVA学习\\jdk api 中文帮助文档1.8_China");


        System.out.println("如果以上代码出异常，这里会执行吗？？？？？？？？？？？？不会！！！");

    }

}
