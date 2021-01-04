package com.bjpowernode.java.io;

import java.io.File;

/*
File：
    1、File类和四大家族没有关系，所以File类不能完成文件的读和写。
    2、File对象代表什么？
        文件和目录路径名的抽象表示形式，File对象有可能是目录，也有可能是文件
        只是抽象表示形式，不能通过他完成读和写
    3、需要掌握File类中常用的方法
 */
public class FileTest01 {
    public static void main(String[] args) throws Exception{
        //创建一个File对象
        File f1 = new File("E:\\file");
        //判断文件存不存在
        System.out.println(f1.exists());

        //如果E:\file不存在，则以文件的形式创建出来
        /*if (!f1.exists()){
            //以文件形式创建
            f1.createNewFile();
        }*/
        //如果E:\file不存在，则以目录的形式创建出来
        /*if (!f1.exists()){
            f1.mkdir();
        }*/
        //可以创建多重目录吗？
        /*File f2 = new File("E:/a/b/c/d/e/f");
        if (!f2.exists()){
            //以多重目录的形式新建。
            f2.mkdirs();  //这有个s别忘了加
        }*/
        File f3 = new File("E:\\英雄时刻\\201791992");
        //获取该文件的父路径
        String parentPath = f3.getParent();
        System.out.println(parentPath);
        //获取绝对路径
        File parentFile = f3.getParentFile();
        System.out.println("获取绝对路径：" + parentFile.getAbsolutePath());
        File f4 = new File("copy");
        System.out.println("绝对路径:" + f4.getAbsolutePath());//C:\Users\xfs\IdeaProjects\javase02\copy
    }
}
