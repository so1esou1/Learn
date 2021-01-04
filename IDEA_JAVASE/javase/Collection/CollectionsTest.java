package com.bjpowernode.javase.Collection;

import java.util.*;

/*
java.util.Collection 集合接口
java.util.Collections 集合工具类，方便集合的操作
 */
public class CollectionsTest {
    public static void main(String[] args) {

        //ArrayList集合不是线程安全的
        List<String> list = new ArrayList<>();

        //变成线程安全的
        Collections.synchronizedList(list);

        //排序
        list.add("abc");
        list.add("abx");
        list.add("abe");
        list.add("abf");

        Collections.sort(list);
        for (String s : list){
            System.out.println(s);
        }

        List<WuGui2> wuGuis = new ArrayList<>();
        wuGuis.add(new WuGui2(1000));
        wuGuis.add(new WuGui2(8000));
        wuGuis.add(new WuGui2(500));
        //注意：对List集合中元素排序，需要保证List集合中的元素实现了Comparable接口。
        Collections.sort(wuGuis);
        for (WuGui2 wg : wuGuis){
            System.out.println(wg);
        }

        //对Set集合怎么排序呢
        Set<String> set = new HashSet<>();
        set.add("king");
        set.add("kingsoft");
        set.add("king2");
        set.add("king1");
        //能不能将Set集合转换为List集合？
        List<String> myList = new ArrayList<>(set);
        Collections.sort(myList);
        for (String s : myList){
            System.out.println(s);
        }

        //这种方式也可以排序
        //Collections.sort(list集合,比较器对象);
    }
}
class WuGui2 implements Comparable<WuGui2>{
    int age;
    public WuGui2(int age){this.age = age;}

    @Override
    public int compareTo(WuGui2 o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "WuGui2{" +
                "age=" + age +
                '}';
    }
}
