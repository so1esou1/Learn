package com.csu.threadlocal;

public class OrderService {
    public void createOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderService 当前线程[" + name + "]中保存的数据是:" + ThreadLocalTest.data.get(name));
    }
}
