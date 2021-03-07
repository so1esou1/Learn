package com.csu.bridge;

//折叠式手机类，继承抽象Phone
/*
    FoldedPhone调用open，是调用的父类Phone中的open，Phone通过关联Brand，Brand再去找下面的品牌实现。像桥一样
 */
public class FoldedPhone extends Phone{
    //构造器
    public FoldedPhone(Brand brand) {
        super(brand);       //调用的是父类的构造器
    }

    public void open(){
        super.open();
        System.out.println("折叠样式手机");
    }
    public void close(){
        super.close();
        System.out.println("折叠样式手机");
    }
    public void call(){
        super.call();
        System.out.println("折叠样式手机");
    }
}
