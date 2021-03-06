package com.csu.prototype.improve;
/*
    克隆羊问题
 */
public class Sheep implements Cloneable{            //实现Cloneable类
    private String name;
    private int age;
    private String color;
    private String address = "蒙古羊";     //使用了克隆的话，原型属性发生了改变，克隆体的属性也会自动发生改变!!!

    public Sheep friend;       //有一个朋友羊。来验证对象在克隆时该如何处理?是复制一份朋友还是引用指向朋友?

    //构造器
    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
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
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Sheep{" +"name='" + name + '\'' +", age=" + age +", color='" + color + '\'' +'}';
    }


    //重写克隆的方法,使用默认的clone()方法来完成
    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheep;
    }
}
