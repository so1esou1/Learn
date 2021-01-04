package com.bjpowercode.javase.Test001;

public class CustomerTest {

	public static void main(String[] args) {
		//创建一个Customer对象
		Customer c1 = new Customer();
		c1.name = "zhangsan";
		c1.shopping();
		//再创建一个Customer对象
		Customer c2 = new Customer();
		c2.name = "lisi";
		c2.shopping();
	}

}
