package com.csu.jvm;

/*
    native关键字
 */
public class NativeTest1 {
    public static void main(String[] args) {
        new Thread(()->{

        },"my thread name").start();        //start底层有这个:  private native void start0();
    }
}
