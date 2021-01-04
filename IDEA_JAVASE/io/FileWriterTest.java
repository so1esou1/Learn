package com.bjpowernode.java.io;

import java.io.FileWriter;
import java.io.IOException;

/*
FileWriter：
    文件字符输出流，只能输出普通文本
 */
public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter out = null;
        try {
            //创建一个文件字符输出流对象
            out = new FileWriter("file");

            //开始写
            char[] chars = {'我','是','中','国','人'};
            out.write(chars);
            out.write(chars,2,3);

            out.write("我是一名java软件工程师！");

            out.write("\n");// 换行符
            out.write("hello world");
            //刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out == null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
