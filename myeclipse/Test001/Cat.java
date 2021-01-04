package com.bjpowercode.javase.test001;
//猫类

public class Cat extends Animal{
	//重写父类中继承过来的方法
		public void move(){
			System.out.println("猫在走猫步");
		}
		//这个方法是子类特有的，不是从父类中继承的
		public void catchMouse(){
			System.out.println("猫抓老鼠");
		}
}

