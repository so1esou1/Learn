package com.bjpowernode.java.reflect;
/*
可变长度参数（掌握）
    语法是：类型...   （注意：一定是三个点）
    1、可变长度参数要求的长度个数是：0-n个
    2、可变长度参数在参数列表中必须在最后一个位置，而且只能有一个
    3、可变长度参数可以当作一个数组来看待
 */
public class ArgsTest {
    public static void main(String[] args) {
        m();
        m(10);
        m(10,20);
        //m("abc");  不能违反数据类型，编译报错
        //里面的参数随便写
        m3("ab","de","kk","ff");
        //也可以传一个数组进去
        String[] strs ={"a","b","c"};
        m3(strs);

        //直接传一个数组
        m3(new String[]{"我","是","中","国","人"});
    }

    public static void m(int... args){
        //int... args就是可变长度参数
        System.out.println("m方法执行了！");
    }
    //public static void m2(String... args1,int...args2){}  可变长度参数在参数列表中必须在最后一个位置，而且只能有一个

    public static void m2(int a,String...args1){

    }
    public static void m3(String...args){
        //args有length属性，说明是一个数组！
        for (int i = 0;i < args.length;i ++){
            System.out.println(i);
        }
    }
}
