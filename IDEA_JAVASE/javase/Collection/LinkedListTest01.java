package com.bjpowernode.javase.Collection;

import com.bjpowernode.javase.danlink.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
链表优点：由于链表上的元素在空间存储上内存地址不连续
        所以随机增删元素的时候不会有大量元素位移，因此随机增删效率较高
        在以后的开发过程中，如果遇到随机增删集合中元素的业务较多时，交易使用LinkedList
链表缺点：不能通过数学表达式计算被查找元素的内存地址，每一次查找都是从头节点开始遍历，直到找到为止，所以检索/查找效率较低

    特别有代表性：
    ArrayList：把数组的特点发挥到极致（末尾添加元素效率较高）
    LinkedList：把链表的特点发挥到极致
    加元素都是往末尾加，所以ArrayList用的比较多
 */
public class LinkedListTest01 {
    public static void main(String[] args) {
        //LinkedList集合底层也是有下标的
        //注意：ArrayList之所以检索效率比较高，不是单纯因为下标，是因为底层数组发挥的作用
        //LinkedList集合照样有下标，但是检索/查找某个元素的时候效率较低，因为只能从头节点一个一个遍历
        List list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");

        for (int i = 0;i < list.size();i ++){
            Object obj = list.get(i);
            System.out.println(obj);
        }

        //LinkedList有初始化容量一说吗？
        //没有，最初这个链表中没有任何元素。first和last引用都是null
        //不管是LinkedList还是ArrayList，以后写代码不需要关系具体是哪个集合，
        //因为我们要面向接口编程，调用的方法都是接口中的方法
        List list2 = new LinkedList();//把这里的LinkedList改成ArrayList，下面输出的结果也不会改变。这样写表示底层使用了双向链表
        //List list2 = new ArrayList();这样写表示底层使用了数组
        list2.add("123");
        list2.add("456");
        list2.add("789");
        for (int i =  0;i < list2.size();i ++){
            System.out.println(list2.get(i));
        }
    }
}
