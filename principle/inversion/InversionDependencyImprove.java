package com.csu.principle.inversion;
/*
    依赖倒置原则，对test1进行改进
 */
public class InversionDependencyImprove {
    public static void main(String[] args) {
        //客户端无须改变
        Person1 person = new Person1();
        person.receive(new Email1());
        person.receive(new WeChat());       //微信消息
    }
}

//先定义一个接口
interface IReceiver{
    public String getInfo();
}

class Email1 implements IReceiver{
    public String getInfo(){
        return "电子邮件信息:helloworld";
    }
}

class Person1{
    public void receive(IReceiver iReceiver){           //传进来IReceiver，依靠此接口与Email依赖
        System.out.println(iReceiver.getInfo());
    }
}

//增加微信
class WeChat implements IReceiver{
    //这里我们是对接口的依赖
    public String getInfo(){
        return "微信消息";
    }
}
