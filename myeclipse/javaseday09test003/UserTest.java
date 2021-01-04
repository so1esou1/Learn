package com.bjpowercode.javaseday09test003;

public class UserTest {
	public static void main(String[] args){
		//创建User对象
		User user = new User();
		//访问age
		//读取年龄值
		System.out.println("该用户年龄：" + user.age);
		//修改年龄值
		user.age = 20;/*这里的age属性显然是完全暴露给外部属性，对于程序员来说，可以操作User中所有细节，
		导致User中部分数据不安全，建议User内存进行封装，建议在外部程序中不能随意访问数据*/
		System.out.println("该用户年龄：" + user.age);
	}

}
