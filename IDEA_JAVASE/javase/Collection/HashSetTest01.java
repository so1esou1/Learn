package com.bjpowernode.javase.Collection;

import java.util.HashSet;
import java.util.Set;

/*了解一下
HashSet集合：
    无序不可重复
    放到HashSet集合中的元素实际上是放到HashMap集合的key部分了

 */
public class HashSetTest01 {
    public static void main(String[] args) {
        //演示一下HashSet集合特点
        Set<String> strs = new HashSet<>();

        //添加元素
        strs.add("hello3");
        strs.add("hello4");
        strs.add("hello1");
        strs.add("hello3");
        strs.add("hello3");

        //遍历
        for (String s : strs){
            System.out.print(s);//hello1hello4hello3
        }
    }
}
