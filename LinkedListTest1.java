package com.csu.collection;


import java.util.LinkedList;

public class LinkedListTest1 {
    public static void main(String[] args) {
        //模拟一个简单的双向链表:
        Node tom = new Node("tom");
        Node jack = new Node("jack");
        Node zhangsan = new Node("zhangsan");

        //连接三个结点，形成双向链表:
        jack.next = tom;
        tom.next = zhangsan;
        zhangsan.pre = tom;
        tom.pre = jack;

        //让first的引用指向jack,就是双向链表的头结点
        Node first = jack;
        //双向链表的尾结点
        Node last = zhangsan;


        //演示:从头到尾进行遍历:
        while (true){
            if (first == null){
                break;
            }
            //输出first信息:
            System.out.println(first);
            first = first.next;
        }

        //演示:从尾到头进行遍历:
        while (true){
            if (last == null){
                break;
            }
            //输出first信息:
            System.out.println(last);
            last = last.pre;
        }

        //演示链表添加一个数据是多么方便:
        Node smith = new Node("smith");

        smith.next = zhangsan;
        smith.pre = tom;
        zhangsan.pre = smith;
        tom.next = smith;

        first = jack;       //重置first指针，让first再指向第一个人
    }
}

class Node{
    public Object item;     //真正存放数据
    public Node next;       //指向后一个节点
    public Node pre;        //指向前一个结点
    public Node(Object name){
        this.item = name;
    }
    public String toString(){
        return "Node name=" + item;
    }
}
