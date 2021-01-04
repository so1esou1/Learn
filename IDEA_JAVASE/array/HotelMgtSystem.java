package com.bjpowernode.javase.array;
/*
注意：二维数组存储在内存中，断电就没了！后期要学习数据库，数据库会把数据存储在数据文件中，断电也不会出问题！
 */
import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class HotelMgtSystem {
    public static void main(String[] args) {
        //创建酒店对象
        Hotel hotel = new Hotel();
        //打印房间状态
        hotel.print();

        /*
        首先输出欢迎页面
         */
        System.out.println("欢迎使用酒店管理系统，请认真阅读以下使用说明");
        System.out.println("功能编号对应功能：[1]表示查看房间列表。[2]表示预定房间。[3]表示退房。[0]表示退出系统");
        Scanner s = new Scanner(System.in);

        while(true){  //加入死循环，可以一直使用
            System.out.println("请输入功能编号：");
            int i = s.nextInt();
            if (i == 1) {
                //查看房间列表
                hotel.print();
            } else if (i == 2) {
                //订房
                System.out.println("请输入订房编号：");
                int roomNo = s.nextInt();
                hotel.order(roomNo);//房间编号是前台输入的
            } else if (i == 3) {
                //退房
                System.out.println("请输入退房编号：");
                int roomNo = s.nextInt();
                hotel.exit(roomNo);
            } else if (i == 0) {
                //退出系统
                System.out.println("再见，欢迎下次再来");
                return;
            } else {
                //出错
                System.out.println("输入功能编号有误，请重新输入！");

            }
        }
    }
}
