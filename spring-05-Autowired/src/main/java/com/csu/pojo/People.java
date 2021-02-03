package com.csu.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;


public class People {
    @Autowired         //自动装配注解,使用反射机制实现的，可以不用set、get方法了
    @Qualifier(value = "cat111")   //如果自动装配环境比较复杂，自动装配无法通过一个注解【@Autowired】完成的时候，可以使用@Qualifier(value="cat111")去配合@Autowired的使用
    private Cat cat;
    @Autowired(required = false)    //如果显示定义了Autowired的required属性为false，说明这个对象可以为null，否则不允许为空
    @Resource
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName( @Nullable String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
