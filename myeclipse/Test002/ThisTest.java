package com.bjpowercode.javase.Test002;

public class ThisTest {
	//ʵ������������.�ķ�ʽ���ʣ�
	int num = 10;
	//����static�ķ���
	//jvm�������main������jvm����ô���õģ�
	//ThisTest.main(String[]);
	public static void main(String[] args){
		//û�е�ǰ����this
		//System.out.println(num);���ʵ�ǰ�����num���ԣ��������
		//System.out.printlm(this.num);�������
		//�����num��ô�죿
		ThisTest tt = new ThisTest();
		System.out.println(tt.num);
	}
}
