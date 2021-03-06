package com.csu.principle.inversion;
/*
    依赖倒置原则
    以下程序分析:
    1、简单，比较容易想到
    2、如果我们获取到的对象是微信不是电子邮件等，则需要新增类，同时Person类需要增加新的接收方法
    3、解决思路：引入一个抽象的接口IReceiver,表示接收者,这样Person类与接口发送依赖
                这时因为Eamil和微信都属于接收的范围，它们各自实现IReceiver接口就可以了，这样就符合依赖倒置原则
 */
public class InversionDependencyTest1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}



//完成Person接收消息的功能
class Person{
    public void receive(Email emial){           //这里直接写了一个类，直接依赖了Email类了
        System.out.println(emial.getInfo());
    }
}


class Email{
    public String getInfo(){
        return "电子邮件信息:helloworld";
    }
}
