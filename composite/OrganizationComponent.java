package com.csu.composite;
//组织的抽象类，所有组织类都可以继承
public abstract class OrganizationComponent {
    private String name;        //机构名字
    private String des;         //描述
    protected void add(OrganizationComponent organizationComponent){      //添加的方法
        //默认实现,因为某些类是叶子结点，下面不能添加，不需要具体实现
        throw new UnsupportedOperationException();      //抛出不支持操作的异常
    }

    protected void remove(OrganizationComponent organizationComponent){     //移除的方法
        throw new UnsupportedOperationException();
    }
    //构造器
    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }
    //getset方法:
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }


    //打印的方法,做成抽象的，因为都有:
    protected abstract void print();
}
