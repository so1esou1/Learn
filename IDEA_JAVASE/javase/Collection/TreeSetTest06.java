package com.bjpowernode.javase.Collection;

import java.util.Comparator;
import java.util.TreeSet;

/*
TreeSet集合中元素可排序的第二种方式：使用比较器的方式
最终结论：
    放到TreeSet或者TreeMap集合key部分的元素，要想做到排序，包括两种方式：
        第一种：放在集合中的元素实现java.lang.Comparable接口。
        第二种：构造TreeSet或者TreeMap集合的时候传一个比较器对象
Comparable和Comparator怎么选择呢？
    当比较规则不会发生改变的时候，或者说当比较规则只有一个的时候，建议实现Comparable接口
    如果比较规则有多个并且需要多个比较规则之间频繁切换，建议使用Comparator接口
    Comparator接口的设计符合ocp原则
 */
public class TreeSetTest06 {
    public static void main(String[] args) {
        //创建TreeSet集合的时候需要使用这个比较器
        //TreeSet<WuGui> wuGuis = new TreeSet<>();  //这样不行，没有通过构造方法传递一个比较器进去

        //给构造方法传递一个比较器
        //TreeSet<WuGui> wuGuis = new TreeSet<>(new WuGuiComparator());

        //大家可以使用匿名内部类的方式(这个类没有名字，直接new接口。)
        TreeSet<WuGui> wuGuis = new TreeSet<>(new Comparator<WuGui>() {
            @Override
            public int compare(WuGui o1, WuGui o2) {
                return o1.age - o2.age;
            }
        });

        wuGuis.add(new WuGui(1000));
        wuGuis.add(new WuGui(800));
        wuGuis.add(new WuGui(810));

        for (WuGui wuGui : wuGuis){
            System.out.println(wuGui);
        }
    }
}
//乌龟
class WuGui{
    int age;

    @Override
    public String toString() {
        return "小乌龟[" +
                "age=" + age +
                ']';
    }

    public WuGui(int age){
        this.age = age;

    }
}
//单独在这里完成一个比较器
//比较器实现java.util.Comparator接口（Comparable是java.lang包下的.Comparator是java.util包下的）
/*
class WuGuiComparator implements Comparator<WuGui>{
    @Override
    public int compare(WuGui o1, WuGui o2) {
        //指定比较规则
        //按照年龄排序
        return o1.age - o2.age;
    }
}
 */


