package com.csu.hashtable;

import java.util.Scanner;

/*
    实现哈希表

    例子:要求将该员工的信息加入(id,性别,年龄,名字,住址..),当输入该员工的id时,要求查找到该员工的 所有信息.

 */
public class HashTableTest01 {
    public static void main(String[] args) {
        //(四)创建哈希表
        HashTable hashTable = new HashTable(7);

        //写一个简单菜单
        String key = "";        //一会要接受的用户的输入
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("show:显示全部雇员");
            System.out.println("find:输入id查找雇员");
            System.out.println("exit:退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id:");
                    int id = scanner.nextInt();
                    System.out.println("输入名字:");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "show":
                    hashTable.show();
                    break;
                case "find":
                    System.out.println("请输入要查找的id:");
                    id = scanner.nextInt();
                    hashTable.find(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }


    }
}





//(三)写一个哈希表，来管理多条链表
class HashTable{
    private EmpLinkedList[] empLinkedLists;         //这个数组中放的是链表
    private int size;                   //表示共有多少条链表

    //构造器
    public HashTable(int size) {
        this.size = size;
        //初始化empLinkedLists
        empLinkedLists = new EmpLinkedList[size];
        //注意，没有以下代码的话会报空指针异常,不要忘了分别初始化每一条链表(未初始化的链表里面为空，不能和员工进行绑定)
        //使用for循环分别初始化所有链表
        for (int i = 0;i < size;i ++){
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //添加雇员的方法(真正的添加是要通过哈希表对链表进行操作，而不是直接操作链表)
    public void add(Emp emp){
        //根据员工的id得到该员工应当添加到哪个链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedLists[empLinkedListNo].add(emp);
    }

    //遍历所有的链表,遍历哈希表
    public void show(){
        for (int i = 0;i < size;i ++){
            empLinkedLists[i].show(i);
        }
    }

    //编写一个散列函数,使用一个简单的取模法进行
    public int hashFun(int id){
        return id % size;
    }

    //根据输入的id查找雇员
    public void find(int id){
        //使用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNo].find(id);
        if (emp != null){           //找到
            System.out.println("在第" + (empLinkedListNo+1) + "条链表中找到了雇员" + id);
        }else {
            System.out.println("在哈希表中没有找到该雇员");
        }
    }
}




//(一)表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;        //next默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}






//(二)创建一个EmpLinkedList,表示链表
class EmpLinkedList{
    //头指针指向第一个雇员Emp,因此我们这个链表的head是直接指向第一个Emp雇员的
    private Emp head;       //默认null

    //添加雇员到链表
    //现在先假定添加雇员时id是自增长的，id的分配总是从小到大，因此增加时加在链表的最后即可
    public void add(Emp emp){
        //如果是添加第一个雇员
        if (head == null){
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针帮助定位到最后
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){       //说明已经到链表最后了
                break;
            }
            //否则:
            curEmp = curEmp.next;       //后移，直到最后
        }
        //退出时直接将emp加到链表最后即可
        curEmp.next = emp;
    }

    //遍历链表中的雇员信息
    public void show(int no){
        if (head == null){      //说明链表为空(这个链表中的第一个结点就存放雇员信息)
            System.out.println("第" + (no+1) + "条链表为空");
            return;
        }
        System.out.print("第" + (no+1) + "链表的信息为:");
        Emp curEmp = head;      //辅助指针
        while (true){
            System.out.println("=>id=" + curEmp.id + ",name=" + curEmp.name);
            if (curEmp.next == null){           //判断是否是最后一个节点
                break;      //退出，否则空指针异常
            }
            curEmp = curEmp.next;       //后移，遍历
        }
        System.out.println();
    }


    //根据id查找的方法
    //找到就返回emp，找不到就返回空
    public Emp find(int id){
        //判断链表是否为空
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){       //说明找到了
                break;
            }
            //退出条件:
            if (curEmp.next == null){       //说明当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;       //往后移
        }
        return curEmp;
    }
}