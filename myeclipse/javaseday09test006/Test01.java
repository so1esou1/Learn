package com.bjpowercode.javaseday09test006;

public class Test01 {


	public static void main(String[] args) {
		int i = 10;
		add(i);//i�����Ǿֲ�����������Ҳռ���ڴ�ռ䣬���Ա�������Ҳ���ڴ��ַ��i�����������10�������ֵ�����Դ���ȥ����10���ֵ������һ�ݣ�����i�ı仯��Ӱ��ǰ���i��int i =10;add(i);��ͬ��add(10);
		System.out.println("main -->" + i);//10
	}	
		public static void add(int i){
			i++;
			System.out.println("add -->" + i);//11
			
		}
	

}
