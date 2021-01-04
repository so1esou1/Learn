package com.bjpowercode.javaseday09test006;

public class Test01 {


	public static void main(String[] args) {
		int i = 10;
		add(i);//i变量是局部变量，本身也占有内存空间，所以变量本身也有内存地址，i变量保存的是10这个字面值。所以传过去的是10这个值复制了一份，后面i的变化不影响前面的i；int i =10;add(i);等同于add(10);
		System.out.println("main -->" + i);//10
	}	
		public static void add(int i){
			i++;
			System.out.println("add -->" + i);//11
			
		}
	

}
