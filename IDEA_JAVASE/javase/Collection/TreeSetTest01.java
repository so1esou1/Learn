package com.bjpowernode.javase.Collection;

import java.util.Set;
import java.util.TreeSet;

/*了解一下
TreeSet测试
    TreeSet集合存储元素特点：
        1、无序不可重复，但是存储元素可按照大小顺序排序，
        称为可排序集合

 */
public class TreeSetTest01 {
    public static void main(String[] args) {
        //创建集合对象
        Set<String> strs = new TreeSet<>();
        //添加集合对象
        strs.add("A");
        strs.add("B");
        strs.add("Z");
        strs.add("Y");
        strs.add("Z");
        strs.add("K");
        strs.add("M");
        //遍历
        for (String s : strs){
            System.out.print(s);//ABKMYZ  从小到大自动排序
        }
    }
}
