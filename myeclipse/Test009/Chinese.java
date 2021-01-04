package com.bjpowercode.javase.Test009;
	//中国人类
public class Chinese {
	String id;//身份证号不同，实例变量
	String name;//姓名不同，实例变量
	static String country = "中国";//国籍都是相同的，实例变量，100个对象有100个country

	public Chinese(){
		//不带参数的构造函数
	}
	public Chinese(String id,String name){
		this.id = id;
		this.name = name;

	}//带参数的构造函数
}
