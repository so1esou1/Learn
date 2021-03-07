package com.csu.composite;
//最小的单位，叶子结点
public class Department extends OrganizationComponent{
    //构造器
    public Department(String name, String des) {
        super(name, des);
    }
    //add、remove方法不用写了,不用管理其他方法
    //没有集合，不包含其他任何组织了

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

    //重写print方法
    @Override
    protected void print() {
        System.out.println(getName());
    }
}
