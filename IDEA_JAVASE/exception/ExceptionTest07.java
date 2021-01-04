package com.bjpowernode.javase.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
深入try..catch
  1、catch后面的小括号可以写准确类型，也可以写父类型
  2、catch可以写多个，建议catch的时候精确地一个个处理，这样有利于程序的调试
  3、catch写多个的时候，从上到下必须遵守从小到大。

在以后的开发过程中，是上报还是捕捉呢？怎么选？
    如果希望调用者处理/知道，选择上报；其余情况都选择捕捉。
 */
public class ExceptionTest07 {
    public static void main(String[] args) {
        /*try{
            FileInputStream fis = new FileInputStream("E:\\qqmusic\\html");
            System.out.println("这里代码就不能执行了");
        }catch (FileNotFoundException e){
            System.out.println("文件不存在！");

        }
        System.out.println("hello world!");
        */

        /*try{
            FileInputStream fis = new FileInputStream("E:\\qqmusic\\html");
            System.out.println("这里代码就不能执行了");
        }catch (IOException e){   ///这样也不会报错，因为多态：IOException e = new FileNotFoundException()
            System.out.println("文件不存在！");
         */

        /*try{
            //创建输入流
            FileInputStream fis = new FileInputStream("E:\\qqmusic\\html");
            //读文件
            fis.read();
        }catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
        } catch (IOException e){
            System.out.println("读文件报错了");
        }

         */
        /*try{
            //创建输入流
            FileInputStream fis = new FileInputStream("E:\\qqmusic\\html");
            //读文件
            fis.read();
        }catch (IOException e) {
            System.out.println("文件不存在！");
        } catch (FileNotFoundException e){
            System.out.println("读文件报错了");//编译报错，上面已经捕捉过了，不允许再捕捉
        }
         */

        //JDK8的新特性：
        try{
            //创建输入流
            FileInputStream fis = new FileInputStream("E:\\qqmusic\\html");
            //进行数学运算
            System.out.println(100/0);//这个异常是运行时异常，编写程序时可以处理，也可以不处理
        } catch (FileNotFoundException | ArithmeticException | NullPointerException e){
            //可以采用或者的编写方式
            System.out.println("文件不存在？数学异常？空指针异常？都有可能！");
        }
    }
}
