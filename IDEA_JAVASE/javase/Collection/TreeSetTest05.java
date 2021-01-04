package com.bjpowernode.javase.Collection;

import java.util.TreeSet;

/*
先按照年龄升序，年龄一样按照姓名升序
 */
public class TreeSetTest05 {
    public static void main(String[] args) {
        TreeSet<Vip> vips = new TreeSet<>();
        vips.add(new Vip("zhangsan",20));
        vips.add(new Vip("zhangsi",20));
        vips.add(new Vip("king",18));
        vips.add(new Vip("soft",17));
        for (Vip vip : vips){
            System.out.println(vip);
            /*
            输出：Vip{name='soft', age=17}
                Vip{name='king', age=18}
                Vip{name='zhangsan', age=20}

             */
        }
    }
}
class Vip implements Comparable<Vip>{
    String name;
    int age;

    public Vip(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Vip{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    /*
    compareTo方法返回值很重要：
        返回0表示相同，value会覆盖；
        返回>0会继续右子树上找；【10 - 9 = 1，1 > 0，说明左边的数比较大。所以在右子树上找】
        返回<0会继续左子树上找。
     */
    @Override
    public int compareTo(Vip v) {
        //写排序规则，按照什么进行比较
        if (this.age == v.age){
            //年龄相同时按照名字排序
            //姓名是Stringn类型，可以直接比较，调用compareTo来完成比较
            this.name.compareTo(v.name);
        }else{
            //年龄不一样
            return this.age - v.age;
        }
        return 0;
    }
}
