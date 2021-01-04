package com.bjpowernode.java.io;

import java.io.File;

/*
File中的listFiles方法。
 */
public class FileTest03 {
    public static void main(String[] args) {
        //File[] listFile()
        //获取当前目录下所有的子文件
        File f = new File("E:\\英雄时刻\\201791992");
        File[] files = f.listFiles();  //返回的是一个数组
        //foreach
        for (File file : files){
            System.out.println(file.getAbsolutePath());
        }
    }
}
