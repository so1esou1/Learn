package com.bjpowernode.javase.enum2;
/*
switch语句支持枚举类型
也支持String、int
低版本的JDK只支持int
byte、short、char也可以，因为存在自动类型转换
 */
public class SwitchTest {
    public static void main(String[] args) {
        switch (Season.AUTUMN){
            //必须省略Season.
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
            case WINTER:
                System.out.println("冬天");
        }
    }
}
