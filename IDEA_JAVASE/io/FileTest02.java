package com.bjpowernode.java.io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
File类的常用方法
 */
public class FileTest02 {
    public static void main(String[] args) {
        File f1 = new File("E:\\英雄时刻\\201791992");
        //获取文件名
        System.out.println("文件名 ：" + f1.getName());

        //判断是否是一个目录
        System.out.println(f1.isDirectory()); //true
        //判断是否是一个文件
        System.out.println(f1.isFile());  //false

        //获取文件最后一次修改时间
        long haomiao = f1.lastModified();//毫秒是从1970年到现在的总毫秒数
        //将毫秒转换成日期
        Date time = new Date(haomiao);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = sdf.format(time);
        System.out.println(strTime);

        //获取文件大小
        System.out.println(f1.length());  //0  0字节
    }
}
