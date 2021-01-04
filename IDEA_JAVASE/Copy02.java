package com.bjpowernode.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
使用FileReader FileWriter进行拷贝的话只能拷贝“普通文本”文件
 */
public class Copy02 {
    public static void main(String[] args) {
        FileReader in = null;
        FileWriter out = null;
        try {
            //读
            in = new FileReader("chapter23/src/com/bjpowernode/java/io/Copy02.java");
            //写
            out = new FileWriter("Copy02.java");

            //一边读一边写
            char[] chars = new char[1024 * 512];  //1MB
            int readCount = 0;
            while ((readCount = in.read(chars)) != -1 ){
                out.write(chars,0,readCount);
            }
            //刷新
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
