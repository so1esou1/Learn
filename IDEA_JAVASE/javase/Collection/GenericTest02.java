package com.bjpowernode.javase.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
JDK8之后，引入了自带类型推断机制（称为钻石表达式）
 */
public class GenericTest02 {
    public static void main(String[] args) {
        //ArrayList<这里的类型会自动推断>()，JDK8之后才允许
        //自动类型推断，钻石表达式！
        List<Animal> myList =new ArrayList<>();

        myList.add(new Animal());
        myList.add(new Cat());
        myList.add(new Bird());

        //遍历
        Iterator<Animal> it = myList.iterator();
        while (it.hasNext()){
            Animal a = it.next();
            a.move();
        }

        List<String> strList = new ArrayList<>();
        strList.add("abc");
        strList.add("def");
        strList.add("123");
        //遍历
        Iterator<String> it2 = strList.iterator();
        while (it2.hasNext()){
            //如果没有使用泛型
            /*Object obj = it2.next();
            if(obj instanceof String){
                String ss = (String)obj;
                ss.substring(2);
            }
            */
            //通过迭代器获取了String类型的数据
            String s = it2.next();
            //调用String类的subString方法截取字符串
            String newString = s.substring(2);
            System.out.println(newString);
        }
    }
}
