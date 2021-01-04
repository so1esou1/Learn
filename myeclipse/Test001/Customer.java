package com.bjpowercode.javase.Test001;

public class Customer {
	String name;
	//构造方法
	public Customer(){
		
	}
	/*不带有static关键字的一个方法
	  顾客购物的行为，每个顾客购物最终的结果都是不一样的，所以购物这个行为是属于对象级别的行为
	  由于每个对象再执行购物这个动作的最终结果不同，所以购物这个动作必须有“对象”的参与
	  没有static关键字的方法被称为“实例方法”，对象被称为“实例变量”，当一个行为/动作执行的过程中是需要对象参与的，
	  那么这个方法一定要定义为“实例方法”，不需要static关键字
	 */
	public void shopping(){
		System.out.println(this.name + "在购物！");//完整的写法
	}
}
