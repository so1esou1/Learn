package com.bjpowercode.javase.Test001;

public class CustomerTest {

	public static void main(String[] args) {
		//����һ��Customer����
		Customer c1 = new Customer();
		c1.name = "zhangsan";
		c1.shopping();
		//�ٴ���һ��Customer����
		Customer c2 = new Customer();
		c2.name = "lisi";
		c2.shopping();
	}

}
