package com.bjpowernode.javase.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
关于try...catch中的finally子句：
    1、在finally子句中的代码是最好执行的，并且一定会执行，即使try语句块中的代码出现了异常
        finally子句必须和try一起出现，不能单独编写
    2、finally语句通常使用在哪些情况呢？
        通常在finally语句块中完成资源的释放/关闭
        因为finally中的代码比较有保障
        即使try语句块中的代码出现异常，finally中的代码也会正常执行
 */
public class ExceptionTest10 {
    public static void main(String[] args) {
        FileInputStream fis = null;//声明位置放在try外面，这样在finally中才可以用
        try {
            //创建输入流对象
            fis = new FileInputStream("E:\\yy\\8.52.0.0");

            //开始读文件...
            String s = null;
            //这里一定会出现空指针异常！
            s.toString();

            //流使用完关闭，因为流是占用资源的
            //即使以上程序出现异常，流也必须要关闭！
            //放在这里有可能流关不了
            //fis.close();
            System.out.println("hello world");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }finally{
            System.out.println("hello 浩克！");
            //流的关闭放在这里比较保险
            //finally中的代码是一定要执行的
            //即使try中出现了遗产
            if (fis != null){  //避免空指针异常！
                try {
                    //close()方法有异常，采用捕捉的方式
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("hello kitty");
    }
}
