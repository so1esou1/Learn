package com.bjpowercode.javase.test003;

public class FinalTest01 {

	public static void main(String[] args) {
		int i = 10;
		System.out.println(i);
		i = 20;
		System.out.println(i);
		
		/*final int k = 100;
		k = 200;��������޷�Ϊ���ձ���k����ֵ*/
		
		final int m;
		m = 200;
		//m = 300;�޷�Ϊm����ֵ��final��ֵ�󲻿��ٴθ�ֵ
	}

}
	
