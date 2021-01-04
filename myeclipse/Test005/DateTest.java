package com.bjpowercode.javase.Test005;

public class DateTest {

	public static void main(String[] args) {
		//创建日期对象1
		Date time1 = new Date();//默认调用无参数构造方法
		time1.print();
		//创建对象2
		Date time2 = new Date(2008,8,8);//指定2008.8.8
		time2.print();

	}

}
