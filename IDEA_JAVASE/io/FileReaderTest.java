package com.bjpowernode.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
FileReader：
    是一个文件字符输入流，只能读取普通文本，读取文本内容时比较方便快捷
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            //创建文件字符输入流
            reader = new FileReader("myfile2");
            //准备一个char数组
            char[] chars = new char[4];
            //往char数组中读
            reader.read(chars);  //按照字符的方式读取
            for (char c : chars){
                System.out.println(c);
            }
            /*//开始读
            char[] chars = new char[4];   //一次读取4个字符
            int readCount = 0;
            while ((readCount = reader.read(chars)) != -1){
                System.out.print(new String(chars,0,readCount));
            }
             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader == null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
