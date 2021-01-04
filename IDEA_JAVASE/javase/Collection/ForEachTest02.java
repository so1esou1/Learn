package com.bjpowernode.javase.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
集合使用foreach
 */
public class ForEachTest02 {
    public static void main(String[] args) {
        //创建List集合对象
        List<String> strList = new ArrayList<>();
        //添加元素
        strList.add("hello");
        strList.add("world");
        strList.add("kitty");

        //遍历，使用迭代器方式
        Iterator<String> it = strList.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        //使用下标方式（只针对有下标的集合）
        for (int i = 0;i < strList.size();i ++){
            System.out.println(strList.get(i));
        }

        //使用foreach：
        for (String s : strList){   //因为泛型使用的是String类型，所以是String s
            System.out.println(s);
        }
    }
}
