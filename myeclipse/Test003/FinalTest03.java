package com.bjpowercode.javase.test003;

public class FinalTest03 {


	public static void main(String[] args) {
		//�����û�����
		User u = new User(100);//User u = 0x1234;
		//�ִ�����һ���µ�User����
		//����ִ�е��˴���ʾ���϶����ѱ������Ͱ���ȴ������������Ļ���
		u = new User(200);//u = 0x2586;
		//�����û�����
		final User user = new User(30);
		//user = new User(50);final���ε����ã�һ��ָ��ĳ������󣬲�����ָ������������ô��ָ��Ķ����޷�����������������
		
		
	}

}
