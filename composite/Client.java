package com.csu.composite;
//客户端
public class Client {
    public static void main(String[] args) {
        //从大到小创建对象
        OrganizationComponent university = new University("中南大学", "一般货色");  //用OrganizationComponent类来接收

        //创建学院
        College college1 = new College("马克思学院", "混日子");
        College college2 = new College("公共管理学院", "同上");

        //创建系
        college2.add(new Department("系1","123"));
        college2.add(new Department("系2","456"));
        college2.add(new Department("系3","789"));
        college1.add(new Department("系4","438"));
        college1.add(new Department("系5","558"));

        //将学院加入到学校中
        university.add(college1);
        university.add(college2);

        //输出打印:
        university.print();

        //college1.print();
    }
}
