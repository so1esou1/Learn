package com.csu.composite;

import java.util.ArrayList;
import java.util.List;

//和University类非常相似
public class College extends OrganizationComponent{
    //这个List中存放的是Department
    List<OrganizationComponent> organizationComponents = new ArrayList<>();
    //构造器:
    public College(String name, String des) {
        super(name, des);
    }

    //重写add方法:
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        //将来实际业务中College的add和University的add方法不一定相同
        organizationComponents.add(organizationComponent);
    }
    //重写remove方法:
    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }
    //重写getName方法
    @Override
    public String getName() {
        return super.getName();
    }
    //重写getDes方法
    @Override
    public String getDes() {
        return super.getDes();
    }

    //重写print方法，就是输出University包含的学院
    @Override
    protected void print() {
        System.out.println("----------------" + getName() + "----------------");
        //遍历organizationComponents
        for (OrganizationComponent organizationComponent : organizationComponents){
            organizationComponent.print();
        }
    }



}
