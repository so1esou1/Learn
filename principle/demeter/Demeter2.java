package com.csu.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/*
    使用迪米特原则改进1中的代码
 */
public class Demeter2 {
    public static void main(String[] args) {
        System.out.println("使用迪米特法则的改进");
        SchoolManager2 schoolManager = new SchoolManager2();
        schoolManager.printAllEmployee(new CollegeManager2());
    }
}


class Employee2 {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
class CollegeEmployee2 {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
class CollegeManager2 {
    //返回学院的所有员工
    public List<CollegeEmployee2> getAllEmployee() {
        List<CollegeEmployee2> list = new ArrayList<CollegeEmployee2>();
        for (int i = 0; i < 10; i++) {      //这里我们增加了10个员工到 list(模拟)
            CollegeEmployee2 emp = new CollegeEmployee2();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }


    //在这里输出学院员工的信息:
    public void printEmployee(){
        //获取到学院的员工
        List<CollegeEmployee2> list1 = this.getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee2 e : list1) {
            System.out.println(e.getId());
        }
    }

}

class SchoolManager2 {
    //返回学校总部的员工
    public List<Employee2> getAllEmployee() {
        List<Employee2> list = new ArrayList<Employee2>();

        for (int i = 0; i < 5; i++) { //这里我们增加了5个员工到 list
            Employee2 emp = new Employee2();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    //该方法完成输出学校总部和学院员工信息(id)
    void printAllEmployee(CollegeManager2 sub) {

        //解决:
        //1、将输出学院的员工的方法，封装到CollegeManager2中

        //把这段剪走
        /*List<CollegeEmployee2> list1 = sub.getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee2 e : list1) {
            System.out.println(e.getId());
        }*/
        sub.printEmployee();


        //获取到学校总部员工
        List<Employee2> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee2 e : list2) {
            System.out.println(e.getId());
        }
    }
}