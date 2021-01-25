package com.bjpowernode;
public class HelloMaven
{
	public int add(int n1,int n2){
		return n1 + n2;
	}
	public static void mian(String args[]){
		HelloMaven hello = new HelloMaven();
		int res = hello.add(10,20);
		System.out.println("10 + 20 = " + res);
	}
}
