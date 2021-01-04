package com.bjpowernode.javase.Collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
java.util.Map这个接口中常用的方法：
    1、Map和Collection没有继承关系
    2、Map集合以key和value的方式存储数据：键值对
        Key和Value都是引用数据类型
        Key和Value都是存储对象的内存地址
        Key起到主导的地位，Value是Key的附属品
    3、Map接口中常用方法:
        V put(K key,V value)  向Map集合中添加键值对
        V get(Object key)  通过key获取value
        void clear();   清空Map集合
        boolean containsKey(Object key)  判断Map中是否包含某个Key
        boolean containsValue(Object value) 判断Map中是否包含某个value
        boolean isEmpty()   判断Map集合中元素是否为0
        Set<K> keySet()     获取Map结合所有的key（所有的键是一个Set集合）
        V remove(Object key)    通过key删除键值对
        int size()      获取Map集合中键值对的个数
        Collection<v> values()      获取键值对中所有的value，返回一个Collection
        Set<Map.Entry<K,V>> entrySet()      将Map集合转换成Set集合（Map集合通过entrySet()转换成的这个Set集合中的元素的类型是Map.Entry<K,V>,Map.Entry类型和String类型一样都是一种类型的名字，只不过Map.Entry是静态内部类，是Map中的静态内部类）
 */
public class MapTest01 {
    public static void main(String[] args) {
        //创建Map集合对象
        Map<Integer,String> map = new HashMap<>();
        //向Map集合中添加键值对
        map.put(1,"zhangsan");  //1在这里进行了自动装箱
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(4,"zhaoliu");
        //通过key获取value
        String value = map.get(2);
        System.out.println(value);
        //获取键值对的数量
        System.out.println("键值对数量：" + map.size());
        //通过key删除键值对value
        map.remove(2);
        System.out.println("键值对数量：" + map.size());
        //判断是否包含某个key
        //contains方法底层调用的都是equals方法进行比对的，所以自定义的类型需要重写equals方法
        System.out.println(map.containsKey(4));
        //判断是否包含某个value
        System.out.println(map.containsValue("wangwu"));

        //获取所有的value
        Collection<String> values = map.values();
        for (String s : values){
            System.out.println(s);
        }
        //清空Map集合
        map.clear();
        System.out.println("键值对数量：" + map.size());
        //判断是否为空
        System.out.println(map.isEmpty());

    }
}
