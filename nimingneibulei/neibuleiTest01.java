package com.csu.javase.nimingneibulei;

/*
匿名内部类(类没有名字)：
  1、内部类：在类的内部又定义一个新的类

  2、内部类的分类：
    *静态内部类：类似于静态变量
    *实例内部类：类似于实例变量
    *局部内部类：类似于局部变量，匿名内部类在此分类

  3、使用内部类编写的代码可读性较差

  4、匿名内部类是局部内部类的一种，因为没有名字而得名

  5、不建议使用匿名内部类，因为没有名字没办法重复使用，另外代码可读性太差
 */
public class neibuleiTest01 {

}
class Test01{
    static class Inner1{          //静态内部类

    }
    class Inner2{                 //实例内部类

    }
    public void doSome(){
        int i = 1;   //局部变量
        class Inner3{             //局部内部类
        }
    }
    public void doOther(){
        new Test01().new Inner2();     //因为是实例内部类，所以要先new对象才能new这个类出来，就像实例变量一样
    }

    public static void main(String[] args) {
        //调用MyMath中的mysum方法
        MyMath mm = new MyMath();
        mm.Mysum(new ComputeImpl(),100,100);   //这里也是用来多态，因为编译时用的Compute接口方法(调用的是Mysum,Mysum与compute绑定)，运行时用的是ComputeImpl的方法
        //类似于将compute c = new ComputeImpl();缩写了
    }
}




//负责计算的接口
interface Compute{
    //抽象方法
    int sum(int a,int b);
}
//数学类   注意：这个类不是在实现接口，而是在调用接口中的方法。不要把接口特殊化，接口也是一种引用数据类型
class MyMath{
    public void Mysum(Compute c,int x,int y){
        int retValue = c.sum(x,y);
        System.out.println(x + "+" + y + "=" + retValue);
    }
}
//你自动会在这里编写一个Compute接口的实现类
class ComputeImpl implements Compute{
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
