package com.bjpowernode.java.reflect;

import java.io.FileReader;
import java.util.Properties;

/*
验证反射机制的灵活性
    java代码写一遍，在不改变java源代码的基础之上，可以做到不同对象的实例化，非常灵活（符合OCP开闭原则：对扩展开放，对修改关闭）

后期我们要学习框架，而工作过程中也是使用高级框架，包括ssh、ssm（会发现大部分时间都是写配置文件）
这些高级框架底层实现原理都采用了反射机制，所以反射机制还是重要的
学会了反射机制有利于理解剖析框架底层的源代码
 */
public class ReflectTest03 {
    public static void main(String[] args) throws Exception{
        //这种方式写死了，只能创建User类型的对象
        //User user = new User();

        //以下代码是灵活的，代码不需要改动，可以修改配置文件，配置文件修改之后可以创建不同的实例对象

        //通过IO流读取classinfo.properties文件
        FileReader reader = new FileReader("chapter25/classinfo.properties");
        //创建属性类对象
        Properties pro = new Properties();  //key、value都是String
        //加载
        pro.load(reader);
        //关闭流
        reader.close();
        //通过key获取value
        String className = pro.getProperty("className");
        //System.out.println(className);

        //通过反射机制实例化对象
        Class c = Class.forName("className");
        Object obj = c.newInstance();
        System.out.println(obj);  //classinfo.properties配置文件内容改变，这里也会自动改变，这个类中不需要进行任何改动
    }
}
