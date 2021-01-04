package com.bjpowernode.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
文件字节输出流，负责写的，从内存到硬盘
 */
public class FileOutputStreamTest01 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            //myfile文件不存在的时候会自动新建
            //这种方式谨慎使用，会先将原文件清空再重新写入
            //fos = new FileOutputStream("myfile");
            //以追加的形式在文件末尾写入，不会清空原文件内容
            fos = new FileOutputStream("myfile",true);
            //开始写.这里是主要的内容
            byte[] bytes ={97,98,99,100};
            //将byte数组全部写出
            fos.write(bytes);  //最后会新建一个myfile的文件，里面是abcd
            fos.write(bytes,0,2);  //将byte数组的一部分写出 再写出ab，结果是abcdab

            //字符串
            String s = "我是一个中国人，我骄傲！";
            //将字符串转换成byte数组
            byte[] bs = s.getBytes();
            //写
            fos.write(bs);

            //写完之后最后一定要刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
