package com.bjpowercode.javase.test001;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//父类型引用指向子类型对象
		Animal a1 = new Cat();
		Animal a2 = new Bird();
		
		//向下转型
		if(a1 instanceof Cat){
			Cat c1 = (Cat)a1;	
		}
		if(a2 instanceof Bird){
			Bird b1 = (Bird)a2;
		}
		
	}

}
