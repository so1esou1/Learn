package com.bjpowercode.javaseday09test003;

public class UserTest {
	public static void main(String[] args){
		//����User����
		User user = new User();
		//����age
		//��ȡ����ֵ
		System.out.println("���û����䣺" + user.age);
		//�޸�����ֵ
		user.age = 20;/*�����age������Ȼ����ȫ��¶���ⲿ���ԣ����ڳ���Ա��˵�����Բ���User������ϸ�ڣ�
		����User�в������ݲ���ȫ������User�ڴ���з�װ���������ⲿ�����в��������������*/
		System.out.println("���û����䣺" + user.age);
	}

}
