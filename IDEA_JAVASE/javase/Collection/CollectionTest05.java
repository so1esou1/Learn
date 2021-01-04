package com.bjpowernode.javase.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/*
测试contains方法
    放在集合里面的元素，要重写equals方法，没重写之前比较内存地址，重写之后比较具体内容
测试remove方法
底层都调用了equals方法，equals是需要重写的（重写equals是程序员的素养）
 */
public class CollectionTest05 {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();
        //创建用户对象
        User u1 = new User("jack");

        //加入集合
        c.add(u1);
        //判断集合中是否包含u2
        User u2 = new User("jack");

        //没有重写equals之前，这个结果是false
        //System.out.println(c.contains(u2));false
        //重写equals方法之后，比较的时候会比较name
        System.out.println(c.contains(u2));//true

        Integer x = new Integer(10000);
        c.add(x);

        Integer y = new Integer(10000);
        System.out.println(c.contains(y));  //true

        //创建集合对象
        Collection cc = new ArrayList();
        //创建字符串对象
        String s1 = new String("hello");
        //加进去
        cc.add(s1);
        //创建了一个新的字符串对象
        String s2 = new String("hello");
        //删除s2
        cc.remove(s2);
        //集合中元素个数是？
        System.out.println(cc.size()); //0，删除s2就是删除s1，s1.equals(s2);java认为s1和s2是一样的
    }
}
class User{
    private String name;
    public User(){}
    public User(String name){
        this.name = name;
    }

    //重写equals方法
    //将来调用equals方法时一定是调用这个重写的equals方法
    //这个equals方法的比较原理是：只要姓名一样就表示同一个用户
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof User))  return false;
        if (o == this) return true;
        User u = (User)o;
        //如果名字一样表示同一个人
        return u.name.equals(this.name);
    }
}
