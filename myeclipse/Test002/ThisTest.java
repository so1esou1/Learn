package com.bjpowercode.javase.Test002;

public class ThisTest {
	//实例变量（引用.的方式访问）
	int num = 10;
	//带有static的方法
	//jvm负责调用main方法，jvm是怎么调用的？
	//ThisTest.main(String[]);
	public static void main(String[] args){
		//没有当前对象this
		//System.out.println(num);访问当前对象的num属性，编译错误
		//System.out.printlm(this.num);编译错误
		//相访问num怎么办？
		ThisTest tt = new ThisTest();
		System.out.println(tt.num);
	}
}
