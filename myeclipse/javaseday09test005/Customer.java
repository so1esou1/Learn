package com.bjpowercode.javaseday09test005;

public class Customer {
	private int no;
	private String name;
	private String birth;
	public Customer(int a, String b, String c) {
		super();
		no = a;
		name = b;                                               
		birth = c;                                              
	}                                                           
	public int getNo() {                                        
		return no;                                              
	}                                                           
	public void setNo(int no) {                                 
		this.no = no;                                           
	}                                                           
	public String getName() {                                   
		return name;                                            
	}                                                           
	public void setName(String name) {                          
		this.name = name;                                       
	}                                                           
	public String getBirth() {                                  
		return birth;                                           
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
}
