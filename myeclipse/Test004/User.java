package com.bjpowercode.javase.Test004;
//用户类
public class User {
	private int id;//实例变量
	private String name;

	//构造函数
	//setter and getter
	public User(){
		
	}
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int a){
		id = a;		
	}
	/*以下程序id和实例变量id无关，不能采用这种方式
	 public void steId(int id){
	 	id = id;
	 }
	 */
	//可以这样写：
	public void steId(int id){
		this.id = id;//等号前面的id是实例变量id，后面的是局部变量id
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
}
