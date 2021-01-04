package com.bjpowernode.javase.exception;
/*
关于finally的面试题

 */
public class ExceptionTest13 {
    public static void main(String[] args) {
        int result = m();
        System.out.println(result);  //请问这个结果是多少？  100！
    }
    /*
    java语法规则有一些规则是无法破坏的，一旦这么说了就必须这么做
        java中有这么一条规则：
            方法体中的代码必须遵守自上而下的顺序依次执行（亘古不变的语法）
        还有一条语法规则：
            return语句一旦执行，整个方法必须结束（亘古不变的语法）
        这两个语法都不能违背！！！！

     */
    public static int m(){
        int i = 100;
        try{
            //这行代码出现在int i = 100;的下面，所以最终结果必须是返回100
            //return语句必须保证是最后执行的，一旦执行整个方法结束
            return i;
        }finally {
            i ++;
        }
    }
}

/*
这个代码反编译之后的效果：
public static int m(){
    int i = 100;
    int j = i;
    i ++;
    return j;

}
 */
