package com.bjpowercode.javaseday09test004;

public class User {
	//����˽�л�
	private int age;
	/*public void setAge(int age){
		age = age;//java�оͽ�ԭ��������ʵ��û�и�age���Ը�ֵ�������age���Ǿֲ�����age
	}*/
	//setter
	public void setAge(int a){
		//age = a;
			if(a < 0 || a > 150){
				System.out.println("�Բ������ṩ�����䲻�Ϸ�");
				return;
			}
			//�������ִ�е��⣬˵��a�Ϸ������Խ��и�ֵ����
			age = a;
	}
	//getter
	public int getAge(){
		return age;
	}
}
