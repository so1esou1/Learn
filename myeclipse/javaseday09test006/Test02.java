package com.bjpowercode.javaseday09test006;

public class Test02 {

	public static void main(String[] args) {
		User u = new User(20);//��Test01�е�i��ȣ������u���������һ��java�����ڶ��ڴ��е��ڴ��ַ��ռ�ÿռ�ľֲ�����
		add(u);//���u������Ĳ���һ���������Ǿֲ���������ָ��User����
		System.out.println("main-->" + u.age);//21����Test01��ͬ���ǣ�����u������ǵ�ַ������u�����21��ת�������У�u��ָ��ͬһ��ַ��Ҳ��21
	}
	public static void add(User u){
		u.age++;
		System.out.println("add-->" + u.age);//21
	}


}
class User{
	//ʵ������
	int age;
	
	//���췽��
	public User(int i){
		age = i;
	}
}
