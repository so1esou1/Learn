package com.bjpowernode.javase.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 关于集合遍历和迭代专题（重点*****）
 * 迭代器是一个对象
 */
public class CollectionTest02 {
    public static void main(String[] args) {
        //注意：以下讲解的遍历方式/迭代方式，是所有Collection通用的一种方式
        //在Map集合中不能用，在所有Collection以及子类中使用
        //创建集合对象
        Collection c = new ArrayList();//后面的集合无所谓，主要看前面的Collection接口怎么遍历/迭代
        //添加元素
        c.add("abc");
        c.add("def");
        c.add(100);
        c.add(new Object());
        //对集合Collection进行遍历/迭代
        //第一步：获取集合对象的迭代器对象Iterator
        Iterator it = c.iterator();
        //第二步：通过以上获取的迭代器对象开始迭代/遍历集合。
        /*
        以下两个方法是迭代器Iterator中的方法：
            boolean hashNext()如果仍有元素可以迭代，返回true
            Object next() 返回迭代的下一个元素

         */
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
        /*boolean hasNext = it.hasNext();
        System.out.println(hasNext);
        if (hasNext){
            //不管当初存进去的是什么，取出来的都是Object
            Object obj = it.next();
            System.out.println(obj);
        }

        hasNext = it.hasNext();
        System.out.println(hasNext);
        if (hasNext) {
            Object obj = it.next();
            System.out.println(obj);
        }

        hasNext = it.hasNext();
        System.out.println(hasNext);
        if (hasNext) {
            Object obj = it.next();
            System.out.println(obj);
        }

        hasNext = it.hasNext();
        System.out.println(hasNext);
        if (hasNext) {
            Object obj = it.next();
            System.out.println(obj);
        }

        hasNext = it.hasNext();
        System.out.println(hasNext);
        if (hasNext) {
            Object obj = it.next();
            System.out.println(obj);
        }
        */
    }
}
