package com.csu.responsibilitychain;

public class Client {
    public static void main(String[] args) {
        //先创建一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 30010, 1);

        //创建相关的审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        VicePresident vicePresident = new VicePresident("王副校长");
        President president = new President("吴校长");

        //还需要将各个级别审批人的下一个设置好，不处理好的话会出现问题:
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(vicePresident);
        vicePresident.setApprover(president);
        //处理人要构成一个环形，让处理必须从最下面开始判断审批
        president.setApprover(departmentApprover);


        //让校长去处理的话，最终也能交给系:
        president.processRequest(purchaseRequest);
    }
}
