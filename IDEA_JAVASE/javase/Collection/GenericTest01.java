package com.bjpowernode.javase.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
1、JDK5.0后推出的新特性：泛型
2、泛型这种语法机制，只是在程序编译阶段起作用，只是给编译器参考的。（允许阶段泛型没用！）
3、使用泛型的好处：
    1、集合中存储的元素类型统一
    2、从集合中取出的元素类型是泛型指定的类型，不需要进行大量的“向下转型”
4、泛型的缺点：
    导致集合中存储的元素缺乏多样性
    大多数业务中，集合中元素类型还是统一的，所以这种泛型特性被大家所认可
 */
public class GenericTest01 {
    public static void main(String[] args) {
        /*先不使用泛型，分析程序存在的缺点
        List myList =new ArrayList();
        //准备对象
        Cat c = new Cat();
        Bird b = new Bird();
        //讲对象添加到集合当中去
        myList.add(c);
        myList.add(b);
        //遍历集合，取出每个Animal，让它move
        Iterator it = myList.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            //obj中没有move方法，无法调用，需要向下转型！
            if (obj instanceof Animal){
                Animal a = (Animal) obj;
                a.move();
            }
        }
        */

        //使用JDK5.0之后的泛型机制
        //使用泛型List<Animal>之后，表示List集合中只允许存储Animal类型的数据
        //用泛型来指定集合中的存储的数据类型，存储其他类型就编译报错了
        //这样集合中元素的数据类型更加统一了
        List<Animal> myList =new ArrayList<Animal>();

        Cat c = new Cat();
        Bird b = new Bird();

        myList.add(c);
        myList.add(b);

        //获取迭代器(Iterator源代码后面有<E>,说明可以支持泛型)
        //这个表示迭代器迭代的是Animal类型
        Iterator<Animal> it = myList.iterator();
        while (it.hasNext()){
            //使用泛型之后每一次迭代返回的数据都是Animal类型，这里不需要使用强制类型转换了，直接调用
            //Animal a = it.next();
            //a.move();
            //调取子类型特有的方法，还是需要向下转换的！
            Animal a = it.next();
            if (a instanceof Cat){
                Cat x = (Cat)a;
                x.catchMouse();
            }
            if (a instanceof Bird){
                Bird y = (Bird)a;
                y.fly();
            }
        }
    }
}
class Animal {
    //父类自带方法
    public void move(){
        System.out.println("动物在移动！");
    }
}
class Cat extends Animal {
    //特有方法
    public  void catchMouse(){
        System.out.println("猫抓老鼠！");
    }
}
class Bird extends Animal{
    //特有方法
    public void fly(){
        System.out.println("鸟儿在飞翔！");
    }
}
