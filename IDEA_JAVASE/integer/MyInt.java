package com.bjpowernode.javase.integer;
/*
这种包装类目前是自己写的，实际开发过程中不需要自己写
SUN公司已经写好了，直接用
 */
public class MyInt {
    int value;

    public MyInt() {
    }

    public MyInt(int value) {
        this.value = value;
    }

    //重写toString()方法

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
