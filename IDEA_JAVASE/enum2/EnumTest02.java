package com.bjpowernode.javase.enum2;
/*
与01一样的案例，采用枚举的方式改造程序
总结：1、枚举是一种引用数据类型
     2、枚举类型怎么定义，语法？
        enum 枚举类型名{
            枚举值1，枚举值2
        }
     3、结果只有两种情况的，建议使用布尔类型。结果超过两种且可以一枚一枚列举出来的，建议使用枚举类型
        例如颜色、四季、星期等都可以使用枚举类型。

 */
public class EnumTest02 {
    public static void main(String[] args) {
        Result r = divide(10,0);
        System.out.println(r == Result.SUCCESS ? "计算成功" : "计算失败");//计算失败
    }

    /**
     * 计算两个int类型数据的商
     * @param a int数据
     * @param b int数据
     * @return Result.SUCCESS表示成功，Result.FAIL表示失败
     */
    public static Result divide(int a,int b){
        try{
            int c = a / b;
            return Result.SUCCESS;
        }catch (Exception e){
            return Result.FAIL;
        }
    }
}
//枚举：一枚一枚可以列举出来的才建议使用枚举类型。
//枚举编译之后也是生成class文件，也是一种引用数据类型
//枚举中每一个值可以看作是常量
enum Result{
    //SUCCESS是枚举中Result中的一个值
    //FAIL是枚举中Result中的一个值
    //枚举中的每一个值可以看做是一个常量
    SUCCESS,FAIL
}