package com.bjpowercode.javase.Test008;
	//中国人类
public class Chinese {
	String id;//身份证号不同，实例变量
	String name;//姓名不同，实例变量
	String country;//国籍都是相同的，实例变量，100个对象有100个country
	/*分析这种设计方式缺点：实例变量存储java对象内部，在堆内存中，在构造方法执行的时候初始化
	 所有人国籍都是中国，声明成实例变量显然是不合适的，太浪费内存空间，没必要让每一对象都保留一份”国籍“内存，
	 改成static String country;静态变量，在类加载的时候初始化，不需要创建对象，内存就开辟了。
	 */
	
	public Chinese(){
		//不带参数的构造函数
	}
	public Chinese(String id,String name,String country){
		this.id = id;
		this.name = name;
		this.country = country;
	}//带参数的构造函数
}
