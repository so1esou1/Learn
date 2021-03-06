package com.csu.prototype.improve;
/*
    使用原型模式改进克隆羊问题+浅拷贝
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("原型模式完成对象的创建");
        Sheep sheep1 = new Sheep("tom",1,"白色");

        sheep1.friend = new Sheep("jack",2,"黑色");       //给tom创建朋友

        Sheep sheep2 = (Sheep) sheep1.clone();
        Sheep sheep3 = (Sheep) sheep1.clone();
        Sheep sheep4 = (Sheep) sheep1.clone();
        Sheep sheep5 = (Sheep) sheep1.clone();


        System.out.println("sheep2=" + sheep2 + sheep2.friend.hashCode());
        System.out.println("sheep3=" + sheep3 + sheep3.friend.hashCode());
        System.out.println("sheep4=" + sheep4 + sheep4.friend.hashCode());
        //这些朋友的哈希码都是一样的，对象并没有被复制一份，只是对象的引用指向了第一个对象的引用的地址
        //这就是浅拷贝


    }
}
