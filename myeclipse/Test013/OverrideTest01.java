package com.bjpowercode.javase.Test013;

public class OverrideTest01 {

	public static void main(String[] args) {
		//�����������
		Animal a = new Animal();
		a.move();
		//����è���ද�����
		Cat c = new Cat();
		c.move();
		//���������ද�����
		Bird b = new Bird();
		b.move();
		
		YingWu y = new YingWu();
		y.move();
	}

}
