package com.bjpowernode.java.reflect;

import java.io.FileReader;

/*
研究以下文件路径的问题
    怎么获取一个文件的绝对路径，以下讲解的这种方式是通用的。前提是文件需要在类路径下才可以使用这种方式
 */
public class AboutPath {
    public static void main(String[] args) throws Exception{
        //FileReader reader = new FileReader("chapter25/classinfo.properties");
        //这样写的话只有IDEA才能找得到，缺点是移植性差
        //离开了IDEA，换到了其他路径，可能当前路径就不是project的根了

        //接下来说一种比较通用的路径。即使代码移植了，这样编写仍是通用的
        //注意：使用以下通用方式的前提：这个文件必须在类路径下
        //什么是类路径下？凡是在src下的都是类路径【要记住】，src是类的根路径
        //下面这行代码需要记住
        /*
        Thread.currentThread()  当前线程对象
        getContextClassLoader()  线程对象的方法，可以获取到当前线程的类加载器对象
        getResource()   类加载器对象的方法，当前线程的类加载器默认从类的根路径下加载资源
        getPath()
         */
        String path = Thread.currentThread().getContextClassLoader().getResource("classinfo2.properties").getPath();
        //采用以上的代码可以拿到一个文件的绝对路径（只要文件在类的根路径下就不会变）
        //通用的
        //System.out.println(path);

        //获取db.properties文件的绝对路径(从类的根路径下作为起点开始)
        String path2 = Thread.currentThread().getContextClassLoader().getResource("com/bjpowernode/java/bean/db.properties").getPath();
    }
}
