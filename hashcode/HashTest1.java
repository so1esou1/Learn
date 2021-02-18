package com.csu.javase.Object.hashcode;

/*
hashcode方法：
  1、源代码:
    public native int hashCode();
    底层调用的C++程序实现的

  2、实际上返回的就是一个java对象的内存地址，经过哈希算法得出一个值
  所以hashCode()方法执行结果可以等同看作一个java对象的内存地址
 */
public class HashTest1 {
}
