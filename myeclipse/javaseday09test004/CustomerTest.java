package com.bjpowercode.javaseday09test004;

public class CustomerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		c.setId(100);
		c.setName("����");
		c.setAge(50);
		c.setAddr("����������");
		
		System.out.println(c.getId());
		System.out.println(c.getName());
		System.out.println(c.getAge());
		System.out.println(c.getAddr());
	}

}
