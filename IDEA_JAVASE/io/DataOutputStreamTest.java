package com.bjpowernode.java.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
java.io.DataOutputStream：数据专属的流。
这个流可以将数据连同数据的类型一并写入文件
注意：这个文件不是普通文本文档(用记事本打不开)
 */
public class DataOutputStreamTest {
    public static void main(String[] args) throws Exception{
        //创建数据专属的字节输出流
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data"));
        //写数据
        byte b = 100;
        short s = 200;
        int i = 300;
        long l = 400L;
        float f = 3.0F;
        double d = 3.14;
        boolean sex = false;
        char c = 'a';
        //写
        dos.writeByte(b);  //把数据和数据的类型一并写入到文件当中
        dos.writeShort(s);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeBoolean(sex);
        dos.writeChar(c);
        //这个文件不能用记事本打开，只能用DataInputStream方法才能将这里面的数据取出来

        //刷新
        dos.flush();
        //关闭最外层
        dos.close();
    }
}
