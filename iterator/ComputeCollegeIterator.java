package com.csu.iterator;

import java.util.Iterator;

/*
    计算机院,实现hasNext和next方法
 */
public class ComputeCollegeIterator implements Iterator {
    //这里我们需要直到Department是以怎样的方式存放的
    Department[] departments;
    int position = 0;       //代表遍历的位置
    //构造器
    public ComputeCollegeIterator(Department[] departments) {
        this.departments = departments;
    }


    //判断是否还有下一个元素
    @Override
    public boolean hasNext() {
        if (position >= departments.length || departments[position] == null){
            return false;
        }else {
            return true;
        }
    }


    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }

    //删除的方法默认空实现:
    public void remove(){

    }
}
