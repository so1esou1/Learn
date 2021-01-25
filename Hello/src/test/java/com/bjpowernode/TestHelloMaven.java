package com.bjpowernode;
import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven
{
	@Test
	public void testAdd(){
		System.out.println("=====MavenHelloWorld=====");
		HelloMaven hello = new HelloMaven();
		int res = hello.add(10,20);

		Assert.assertEquals(30,res);

	}


	@Test
	public void testAdd2(){
		System.out.println("------MavenHelloWorld2-----");
		HelloMaven hello = new HelloMaven();
		int res = hello.add(30,20);

		Assert.assertEquals(50,res);

	}
}