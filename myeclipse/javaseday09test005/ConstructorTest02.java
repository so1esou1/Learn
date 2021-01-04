package com.bjpowercode.javaseday09test005;

public class ConstructorTest02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account act1 = new Account();

		System.out.println("’À∫≈"+ act1.getActno());
		System.out.println("”‡∂Ó"+ act1.getBalance());
		
		Account act2 = new Account("110");

		System.out.println("’À∫≈"+ act2.getActno());//110
		System.out.println("”‡∂Ó"+ act2.getBalance());//0.0
		
		Account act3 = new Account(10000.0);

		System.out.println("’À∫≈"+ act3.getActno());//null
		System.out.println("”‡∂Ó"+ act3.getBalance());//10000.0
	
		Account act4 = new Account("act-001",10000.0);

		System.out.println("’À∫≈"+ act4.getActno());//act-001
		System.out.println("”‡∂Ó"+ act4.getBalance());//10000.0
	}

}
