package com.bjpowernode.javase.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
关于集合的迭代/遍历
 */
public class CollectionTest03 {
    public static void main(String[] args) {
        //创建集合对象
        Collection c1 = new ArrayList();//ArrayList集合，有序可重复
        //添加元素
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(4);
        c1.add(1);//可重复

        //迭代集合
        Iterator it = c1.iterator();
        while (it.hasNext()){
            //存进去什么类型，取出来还是什么类型
            Object obj = it.next();
            /*if (obj instanceof Integer){
                System.out.println("Integer类型");
            }*/
            //只不过在输出的时候会转换成字符串。这里println会调用toString()方法
            System.out.println(obj);
            //System.out.println(it.next());//有序，同样的顺序输出
        }

        //HashSet集合：无序不可重复
        Collection c2 = new HashSet();
        c2.add(100);
        c2.add(200);
        c2.add(300);
        c2.add(100);//不可重复
        Iterator it2 = c2.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }
    }
}
