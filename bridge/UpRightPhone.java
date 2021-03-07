package com.csu.bridge;

public class UpRightPhone extends Phone{
    public UpRightPhone(Brand brand) {
        super(brand);       //调用的是父类的构造器
    }

    public void open(){
        super.open();
        System.out.println("直立样式手机");
    }
    public void close(){
        super.close();
        System.out.println("直立样式手机");
    }
    public void call(){
        super.call();
        System.out.println("直立样式手机");
    }
}
