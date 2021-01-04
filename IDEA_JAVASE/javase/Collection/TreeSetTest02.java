package com.bjpowernode.javase.Collection;

import java.util.TreeSet;

/*
1、TreeSet集合底层是一个TreeMap
2、TreeMap集合底层是一个二叉树
3、放到TreeSet集合中的元素，等同于放到TreeMap集合key部分了
4、TreeSet集合中的元素：无序不可重复，但可以按元素大小自动排序，称为可排序集合
 */
public class TreeSetTest02 {
    public static void main(String[] args) {
        //创建一个TreeSet集合
        TreeSet<String> ts = new TreeSet<>();
        //添加String
        ts.add("zhangsan");
        ts.add("lisi");
        ts.add("wangwu");
        ts.add("zhangsi");
        ts.add("wangliu");
        //遍历
        for (String s : ts){
            System.out.println(s);  //按照字典顺序，升序
        }
        TreeSet<Integer> ts2 = new TreeSet<>();
        ts2.add(100);
        ts2.add(200);
        ts2.add(900);
        ts2.add(10);
        for (Integer elt : ts2){
            System.out.print(elt);//10100200900
        }
    }
}

/*

 */