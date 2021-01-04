package com.bjpowernode.javase.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
测试List接口中常用方法
    1、List集合存储元素特点：有序（有下标，从0开始）可重复
    2、List既然是Collection接口中的子接口，那么肯定有自己特色的方法
        以下只列出List接口特有的常用的方法:
            void add(int index,Object element)
            Object set(int index,Object element)
            Object get(int index)
            int indexOf(Object o)
            int LastIndexOf(Object o)
            Object remove(int index)

            以上几个代码不需要死记硬背，可以自己编写代码测试一下，理解一下，以后开发的时候翻阅开发文档
 */
public class ListTest01 {
    public static void main(String[] args) {
        //创建List类型的集合
        List myList = new ArrayList();

        //添加元素
        myList.add("A");//向集合末尾添加元素
        myList.add("B");
        myList.add("C");
        myList.add("D");

        //向集合指定位置添加指定元素
        //使用效率低，用的不多
        myList.add(1,"KING");

        //迭代
        Iterator it = myList.iterator();
        while (it.hasNext()){
            Object elt = it.next();
            System.out.println(elt);
        }

        //根据下标获取元素
        Object firstObj = myList.get(0);
        System.out.println(firstObj);

        //因为有下标，所以List集合有自己比较特殊的遍历方式
        //通过下标遍历[List集合特有的方式，Set没有]
        for (int i =0;i < myList.size();i ++){
            Object obj = myList.get(i);
            System.out.println(obj);
        }

        //获取指定对象第一次出现处的索引
        System.out.println(myList.indexOf("KING"));//1

        //获取指定对象最后一次出现处的索引
        System.out.println(myList.lastIndexOf("C"));

        //删除指定下标位置的元素
        myList.remove(0);//删除下标为0的元素
        System.out.println(myList.size());

        System.out.println("==============================================");

        //修改指定位置的元素
        myList.set(2,"Soft");
        //遍历集合
        for (int i =0;i < myList.size();i ++){
            Object obj = myList.get(i);
            System.out.println(obj);
        }
    }
}
