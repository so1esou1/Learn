package com.bjpowernode.javase.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
HashMap集合：
    1、底层是哈希表/散列表的数据结构
    2、哈希表是怎样的数据结构呢？
        哈希表是一个数组和单向链表的结合体
        数组：查询方面效率很高，随机增删方面效率很低
        单向链表：随机增删方面效率高，查询方面效率低
        哈希表充分发挥各自的优点
    3、HashMap集合底层的源代码：
    public class HashMap{
        //HashMap底层实际上就是一个数组（一堆数组）
        transient Node<K,V> table;
        //静态的内部类HashMap.Node
        static class Node<K,V>{
            final int hash;  //哈希值（哈希值是key的hashCode()方法的执行结果。哈希值通过哈希函数/算法，可以转换成数组的下标。）
            final K key;  //存储到Map集合中的key
            V value;  //存储到Map集合中的value
            Node<K,V> next;  //下一个节点的内存地址
        }
    }
    哈希表/散列表是一个一维数组，这个数组中每一个元素是一个单向链表（数组和链表的结合体）
    4、最主要掌握的是：（见图）
        map.put(K,V)
        v = map.get(k)
        以上这两个方法的实现原理，是必须掌握的（存和取的功能）
    5、HashMap集合的key部分特点是什么？
        无序不可重复
        为什么无序？  因为不一定挂到每个单向链表上
        不可重复是怎么实现的？ equals方法来保证HashMap集合上的key不可重复，如果重复了value会覆盖的

        放在HashMap集合key中的元素其实就是放到HashSet集合中了。
        所以HashSet集合中的元素也需要重写HashCode()+equals()方法。
    6、哈希表HashMap使用不当的时候无法发挥性能！
        假设将所有的hashCode()方法返回值固定为某个值，那么会导致底层哈希表变成纯单向链表。这种情况称为散列分布不均匀
        散列分布均匀：假设有100个元素，10个单向链表，那么每个单向链表上有10个节点这是最好的

        假设将所有的HashCode()方法返回值都设定为不一样的值，可以吗？有什么问题？
            不行，因为这样的话导致底层的哈希表变成一维数组，没有一维的概念，也是散列分布不均匀
        散列分布均匀需要重写hashCode()方法时有一定的技巧。

    7、重点：放在HashMap集合key部分的元素，以及放在HashSet集合中的元素，需要同时重写hashCode和equals方法
    8、HashMap集合的默认初始化容量是16，默认加载因子是0.75，这个默认加载因子是当HashMap集合底层数组的容量达到75%的时候数组开始扩容
       重点，记住：HashMap集合初始化容量必须是2的倍数，官方推荐，以到达散列均匀，为了提高HashMap集合的存储效率所必须的


 */
public class HashMapTest01 {
    public static void main(String[] args) {
        //测试HashMap集合key部分的元素特点
        //Integer是key，它的HashCode和equals都重写了。
        Map<Integer,String> map = new HashMap<>();
        map.put(1111,"zhangsan");
        map.put(6666,"lisi");
        map.put(7777,"wangwu");
        map.put(2222,"zhaoliu");
        map.put(2222,"king");//k重复的时候value会自动覆盖。

        System.out.println(map.size());//4

        //遍历Map集合
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for (Map.Entry<Integer,String> entry : set){
            System.out.println(entry.getKey() + "=" + entry.getValue());//无序不可重复
        }
    }
}
