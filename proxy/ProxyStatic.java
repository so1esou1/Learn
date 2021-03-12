package com.bjpowernode.java2.proxy;
/*
    静态代理模式
 */
public class ProxyStatic {
    public static void main(String[] args) {
        //创建被代理类的对象
        ClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}


interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;       //用被代理对象进行实例化
    //构造器:
    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作...");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作...");
    }
}


class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生成一批运动服");
    }
}

