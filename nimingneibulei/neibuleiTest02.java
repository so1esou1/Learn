package com.csu.javase.nimingneibulei;
/*使用匿名内部类实现test01中的程序，会大幅简化程序：
  不用再将接口的实现类写出来
 */
public class neibuleiTest02 {
    public static void main(String[] args) {
        //调用MyMath中的mysum方法
        MyMath1 mm = new MyMath1();
        mm.Mysum1(new Compute1(){            //大括号里面相当于对接口的实现，这个类没有命名
            public int sum1(int a,int b){
                return a + b;
            }
        },100,100);

    }
}



interface Compute1{
    int sum1(int a,int b);
}
class MyMath1{
    public void Mysum1(Compute1 c,int x,int y){
        int retValue = c.sum1(x,y);
        System.out.println(x + "+" + y + "=" + retValue);
    }
}
