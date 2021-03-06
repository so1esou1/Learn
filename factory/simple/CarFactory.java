package com.csu.factory.simple;
/*
    简单工厂模式/静态工厂模式，里面的方法都是静态的
    如果不修改代码的情况下不能实现增加修改，有违于OCP原则
 */
public class CarFactory {
    //方法一:
    public static Car getCar(String car){
        if (car.equals("五菱")){
            return new WuLing();
        }else if (car.equals("特斯拉")){
            return new Tesla();
        }else {
            return null;
        }
    }
    //方法二:
    public static Car getWuling(){
        return new WuLing();
    }
    public static Car getTesla(){
        return new Tesla();
    }
}
