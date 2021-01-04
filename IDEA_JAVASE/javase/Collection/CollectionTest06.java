package com.bjpowernode.javase.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
关于集合元素的remove
    重点：当集合的结构发生变化时，迭代器必须重新获取，如果用老的迭代器，会出现异常

    重点：在迭代集合元素过程中，不能调用集合对象的remove方法，删除元素：
        c.remove(o);迭代过程中不能这样，会出现异常：java.util.ConcurrentModificationException

    重点：在迭代元素时，一定要使用迭代器Iterator的remove方法删除元素，不要使用集合自带的remove方法删除元素
 */
public class CollectionTest06 {
    public static void main(String[] args) {
       /*
       //创建集合
        Collection c = new ArrayList();

        //此时获取的迭代器指向的是没有元素状态下的迭代器
        //一定要注意：集合结构只要发生改变，迭代器必须重新获取。
        //当集合结构发生改变，迭代器没有重新获取时，调用next()方法会出现异常：java.util.ConcurrentModificationException
        Iterator it = c.iterator();
        //添加元素
        c.add(1);
        c.add(2);
        c.add(3);
        //获取迭代器
        //Iterator it = c.iterator();
        while (it.hasNext()){
            //编写代码时next()方法返回值类型必须是Object
            //Integer i = it.next();
            Object obj =it.next();
            System.out.println(obj);
        }
        */
        Collection c2 = new ArrayList();
        c2.add("abc");
        c2.add("def");
        c2.add("xyz");

        Iterator it2 = c2.iterator();
        while (it2.hasNext()){
            Object o = it2.next();
            //删除元素
            //删除元素之后，集合的结构发生变化，应该获取新的迭代器
            //但是循环下一次的时候并没有重新获取迭代器，所以会出现异常：
            //出异常的根本原因是集合元素删除了，迭代器不知道集合变化了
            //c2.remove(o);//直接通过集合删除元素，没有报与迭代器（导致迭代器快照与原集合状态不同），会报错
            //使用迭代器来删除可以吗？
            //迭代器去删除时，会自动更新迭代器，并且更新集合（删除集合中的元素）
            it2.remove();//删除的一定是迭代器指向的当前元素。
            System.out.println(o);
        }
        System.out.println(c2.size());  //0
    }
}
