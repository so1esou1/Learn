package com.bjpowernode.javase.number;

import java.math.BigDecimal;

/*
BigDecimal属于大数据，精度极高，不属于基本数据类型，属于java对象，引用数据类型
是SUN提供的一个类，专门用在财务软件上的，财务软件中Double不够的
问你怎么处理财务数据，一定得说BigDecimal而不是Double
 */
public class BigDecimalTest01 {
    public static void main(String[] args) {
        BigDecimal v1 = new BigDecimal(100);//这个100不是普通的100，是精度极高的100
        BigDecimal v2 = new BigDecimal(200);
        //求和
        //v1+v2不行，v1、v2都是引用，不能直接使用+号求和
        BigDecimal v3 = v1.add(v2);
        System.out.println(v3);//这是调用方法求和

        BigDecimal v4 = v1.divide(v2);
        System.out.println(v4);
    }
}
