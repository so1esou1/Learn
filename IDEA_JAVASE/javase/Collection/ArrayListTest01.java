package com.bjpowernode.javase.Collection;

import java.util.ArrayList;
import java.util.List;

/*
ArrayList集合：
    1、默认初始化容量是10（底层先创建了一个长度为0的数组，当添加第一个元素的时候，初始化容量为10.优化作用）
    2、集合底层是Object[]数组
    3、构造方法：
        new ArrayList();
        new ArrayList(20);
    4、ArrayList集合的扩容：
        原容量的1.5倍
        ArrayList集合的底层是数组，怎么优化？
            尽可能少的扩容。因为数组扩容效率比较低，建议在使用ArrayList集合的时候预估计元素的个数，给定一个初始化容量，这是ArrayList集合比较重要的策略
    5、数组优点：检索效率较高
    6、缺点：随机增删元素效率较低，另外数组无法存储大数据量

    7、但是需要注意的是：向数组末尾添加元素效率还是很高的，不受影响
    8、面试官经常问的问题：这么多的集合中你用哪个最多？
        答案：ArrayList集合。因为检索、往末尾添加元素较多
    9、ArrayList集合是非线程安全的集合
 */
public class ArrayListTest01 {
    public static void main(String[] args) {
        //默认初始化容量是10，数组长度是10
        List list1= new ArrayList();
        System.out.println(list1.size());//0,size方法获取当前集合中元素的个数，不是获取集合容量

        //指定初始化容量，长度是20
        List list2= new ArrayList(20);
    }
}
