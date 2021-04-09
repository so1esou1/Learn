package com.csu.lru;


import java.util.LinkedHashMap;
import java.util.Map;

public class LRUTest1<K,V> extends LinkedHashMap<K,V>{
    private int capacity;       //缓存坑位

    //构造方法:
    public LRUTest1(int capacity){
        super(capacity,0.75F,true);          //坑位与负载因子
        this.capacity = capacity;
    }


    //大于capacity，则移除的方法
    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return super.size() > capacity;
    }


    public static void main(String[] args) {
        LRUTest1 lruTest1 = new LRUTest1(3);
        lruTest1.put(1,"a");
        lruTest1.put(2,"b");
        lruTest1.put(3,"c");
        System.out.println(lruTest1.keySet());          //[1, 2, 3]

        lruTest1.put(4,"d");
        System.out.println(lruTest1.keySet());          //[2, 3, 4]

        lruTest1.put(3,"c");
        System.out.println(lruTest1.keySet());          //[2, 4, 3]
        lruTest1.put(3,"c");
        System.out.println(lruTest1.keySet());          //[2, 4, 3]
        lruTest1.put(3,"c");
        System.out.println(lruTest1.keySet());          //[2, 4, 3]
        lruTest1.put(5,"x");
        System.out.println(lruTest1.keySet());          //[4, 3, 5]
    }
}
