package com.csu.javase.Object.equals;

/*
1、默认实现：
public boolean equals(Object obj) {
    return (this == obj);
}
在equals，默认采用"=="判断是否相等

2、Sun设计equals的目的是什么？
  通过equals方法来判断两个对象是否相等

3、Object类这给的默认的equals方法不够用。判断两个java对象是否相等不能单纯使用"==",判断的是内存地址是否相等

4、实际上String也是一个类(引用数据类型)，有构造方法
  平常可以这样创建String：String s1 = "hello"
  实际上是这样创建的:     String s1 = new String("hello")
  SUN公司已经重写过了String类的toString()和equals()方法

5、结论:java中什么类型的数据可以使用"=="判断？
          java中基本数据类型可以使用==比较是否相等
       Java中什么类型的数据需要使用equals判断是否相等？
          java中所有的引用数据类型统一使用equals方法判断，这是规矩
 */

public class EqualsTest01 {
}
