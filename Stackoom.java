package com.csu.jvm.oom;

/*
    栈溢出异常
 */
public class Stackoom {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();       //java.lang.StackOverflowError
    }
}
