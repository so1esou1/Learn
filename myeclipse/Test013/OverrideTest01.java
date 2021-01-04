package com.bjpowercode.javase.Test013;

public class OverrideTest01 {

	public static void main(String[] args) {
		//创建动物对象
		Animal a = new Animal();
		a.move();
		//创建猫科类动物对象
		Cat c = new Cat();
		c.move();
		//创建飞禽类动物对象
		Bird b = new Bird();
		b.move();
		
		YingWu y = new YingWu();
		y.move();
	}

}
