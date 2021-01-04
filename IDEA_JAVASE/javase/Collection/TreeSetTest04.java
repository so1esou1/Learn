package com.bjpowernode.javase.Collection;

import java.util.TreeSet;
/*
让自定义的类实现comparable
 */
public class TreeSetTest04 {
    public static void main(String[] args) {
        People p1 = new People(32);
        People p2 = new People(20);
        People p3 = new People(30);
        People p4 = new People(25);

        //创建TreeSet集合
        TreeSet<People> peoples = new TreeSet<>();
        //添加元素
        peoples.add(p1);
        peoples.add(p2);
        peoples.add(p3);
        peoples.add(p4);
        //遍历
        for (People p : peoples){
            System.out.println(p);
        }
    }
}
//放在TreeSet集合中的元素需要实现java.lang.Comparable接口
//并且实现compareTo方法。equals可以不写
class People implements Comparable<People>{
    int age;
    public People(int age){
        this.age = age;
    }

    //需要在这个方法中编写比较的逻辑，或者说比较的规则，按照什么进行比较
    //k.compareTo(t.key)
    //拿着参数k和集合中的每一个k进行比较，返回值可能是>0、<0、=0
    //比较规程最终还是由程序员指定的，例如按照年龄升序
    @Override
    public int compareTo(People p) {    //p1.compareTo(c2)
        //this是c1
        //c是c2
        //c1和c2比较的时候就是this和c比较
        /*int age1 = this.age;
        int age2 = p.age;
        if (age1 == age2){
            return 0;
        }else if (age1 > age2){
            return 1;
        }else{
            return -1;
        }*/
        return this.age - p.age;  //更简便的思想  =0 >0 <0  这样是升序排列.排序原理见二叉树数据结构
        //return p.age - this.age;  反过来就是降序排列
    }

    public String toString(){
        return "People[age = " + age + "]";
    }
}
