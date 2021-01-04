package com.bjpowernode.javase.Collection;

import javax.imageio.ImageTranscoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Map集合的遍历【非常重要，一定要会】
 */
public class MapTest02 {
    public static void main(String[] args) {
        //第一种方式：获取所有的key，通过遍历key来遍历value
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"zhangsan");
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(4,"zhaoliu");
        //遍历Map集合
        //先获取所有的key，所有的key是一个Set集合
        Set<Integer> keys = map.keySet();
        //遍历key，通过key获取value
        //迭代器可以
        /*Iterator<Integer> it = keys.iterator();
        while(it.hasNext()){
            //取出其中一个key
            Integer key = it.next();
            //通过key获取value
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
         */
        //foreach也可以
        for (Integer key : keys){
            System.out.println(key + "=" + map.get(key));
        }

        //第二种方式：Set<Map.Entry<K,V>> entrySet()     ***这种效率比较高，适合大数据量的情况下，获取key和value都是直接从node对象种获取的属性值
        //这个方法是把Map集合直接全部转换成Set集合
        //Set集合中元素的类型是：Map.Entry
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        //遍历S遍历集合，每一次取出一个Node
        //迭代器
        /*Iterator<Map.Entry<Integer,String>> it2 = set.iterator();
        while (it2.hasNext()){
            Map.Entry<Integer,String> node = it2.next();
            Integer key = node.getKey();
            String value = node.getValue();
            System.out.println(key + "=" + value);
        }
         */
        //foreach的方式
        for (Map.Entry<Integer,String> node:set) {
            System.out.println(node.getKey() + "---->" + node.getValue());
        }
    }
}
