package com.csu.javase.Interface;

/*
7、类和类叫做继承(extends)，类和接口之间叫做实现(implements)。仍然可以把实现看作是一种特殊的继承

8、实现接口，要么是抽象类，要么重写/实现接口中的方法
*****当一个非抽象的类实现接口方法的话必须把接口中所有的方法都重写


 */
public class InterfaceTest02 {
    public static void main(String[] args) {
        //多态和接口联合使用
        //接口无法创建对象
        //写法:
        MyMath1 mm = new MyMathImpl();   //父类型的引用指向子类型的对象（编译看左边，运行看右边）
        //调用接口里面的方法(面向接口编程)
        System.out.println(mm.sub(1,1));
    }
}

interface MyMath1{
    double PI = 3.14115926;
    int sum(int a,int b);
    int sub(int a,int b);
}
/*这样可以，抽象类可以去实现接口
abstract class MyMathImpl implements MyMath1{

}
*/

class MyMathImpl implements MyMath1{
    //子类实现父类方法的话修饰符权限不能更高，只能更低，如果把public去掉的话，变成了缺省，所以不能删除public
    public int sum(int a,int b){
        return a + b;
    }
    public int sub(int a,int b){
        return a - b;
    }
}