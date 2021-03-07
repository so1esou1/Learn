package com.csu.bridge;

public abstract class Phone {
    //组合品牌
    private Brand brand;        //关联上
    //构造器
    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open(){
        this.brand.open();
    }
    protected void close(){
        brand.close();
    }
    protected void call(){
        brand.call();
    }
}
