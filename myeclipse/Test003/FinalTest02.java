package com.bjpowercode.javase.test003;

public class FinalTest02 {
	//��Ա����֮ʵ������
	//final int age;ʵ������һ��ʼ�ᱻϵͳ��Ĭ��ֵ�������ֶ���ֵ,�涨ʵ������ʹ��final���κ�����ֶ���ֵ���ܲ���ϵͳĬ��ֵ������Ĭ��ֵ���Ժ�͸Ĳ�����
	final int age = 10;
	//��
	final int num;
	public FinalTest02(){
		this.num = 200;//ֻҪ����ϵͳ��Ĭ��ֵ֮ǰ��ֵ����
	}
	
	public static void main(String[] args) {
		final int a;
		a = 100;
	}

}
