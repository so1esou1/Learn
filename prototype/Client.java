package com.csu.prototype;

public class Client {
    public static void main(String[] args) {
        //创建10只羊:

        //使用传统的方法:
        Sheep sheep1 = new Sheep("tom",1,"白色");
        //克隆:
        Sheep sheep2 = new Sheep(sheep1.getName(), sheep1.getAge(), sheep1.getColor());
        Sheep sheep3 = new Sheep(sheep1.getName(), sheep1.getAge(), sheep1.getColor());
        Sheep sheep4 = new Sheep(sheep1.getName(), sheep1.getAge(), sheep1.getColor());
        Sheep sheep5 = new Sheep(sheep1.getName(), sheep1.getAge(), sheep1.getColor());
        //。。。。。
        System.out.println(sheep1);
        System.out.println(sheep2);
        //.......


    }
}
