package com.bjpowercode.javase.Test008;
	//�й�����
public class Chinese {
	String id;//���֤�Ų�ͬ��ʵ������
	String name;//������ͬ��ʵ������
	String country;//����������ͬ�ģ�ʵ��������100��������100��country
	/*����������Ʒ�ʽȱ�㣺ʵ�������洢java�����ڲ����ڶ��ڴ��У��ڹ��췽��ִ�е�ʱ���ʼ��
	 �����˹��������й���������ʵ��������Ȼ�ǲ����ʵģ�̫�˷��ڴ�ռ䣬û��Ҫ��ÿһ���󶼱���һ�ݡ��������ڴ棬
	 �ĳ�static String country;��̬������������ص�ʱ���ʼ��������Ҫ���������ڴ�Ϳ����ˡ�
	 */
	
	public Chinese(){
		//���������Ĺ��캯��
	}
	public Chinese(String id,String name,String country){
		this.id = id;
		this.name = name;
		this.country = country;
	}//�������Ĺ��캯��
}
