package com.bjpowernode.javase.Collection;

import com.bjpowernode.javase.bean.Costomer;

import java.util.HashSet;
import java.util.Set;
/*
1、向Map集合中存，以及从Map集合中取，都是先调hashCode方法，然后再调用equals方法！
equals方法有可能调用，也有可能不调用
    拿put(k,v)举例，什么时候equals不会调用？
        k.hashCode()方法返回哈希值，哈希值经过哈希算法转换成数组下标。数组下标位置上如果是null，equals不需要执行
    拿get(k)举例，什么时候equals不会调用？
        k.hashCode()方法返回哈希值，哈希值经过哈希算法转换成数组下标。如果数组下标位置上是null，equals不需要执行
2、注意：如果一个类的equals方法重写了，那么hashCode()方法必须重写。
并且equals返回的值是true（表示两个对象相同，在同一个单向链表上比较，同一链表中的节点哈希值都是相同的），hashCode()返回的值必须一样
3、hashCode()方法和equals()方法不用研究，直接用IDEA工具生成，但是这两个方法必须同时生成
 */
public class HashMapTest02 {
    public static void main(String[] args) {
        Costomer c1 = new Costomer("zhangsan");
        Costomer c2 = new Costomer("zhangsan");

        //重写equals方法之前是false
        //System.out.println(c1.equals(c2));   false

        //重写equals之后是true
        System.out.println(c1.equals(c2));  //true

        //没有重写hashCode方法之前
        System.out.println("c1的hashCode=" + c1.hashCode());   //c1的hashCode=2129789493（重写hashCode后的值：-1432604525）
        System.out.println("c2的hashCode=" + c2.hashCode());   //c2的hashCode=1313922862（重写hashCode后的值：-1432604525与上一样）

        //c1.equals(c2)结果已经是true了，表示c1和c2是相同的，那么王HashSet集合中放的话，
        // 按说只能放进去一个（HashSet集合特点：无序不可重复）
        Set<Costomer> costomers = new HashSet<>();
        costomers.add(c1);
        costomers.add(c2);
        System.out.println(costomers.size());   //2，按说结果应该是1，显然不符合存储特点，hashCode方法必须重写
    }
}
