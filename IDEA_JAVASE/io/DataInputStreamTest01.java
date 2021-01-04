package com.bjpowernode.java.io;

import java.io.DataInputStream;
import java.io.FileInputStream;

/*
DataInputStream：数据字节输入流
DataOutputStream写的数据只能用DataInputStream去读，并且读的时候需要提前知道写入的顺序
读的顺序必须跟写的数据一致，才能正常取出数据

 */
public class DataInputStreamTest01 {
    public static void main(String[] args) throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream("data"));
        //开始读
        byte b = dis.readByte();
        short s = dis.readShort();
        int i = dis.readInt();
        long l = dis.readLong();
        float f = dis.readFloat();
        double d = dis.readDouble();
        boolean sex = dis.readBoolean();
        char c = dis.readChar();

        System.out.println(b);
        System.out.println(s);
        System.out.println(i + 1000);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(sex);
        System.out.println(c);

        dis.close();
    }
}
