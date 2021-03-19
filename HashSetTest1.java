package com.csu.collection;

import java.util.HashSet;
import java.util.Hashtable;

/*
    数组+链表模拟一个HashMap的底层
 */
public class HashSetTest1 {
    public static void main(String[] args) {
        //模拟一个HashMap的底层结构:
        //HashSet的底层就是HashMap

        //1、创建一个数组，数组类型是Node1[]
        //有些人直接把这个Node成为table
        Node1[] table = new Node1[16];

        //2、创建结点:
        Node1 john = new Node1("john", null);

        table[2] = john;
        Node1 jack = new Node1("jack", null);
        john.next = jack;   //将jack结点挂载到john

        Node1 rose = new Node1("rose", null);
        jack.next = rose;       //将rose结点挂载到jack后
        //形成了有三个结点的链表

        Node1 lucy = new Node1("lucy", null);
        table[3] = lucy;    //把lucy放到table表索引为3的位置
    }
}

class Node1{        //结点，存储数据，可以指向下一个结点，从而形成链表
    Object item;        //存放数据
    Node1 next;      //指向下一个结点

    public Node1(Object item, Node1 next) {
        this.item = item;
        this.next = next;
    }

}