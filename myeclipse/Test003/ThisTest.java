package com.bjpowercode.javase.Test003;

public class ThisTest {
	//����static��������
	public static void main(String[] args) {
		//����dosome����
		ThisTest.dosome();
		//����dosome����
		dosome();
		
		//����doOther����
		//ThisTest.dosome();ʵ�����������ȴ�������ͨ������.�ķ�ʽ���ʣ��������
		//doOther();�����ʾ���壺���õ�ǰ�����doOther��������������main������û��this���������·������ܵ���
		ThisTest tt = new ThisTest();
		tt.doOther();
	}
	//����static
	public static void dosome(){
		System.out.println("do some!");
	}
	//ʵ������
	public void doOther(){
		//this��ʾ��ǰ����
		System.out.println("do other!");
	}
	public void run(){
		//�ڴ������еĴ���ִ�й�����һ���Ǵ��ڡ���ǰ���󡱵ģ�Ҳ����˵����һ���С�this����
		System.out.println("run execute!");
		//doOther��һ��ʵ��������ʵ���������ñ����ж���Ĵ���
		//���´����ʾ�ĺ����ǣ����õ�ǰ�����doOther����
		this.doOther();
	}
}
