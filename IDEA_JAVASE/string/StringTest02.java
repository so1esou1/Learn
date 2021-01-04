package com.bjpowernode.javase.string;
/*
面试中常见的String类考题
 */
public class StringTest02 {
    public static void main(String[] args) {
        String s1 = "hello";
        //"hello"是存储在方法区的字符串常量池当中，这个hello不会新建，因为已经存在了
        String s2 = "hello";
        System.out.println(s1 == s2); //分析结果是true还是false？分析见画图
        //"=="双等号比较的是变量中保存的内存地址
        //计算结果是true

        String x = new String("xyz");
        String y = new String("xyz");
        System.out.println(x == y);//分析结果是true还是false？分析见同一张画图
        //"=="双等号仍然是比较的变量中的内存地址
        //结果是false

        //结论：字符串对象之间的比较不能使用双等号"=="
        //"=="不保险，应该调用String类的equals方法（String类中的equals已经重写）
        System.out.println(x.equals(y));  //结果是true

        //i变量中保存的是100这个值
        int i = 100;
        //s变量中保存的是字符串对象的内存地址
        //s引用中保存的不是"abc"，是0x1111
        //而0x1111是"abc"字符串对象在“字符串常量池”当中的内存地址
        String s = "abc";

    }
}
