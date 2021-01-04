package com.bjpowernode.java.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

/*
BufferedWriter:带有缓冲的字符输出流
OutputStreamWriter:转换流
 */
public class BufferedWriterTest {
    public static void main(String[] args) throws Exception {
        //带有缓冲区的字符输出流
        //BufferedWriter out = new BufferedWriter(new FileWriter("copy"));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copy2",true)));
        out.write("hello world!");
        out.write("\n");
        out.write("hello kitty!");
        //刷新
        out.flush();
        //关闭最外层
        out.close();
    }
}
