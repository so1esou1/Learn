package com.bjpowernode.javase.danlink;
/*
单链表的节点
节点是单向链表中基本的单元，每一个节点Node都有两个属性：
    一个属性是存储的数据。
    另一个属性是下一个节点的内存地址
 */
public class Node {
    //存储的数据
    Object data;
    //下一个节点的内存地址
    Node next;

    public Node(){

    }

    public Node(Object element,Node next){
        this.data = data;
        this.next = next;
    }

}
