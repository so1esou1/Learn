package com.csu.javase.Object.toString;
/*
1、toString的源代码：

源代码上toString()方法的目的是什么？
  类名@对象的内存地址转换为十六进制的形式

2、设计toString()方法的目的
  调用这个方法可以将一个“java对象”转换成“字符串”
  toString()方法应该是一个简洁的、详实的、易阅读的
 */
public class toStringTest01 {
    public static void main(String[] args) {
        MyTime t1 = new MyTime(1980,1,1);
        String s1 = t1.toString();

        //重写tostring方法之前：
        System.out.println(s1);//com.csu.javase.Object.toString.MyTime@7ef20235

        //重写之后
        System.out.println(s1);//1980年1月1日
    }
}
class MyTime{
    int year;
    int month;
    int day;
    public MyTime(){
    }

    public MyTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //怎么重写toString()方法
    //越简洁、详实越好
    public String toString(){
        return this.year + "年" + this.month + "月" + this.day + "日";
    }
}

