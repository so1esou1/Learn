package com.bjpowercode.javase.Test011;
	//ʵ������/�����
public class Test {
	//���캯��
	public Test(){
		System.out.println("Test���ȱʡ������ִ��");
	}
	{
		System.out.println(1);
	}
	{
		System.out.println(2);
	}
	{
		System.out.println(3);
	}
	//������
	public static void main(String[] args) {
		System.out.println("main begin");
		new Test();

	}

}
