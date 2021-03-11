package com.csu.responsibilitychain;
/*
    副校长级别的处理方案
    这些处理方案的代码大致都是一样的
 */
public class VicePresident extends Approver{
    //构造器:
    public VicePresident(String name){
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        //处理金额>10000,<=30000元
        if (purchaseRequest.getPrice() > 10000 && purchaseRequest.getPrice() <= 30000){
            System.out.println("请求编号id=" + purchaseRequest.getId() + "被" + this.name + "处理了");
        }else {
            //让下一个对象来处理
            nextApprover.processRequest(purchaseRequest);
        }
    }
}
