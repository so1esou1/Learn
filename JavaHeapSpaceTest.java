package com.csu.jvm.oom;

import java.util.Random;

/*

 */
public class JavaHeapSpaceTest {
    public static void main(String[] args) {
        String str = "zhangsan";

        while (true){
            str += str + new Random().nextInt(111111)+new Random().nextInt(22222222);
            str.intern();
        }
        //java.lang.OutOfMemoryError: Java heap space对内存溢出
    }
}
