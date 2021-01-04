package com.bjpowercode.javase.test005;
/*访问控制权限修饰符：
 1、访问控制权限修饰符来控制元素的访问范围
 2、访问控制权限修饰符包括：public protected 缺省（default） private
 3、访问控制权限修饰符可以修饰：类、变量、方法……
 4、public：表示公开的，在任何位置都可以访问；private：表示私有的，只能在本类中访问
 protected：同包、子类中可以访问；缺省：同包下可以访问
 当某个数据只希望子类使用，用protected修饰
 修饰符范围：private<缺省<protected<public
 */
public class Test01 {

	public static void main(String[] args) {
		User u = new User();
		System.out.println(u.i);
		System.out.println(u.j);
	}

}
