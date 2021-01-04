package com.bjpowernode.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
对第一个程序进行改进，循环方式

    分析这个程序的缺点：一次读取一个字节bytee，这样内存和硬盘交互太频繁，基本上时间和资源都耗费到交互上了
 */
public class FileInputStream02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("F:/JAVA学习/temp.txt");

            while (true){
                int readData = fis.read();
                if (readData == -1){
                    break;
                }
                System.out.println(readData);
            }

            //改造while循环,以后io流循环可能都是这样写
            int readData = 0;
            while ((readData = fis.read()) != -1){
                System.out.println(readData);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
