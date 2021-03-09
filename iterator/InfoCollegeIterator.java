package com.csu.iterator;

import java.util.Iterator;
import java.util.List;
/*
    信息院,实现hasNext和next方法
 */
public class InfoCollegeIterator implements Iterator {
    List<Department> departmentList;       //信息工程学院以List方式存放系
    int index = -1;         //遍历集合的索引
    //构造器
    public InfoCollegeIterator(List<Department> departments) {
        this.departmentList = departments;
    }


    @Override
    public boolean hasNext() {
        if (index >= departmentList.size() - 1){        //判断集合中还有没有下一个
            return false;
        }else {
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    //空实现remove方法:
    public void remove(){

    }
}
