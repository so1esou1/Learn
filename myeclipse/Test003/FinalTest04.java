package com.bjpowercode.javase.test003;

public class FinalTest04 {

	public static void main(String[] args) {
		System.out.println(Chinese.GUO_JI);
	}

}
//中国人类
class Chinese{
	//国籍，都是中国，而且不会变，为防止国籍被修改，建议加final修饰
	//final修饰的实例变量是不可变的，这种变量一般和static联合使用，被称为“常量”
	//常量的定义语法格式：
		//public static final 类型 常量名 = 值;
		//java规范要求所有常量必须大写，每个单词间用下划线连接
	//final String country = "中国";
	public static String GUO_JI = "中国";
}