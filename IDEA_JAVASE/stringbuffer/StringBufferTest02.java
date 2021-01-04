package com.bjpowernode.javase.stringbuffer;
/*
如果以后需要进行大量字符串的拼接操作，建议使用JDK中自带的：
        java.Lang.StringBuffer
        java.Lang.StringBuilder
   //如何优化stringBuffer的性能？
       //在创建stringBuffer时尽可能给定一个初始化容量，最好减少底层数组的扩容次数，预估计一下
       //超过容量部分会自动扩容，但扩容次数越低效率越高
 */
public class StringBufferTest02 {
    public static void main(String[] args) {
        //创建一个初始化容量为16个byte[]数组（字符串缓冲区对象）
        StringBuffer stringBuffer = new StringBuffer();

        //拼接字符串，以后拼接字符串统一调用append()方法，append是追加的意思
        stringBuffer.append("a");
        stringBuffer.append("b");
        stringBuffer.append("d");
        stringBuffer.append(3.14);
        stringBuffer.append(true);
        //append方法在进行追加的时候，如果byte数组满了，会自动扩容
        stringBuffer.append(100L);
        System.out.println(stringBuffer.toString());//toString()表示把stringBuffer转换成为字符串


        //指定初始化容量的StringBuffer对象(字符串缓冲区对象)
        StringBuffer sb = new StringBuffer(100);//容量太大的话也比较浪费，关键给个合适的初始化容量可以提高程序的执行效率
        sb.append("hello");
        sb.append("world");
        sb.append("hello");
        sb.append("kitty");
        System.out.println(sb.toString());
    }
    //String的字符串不可变是因为被final修饰了，而stringBuffer没有用final修饰
    //String会产生新的字符串对象，而使用stringBuffer不会产生新的对象，旧的对象被垃圾回收器释放了




}
