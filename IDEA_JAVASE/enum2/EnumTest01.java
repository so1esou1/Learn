package com.bjpowernode.javase.enum2;//enum是关键字，不能直接做包名
/*
分析以下程序在涉及方面有什么缺陷？(这个案例还没有使用枚举)
以下代码可以编译、运行
    涉及缺陷：返回值类型上，返回int不恰当，既然最后的结果只是成功和失败，最好使用布尔类型，正好表示两种不同的状态
    返回10虽然已经偏离了要求，但编译器没有检查出来
    我们一直想追求的是：所有错误尽可能让编译器找出来，所有错误越早发现越好！
 */
public class EnumTest01 {
    public static void main(String[] args) {
        //System.out.println(10/0);   java.lang.ArithmeticException: / by zero
        int retValue = divide(10,2);
        System.out.println(retValue);  //1

        int retValue2 = divide(10,0);
        System.out.println(retValue2);  //0
    }

    /**
     * 以下程序计算两个int类型数据的商，计算成功返回1，计算失败返回0
     * @param a int类型的数据
     * @param b int类型的数据
     * @return 返回1表示成功，返回0表示失败！
     */
    public static int divide(int a,int b){
        try{
            int c = a / b ;
            //程序执行到这表示以上代码没有发生异常，执行成功，返回1
            return 1;
        }catch(Exception e){
            //程序执行到此处表示以上程序出现了异常，执行失败
            return 0;
        }

    }
}

