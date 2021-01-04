package com.bjpowernode.javase.array;
/*
main方法上面的"String[] args"有什么用？
    分析以下：谁负责调用main方法：JVM
    JVM调用main方法的时候，会自动传一个String数组过来
 */
public class ArrayTest05 {
    //这个方法程序员负责写出来，JVM负责调用，JVM调用的时候一定会传一个String数组过来
    public static void main(String[] args) {
        //JVM默认传递过来的这个数组对象的长度？   默认是0
        //通过测试得出：args不是null了，不是引用（数组里面没东西，但是对象是有的）
        System.out.println("JVM给传递过来的String数组参数，它这个数组的长度是" + args.length);

        /*创建一个长度为0的String数组传进去,数组对象创建了，但数组中没有任何数据
        String[] strs = new String[0];*/

        //String[] strs = {};  //静态初始化数组，里面没东西
        //printLength(strs);

        //数组里面什么时候会有值呢？
        //其实这个数是留给用户的，用户可以在控制台上输入参数，这个参数自动会被转换为String数组
        //例如这样运行程序：java ArrayTest05 abc def xyz
        //那么这时候JVM会自动将abc def xyz通过空格的方式进行分离，分离完成之后自动放到"String[] args"数组当中。
        //所以main方法中的String[] args数组主要是用来接收用户输入参数的
        //把abc def xyz转换成字符串数组：{"abc","def","xyz"}
        //遍历数组
        for (int i = 0;i < args.length;i++){
            System.out.println(args[i]);
        }
    }

    public static void printLength(String[] args){
        System.out.println(args.length);  //0
    }
}
