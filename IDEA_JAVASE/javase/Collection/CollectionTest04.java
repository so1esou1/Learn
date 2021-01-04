package com.bjpowernode.javase.Collection;

import java.util.ArrayList;
import java.util.Collection;

/*
深入Collection集合的contains方法：
    boolean contains(Object o)判断集合中是否包含某个对象o，包含返回true，不包含返回false
    在底层中调用了equals方法进行比对（见画图分析）
 */
public class CollectionTest04 {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();

        //向集合中存储元素
        String s1 = new String("abc");
        c.add(s1);

        String s2 = new String("def");
        c.add(s2);

        //集合中元素的个数
        System.out.println("元素的个数：" + c.size());

        String x = new String("abc");
        System.out.println(c.contains(x));  //结果是？ true   contains方法比较的是内容而不是内存地址
    }
}
