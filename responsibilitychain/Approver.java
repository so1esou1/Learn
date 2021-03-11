package com.csu.responsibilitychain;
/*
    请求人类
 */
public abstract class Approver {
    Approver nextApprover;      //包含下一个处理者
    String name;
    //构造器:
    public Approver(String name){
        this.name = name;
    }

    //下一个处理者:
    public void setApprover(Approver approver) {
        this.nextApprover = approver;
    }

    //处理审批请求的方法,得到一个请求。处理是子类完成的，因此将该方法做成一个抽象
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
