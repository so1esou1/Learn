package com.bjpowernode.javase.stringbuffer;
/*
java.Lang.StringBuilder

  StringBuilder和StringBuffer的区别？
     StringBuffer中的方法都有：synchronized关键字修饰，表示StringBuffer在多线程环境下运行是安全的
     StringBuilder中的方法都没有synchronized关键字修饰，表示StringBuilder在多线程环境下运行是不安全的

 */
public class StringBuilderTest01 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();//初始化容量也是16
        sb.append(100);
        sb.append(true);
        sb.append("hello");
        sb.append("kitty");
        System.out.println(sb);
    }
}

