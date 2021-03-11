package com.csu.responsibilitychain;
/*
    学院级别的请求处理者
 */
public class CollegeApprover extends Approver{
    //构造器:
    public CollegeApprover(String name){
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        //处理金额>5000,<=10000元
        if (purchaseRequest.getPrice() > 5000 && purchaseRequest.getPrice() <= 10000){
            System.out.println("请求编号id=" + purchaseRequest.getId() + "被" + this.name + "处理了");
        }else {
            //让下一个对象来处理
            nextApprover.processRequest(purchaseRequest);
        }
    }
}
