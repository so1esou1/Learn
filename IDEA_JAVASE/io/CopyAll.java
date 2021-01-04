package com.bjpowernode.java.io;

import java.io.File;

/*
作业：拷贝一个目录(这个程序可能没写完，有点难)
 */
public class CopyAll {
    public static void main(String[] args) {
        //指定拷贝源
        File srcFile =new File("");
        //拷贝目标
        File destFile = new File("C:\\");
        //调用方法拷贝
        copyDir(srcFile,destFile);

    }

    /**
     * 拷贝目录
     * @param srcFile 拷贝源
     * @param destFile 拷贝目标
     */
    private static void copyDir(File srcFile, File destFile) {
        if (srcFile.isFile()){
            //srcFile如果是一个文件的话，递归结束。
            //是文件的话需要拷贝
            //……一边读一边写
            return;
        }
        //获取源下面的子目录
        File[] files = srcFile.listFiles();//拿到下面所有文件
        //代码可以先测一下
        //System.out.println(files.length);
        //进行循环
        for (File file : files){
            //获取所有文件的（包括目录和文件）绝对路径
            System.out.println(file.getAbsolutePath());
            //递归调用
            copyDir(file,destFile);//这个file可能是文件，也可能是目录
        }
    }
}
