package com.csu.mediator.renthouse;

public class Client {
    public static void main(String[] args) {
        //创建中介者对象:
        MediatorStructure ms = new MediatorStructure();
        //创建租房者对象:
        Tenant tenant = new Tenant("张三", ms);   //租房者的姓名和中介对象
        HouseOwner houseOwner = new HouseOwner("李四", ms);   //房主的姓名和中介对象

        //中介者要知道具体的房主和中介者:
        ms.setTenant(tenant);
        ms.setHouseOwner(houseOwner);
        //结构创建完毕
        tenant.constact("租房");  //租房者发送信息
        houseOwner.constact("彳亍");  //房主发送信息
    }
}
