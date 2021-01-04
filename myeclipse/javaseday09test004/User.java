package com.bjpowercode.javaseday09test004;

public class User {
	//属性私有化
	private int age;
	/*public void setAge(int age){
		age = age;//java有就近原则，这里其实并没有给age属性赋值，这里的age就是局部变量age
	}*/
	//setter
	public void setAge(int a){
		//age = a;
			if(a < 0 || a > 150){
				System.out.println("对不起，您提供的年龄不合法");
				return;
			}
			//程序可以执行到这，说明a合法，可以进行赋值运算
			age = a;
	}
	//getter
	public int getAge(){
		return age;
	}
}
