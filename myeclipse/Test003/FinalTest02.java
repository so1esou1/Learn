package com.bjpowercode.javase.test003;

public class FinalTest02 {
	//成员变量之实例变量
	//final int age;实例变量一开始会被系统赋默认值，必须手动赋值,规定实例变量使用final修饰后必须手动赋值不能采用系统默认值，采用默认值了以后就改不了了
	final int age = 10;
	//或
	final int num;
	public FinalTest02(){
		this.num = 200;//只要赶在系统赋默认值之前赋值就行
	}
	
	public static void main(String[] args) {
		final int a;
		a = 100;
	}

}
