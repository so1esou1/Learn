package com.csu.responsibilitychain;
/*
    系级别的处理方案
 */
public class DepartmentApprover extends Approver{
    //构造器:
    public DepartmentApprover(String name){
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        //处理金额<=5000元
        if (purchaseRequest.getPrice() <= 5000){
            System.out.println("请求编号id=" + purchaseRequest.getId() + "被" + this.name + "处理了");
        }else {
            //让下一个对象来处理
            nextApprover.processRequest(purchaseRequest);
        }
    }
}
