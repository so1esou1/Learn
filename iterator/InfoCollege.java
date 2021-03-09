package com.csu.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class InfoCollege implements College {
    List<Department> departmentList;
    //构造器
    public InfoCollege(){
        departmentList = new ArrayList<Department>();
        addDepartment("专业1","描述1");
        addDepartment("专业2","描述2");
        addDepartment("专业3","描述3");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departmentList.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}
