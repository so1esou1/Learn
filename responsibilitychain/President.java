package com.csu.responsibilitychain;
/*
    校长级别的处理方案
 */
public class President extends Approver{
    //构造器:
    public President(String name){
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        //处理金额>30000元
        if (purchaseRequest.getPrice() > 30000){
            System.out.println("请求编号id=" + purchaseRequest.getId() + "被" + this.name + "处理了");
        }else {
            //让下一个对象来处理
            nextApprover.processRequest(purchaseRequest);
        }
    }
}
