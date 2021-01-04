package chapter23.src.com.bjpowernode.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
java.io.FileInputStream
    1、文件字节输入流，万能的，任何类型的文件都可以采用这个流进行读
    2、字节的方式，完成输入/读的操作（硬盘--->内存）
    3、
 */
public class FileInputStream01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //创建文件字节输入流对象
            //以下都是采用的绝对路径
            //文件路径：F:\JAVA学习\temp（IDEA会自动把\编成\\，因为Java、中“\”表示转义）
            //FileInputStream fis = new FileInputStream("F:\\JAVA学习\\temp");可以把\\改成单/
            fis = new FileInputStream("F:/JAVA学习/temp.txt");

            //开始读
            int readData = fis.read();   //这个方法的返回值是读取到的“字节”本身，原文件中第一个字母是a，a是97
            System.out.println(readData);  //97

            //再读一个
            readData = fis.read();
            System.out.println(readData);//98

            //再读4次读完
            readData = fis.read();
            System.out.println(readData);
            readData = fis.read();
            System.out.println(readData);
            readData = fis.read();
            System.out.println(readData);
            readData = fis.read();
            System.out.println(readData);//102
            //再向下调read，指针往下走一位，没有内容，返回-1
            readData = fis.read();
            System.out.println(readData);//-1，读不到数据都返回-1

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //在finally语句块中确保流一定关闭
            if (fis != null){   //避免空指针异常
                //关闭流的前提是：流不是空，流是null的时候没必要关闭
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
