package com.bjpowercode.javase.Test005;
//自定义的日期类型
public class Date {
	private int year;
	private int month;
	private int day;
	//构造函数
	
	//setter and getter
	public int getYear() {
		return year;
	}
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//需求：当成员调用以下无参数的构造方法的时候，默认的创建日期是1970-1-1
	public Date() {
		/*
		this.year = 1970;
		this.month = 1;
		this.day = 1;
		
	以上代码重复，工作量大，可以通过调用另一个构造方法来完成，但前提是不能创建新的对象，如下代码表示创建了一个全新的对象*/
		//new Date(1970,1,1);
		this(1970,1,1);//这种方式不会创建新的java对象，同时可以达到调用其他构造方法
	}	
	public void setYear(int year) {
		
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	//对外提供一个方法，可以将日期打印输出到控制台
	public void print(){
		System.out.println(this.year + "年" + this.month + "月" + this.day + "日");
	}
}
