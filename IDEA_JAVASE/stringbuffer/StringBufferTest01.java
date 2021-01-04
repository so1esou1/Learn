package com.bjpowernode.javase.stringbuffer;
/*
思考：我们在实际的开发中，如果进行字符串的频繁拼接，会有什么问题？
     因为java中字符串是不可变的，每一次拼接都会产生新的字符串，占用大量的方法区内存，造成内存区浪费
          例：String s = "abc";
          s += "hello";
          以上两行代码，导致方法区字符串常量池当作创建了3个对象："abc","hello","abchello"
 */
public class StringBufferTest01 {
    public static void main(String[] args) {
        String s = "";
        //这样做会给java方法区常量池带来很大压力。
        for (int i = 0;i < 100;i ++){
            s += i;
            System.out.println(s);
        }

    }
}
