package com.csu.visitor;

public class Client {
    public static void main(String[] args) {
        //创建ObjectStructure
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        //成功:
        Success success = new Success();
        objectStructure.display(success);


        System.out.println("=================================================");
        //失败:
        Fail fail = new Fail();
        objectStructure.display(fail);

        //wait:
        System.out.println("=================================================");
        Wait wait = new Wait();
        objectStructure.display(wait);
    }

}
