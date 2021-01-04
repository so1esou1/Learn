package com.bjpowercode.javaseday09test006;

public class Test02 {

	public static void main(String[] args) {
		User u = new User(20);//与Test01中的i相比，这里的u保存的是另一个java对象在堆内存中的内存地址，占用空间的局部变量
		add(u);//这个u和上面的不是一个，但都是局部变量，都指向User对象
		System.out.println("main-->" + u.age);//21；跟Test01不同的是，这里u保存的是地址，下面u变成了21，转回来这行，u仍指向同一地址，也是21
	}
	public static void add(User u){
		u.age++;
		System.out.println("add-->" + u.age);//21
	}


}
class User{
	//实例变量
	int age;
	
	//构造方法
	public User(int i){
		age = i;
	}
}
