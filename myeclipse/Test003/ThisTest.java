package com.bjpowercode.javase.Test003;

public class ThisTest {
	//带有static，主方法
	public static void main(String[] args) {
		//调用dosome方法
		ThisTest.dosome();
		//调用dosome方法
		dosome();
		
		//调用doOther对象
		//ThisTest.dosome();实例方法必须先创建对象，通过引用.的方式访问，编译错误
		//doOther();代码表示含义：调用当前对象的doOther方法，但是由于main方法中没有this，所以以下方法不能调用
		ThisTest tt = new ThisTest();
		tt.doOther();
	}
	//带有static
	public static void dosome(){
		System.out.println("do some!");
	}
	//实例方法
	public void doOther(){
		//this表示当前对象
		System.out.println("do other!");
	}
	public void run(){
		//在大括号中的代码执行过程中一定是存在“当前对象”的，也就是说这里一定有“this”的
		System.out.println("run execute!");
		//doOther是一个实例方法，实例方法调用必须有对象的存在
		//以下代码表示的含义是：调用当前对象的doOther方法
		this.doOther();
	}
}
