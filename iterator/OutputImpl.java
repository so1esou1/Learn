package com.csu.iterator;

import java.util.Iterator;
import java.util.List;

/*
    完成对所有学院的输出
 */
public class OutputImpl {
    //拿到学院的集合
    List<College> collegeList;
    //构造器:
    public OutputImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    //调用所有的学院，然后调用printDepartment,输出各个学院的系:
    public void printCollege(){
        //从CollegeList中取出所有的学院:
        Iterator<College> iterator = collegeList.iterator();
        while (iterator.hasNext()){
            //取出一个学院:
            College college = iterator.next();
            System.out.println("=====" + college.getName() + "=====");
            printDepartment(college.createIterator());      //得到对应的迭代器
        }
    }

    //输出学院、系:
    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department d = (Department) iterator.next();
            System.out.println(d.getName());    //输出系

        }
    }
}
