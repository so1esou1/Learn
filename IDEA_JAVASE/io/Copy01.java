package com.bjpowernode.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
使用FileInputStream + FileOutputStream完成文件的拷贝
拷贝过程应该是一边读一边写
使用以上的字节流拷贝文件的时候文件类型随意，万能的，什么样的文件都能拷贝
 */
public class Copy01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建一个输入流对象
            fis = new FileInputStream("D:\\DNF计算器8.25.zip");
            //创建一个输出流对象
            fos = new FileOutputStream("E:\\DNF计算器8.25.zip");

            //最核心的：一边读一边写
            byte[] bytes = new byte[1024 * 1024];  //1MB(一次最多拷贝1MB)
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1){
                fos.write(bytes,0,readCount);
            }

            //注意：刷新，输出流最后要刷新

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos == null) {
                try {
                    fos.close();  //两个close需要分开try catch,一起try的时候其中一个出现异常可能影响另一个流的关闭。
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
