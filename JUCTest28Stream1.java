package com.csu.juc;

import java.util.Arrays;
import java.util.List;

/*
    流式计算Stream

    要求筛选:
        1、ID必须是偶数
        2、年龄必须大于23
        3、用户名必须转为大写字母
        4、用户名字母倒着排序
        5、只输出一个用户
 */
public class JUCTest28Stream1 {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(5, "e", 25);
        //集合负责存储，计算交给流Stream
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        //java.util.stream
        //链式编程:
        list.stream().              //先将list转换成流
                filter(u->{return u.getId()%2==0;}).    //filter内部是断定式接口
                filter(u->{return u.getAge()>23;}).
                map(u->{return u.getName().toUpperCase();}).        //map内部是函数式接口
                sorted((uu1,uu2)->{return uu2.compareTo(uu1);}).    //倒序排序
                limit(1).       //只输出一个用户
                forEach(System.out::println);       //遍历打印结果，foreach内部是消费型接口
    }
}

class User{
    private int id;
    private String name;
    private int age;
    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
