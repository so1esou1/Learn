package com.bjpowernode.javase.array;
/*
酒店的房间
 */
public class Room {
    //房间编号、类型、状态
    private int no;//1楼：101、102、103...；2楼：...；3楼：...;...
    private String type;//标准间、单人间、豪华间、总统套房
    private boolean status;//true表示空闲，房间可以被预定；false表示占用，房间不能被预定

    public Room() {
    }

    public Room(int no, String type, boolean status) {
        this.no = no;
        this.type = type;
        this.status = status;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
//IDEA工具对于boolean类型的变量，生成的get方法是isXxx(),可以修改为getXxx
    /*public boolean isStatus() {
        return status;
    }*/
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    //equals方法和toString方法应该重写（规定的编程素养）

    //equals
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof Room)) return false;
        if (this == obj) return true;
        Room room = (Room)obj;
        if (this.no == room.getNo()) return true;
        //当前房间编号 等于 传过来的房间对象的房间编号。认为是同一个房间。
        return this.getNo() == room.getNo();
    }


    //toString的目的是将java对象转换成字符串形式，怎么转，转成什么样程序员自己定，目的是简单明了
    public String toString(){
        //把一个变量塞到一个字符串中，口诀：加一个双引号，双引号中间加两个加号，两个加号中间加变量名
        return "["+no+","+type+","+(status ? "空闲" : "占用")+"]";  //难点，多看看
    }
    //可以编写一个临时程序测试以下，一会可以删除这个main方法
    /*
    public static void main(String[] args) {
        Room room = new Room(101,"单人间",false);
        System.out.println(room.toString());
        //room是一个引用，println(引用)会自动调用引用的toString()方法
        System.out.println(room);
    }
    测试完毕*/

}

