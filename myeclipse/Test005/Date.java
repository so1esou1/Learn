package com.bjpowercode.javase.Test005;
//�Զ������������
public class Date {
	private int year;
	private int month;
	private int day;
	//���캯��
	
	//setter and getter
	public int getYear() {
		return year;
	}
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//���󣺵���Ա���������޲����Ĺ��췽����ʱ��Ĭ�ϵĴ���������1970-1-1
	public Date() {
		/*
		this.year = 1970;
		this.month = 1;
		this.day = 1;
		
	���ϴ����ظ����������󣬿���ͨ��������һ�����췽������ɣ���ǰ���ǲ��ܴ����µĶ������´����ʾ������һ��ȫ�µĶ���*/
		//new Date(1970,1,1);
		this(1970,1,1);//���ַ�ʽ���ᴴ���µ�java����ͬʱ���Դﵽ�����������췽��
	}	
	public void setYear(int year) {
		
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	//�����ṩһ�����������Խ����ڴ�ӡ���������̨
	public void print(){
		System.out.println(this.year + "��" + this.month + "��" + this.day + "��");
	}
}
