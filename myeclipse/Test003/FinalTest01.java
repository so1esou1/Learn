package com.bjpowercode.javase.test003;

public class FinalTest01 {

	public static void main(String[] args) {
		int i = 10;
		System.out.println(i);
		i = 20;
		System.out.println(i);
		
		/*final int k = 100;
		k = 200;编译错误，无法为最终变量k分配值*/
		
		final int m;
		m = 200;
		//m = 300;无法为m分配值，final赋值后不可再次赋值
	}

}
	
