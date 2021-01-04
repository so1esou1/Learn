package com.bjpowernode.java.reflect;
/*
研究以下：Class.forName()发生了什么？
    记住重点：如果只是希望一个类的静态代码块执行，其他代码一律不执行
    可以使用：Class.forName("完整类名");
    这个方法的执行会导致类加载，类加载时，静态代码块执行

提示：后面JDBC时还需要这行代码
 */
public class ReflectTest04 {
    public static void main(String[] args) {     //如果只想让一个类的静态代码块执行就这样写
        try {
            //Class.forName()这个方法的执行会导致：类加载
            Class.forName("com.bjpowernode.java.reflect.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*class MyClass{
    //静态代码块在类加载时执行，并且只执行一次
    static {
        System.out.println("MyClass类的静态代码块执行了！");
    }
}*/

