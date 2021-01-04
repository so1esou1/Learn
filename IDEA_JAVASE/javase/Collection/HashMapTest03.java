package com.bjpowernode.javase.Collection;

import java.util.HashMap;
import java.util.Map;

/*
hashMap集合key部分允许null吗？
    允许,但是要注意：HashMap集合的key，null值只能有一个
    hashMap的key和value都是可以为null的
 */
public class HashMapTest03 {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put(null,null);
        System.out.println(map.size());  //1
        //hashMap集合允许key为null
        map.put(null,100);
        System.out.println(map.size());  //key重复了，覆盖

        //通过key获取value
        System.out.println(map.get(null));  //100
    }
}
