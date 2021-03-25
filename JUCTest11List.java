package com.csu.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
    list集合不安全
 */
public class JUCTest11List {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));      //随机生成5个字符串
                System.out.println(list);
            },String.valueOf(i)).start();
            //报错:java.util.ConcurrentModificationException,并发修改异常，集合并发都会出现这种错误
        }
         */


        /*
            解决方案:1、使用集合Vector,但是会影响到效率
                    2、使用工具类Colletions进行转换
                    3、CopyOnWriteArrayList，这才是在JUC中应该使用的解决方案
         */
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        //CopyOnWriteArrayList:
        List<String> list2 = new CopyOnWriteArrayList<>();
        for (int i = 0; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        /*CopyOnWrite:写入时复制COW，计算机设计领域的一种优化策略
        多个线程调用的时候，list读取的时候时固定的，写入的时候避免覆盖，造成数据问题
         */

        //CopyOnWriteArrayList比vector强在效率，vector使用了synchronized修饰，有synchronized修饰的效率都会变低
        //CopyOnWriteArrayList没有使用synchronized修饰，用的lock锁

        //底层使用了private transient volatile Object[] array;
    }
}
