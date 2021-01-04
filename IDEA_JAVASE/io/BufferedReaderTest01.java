package com.bjpowernode.java.io;

import java.io.BufferedReader;
import java.io.FileReader;

/*
BufferedReader:
    带有缓存区的字符输入流
    不需要使用这些流的时候不需要自定义char数组，或者说不需要自定义byte数组，自带缓冲
 */
public class BufferedReaderTest01 {
    public static void main(String[] args) throws Exception{
        FileReader reader = new FileReader("Copy02.java");
        //当一个流的构造方法中需要一个流的时候，这个被传进来的流叫做节点流
        //外部负责包装这个流，叫做“包装流”，或称“处理流”
        //像当前这个程序来说，FileReader就是一个节点流，而BufferedReader就是一个包装流/处理流
        BufferedReader br = new BufferedReader(reader);

        //读一行
        String firstLine = br.readLine();
        System.out.println(firstLine);  //package com.bjpowernode.java.io;这个结果是因为Copy02.java文件第一行就是这个

        String secondLine = br.readLine();
        System.out.println(secondLine);//第二行什么也没有

        String Line3 = br.readLine();
        System.out.println(Line3);//多输出了import java.io.FileNotFoundException;

        //br.readLine()方法读取一个文本行，但不带换行符
        String s = null;
        while ((s = br.readLine()) != null){
            System.out.println(s);  //这个方法更快更方便，直接读完。写print的话就全部不换行
        }

        //关闭流
        //对于包装流来说，只需要关闭最外层流就行，里面的节点流会自动关闭（可以看源代码）
        br.close();
    }
}
