package com.bjpowernode.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
FileInputStream类的其他常用方法：
    int available() :返回流当中剩余的字节数量
    Long skip(Long n) ：跳过几个字节不读
 */
public class FileInputStreamTest05 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("F:\\JAVA学习\\temp.txt");
            /*System.out.println("总字节数量：" + fis.available());
            //读一个字节
            int readByte = fis.read();
            //还剩下可以读的字节数量是：5
            System.out.println("还剩下多少个字节没有读：" + fis.available());
            //这个方法有什么用？
            byte[] bytes = new byte[fis.available()];
            //可以new一个已有长度的数组，不需要循环了，直接读一次就行了
            //这种方式不太适合大文件，原因：
            //因为byte[]数组不能太大
            int readCount = fis.read(bytes);
            System.out.println(new String(bytes));  //bcdef
             */

            //跳跃,skip跳过几个字节不读取，可能以后会用
            fis.skip(3);
            System.out.println(fis.read());  //100

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (fis == null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
