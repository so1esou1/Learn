package com.csu.mediator.renthouse;
/*
    具体的中介者角色类
 */
public class MediatorStructure extends Mediator{
    //要聚合两个角色:房屋拥有者、租房者
    private HouseOwner houseOwner;
    private Tenant tenant;
    //提供getset方法:
    public HouseOwner getHouseOwner() {
        return houseOwner;
    }
    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }
    public Tenant getTenant() {
        return tenant;
    }
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    //实现沟通的方法:
    @Override
    public void constact(String message, Person person) {
        //先判断是租房者还是房主:
        if (person == houseOwner){
            tenant.getMessage(message);       //获取租房者的沟通信息
        }else if(person == tenant){
            houseOwner.getMessage(message);       //获取房主的沟通信息
        }
    }
}
