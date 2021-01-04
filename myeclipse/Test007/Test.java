package com.bjpowercode.javase.Test007;

public class Test {

	public static void main(String[] args) {
		Test.doSome();
		doSome();
		
		Test t =new Test();
		t.doSome();
		
		//引用是空
		t = null;
		t.doSome();/*当空引用访问实例相关的数据时会出现空指针异常，因为实例相关数据是对象相关的数据，
		这些数据在访问的时候，必须要有对象的参与，当空引用时，对象不存在，
		访问这些实例数据一定会出现空指针异常。*/
		/*这个程序执行根本没有用到对象，才能执行成功，每出现空指针异常。t（引用）在执行时会被改成Test（类名）
		 带有static的方法，其实可以采用类名的方式引用，也可以采用引用的方式访问，
		 但是即使采用引用的方式去访问，实际上执行的时候和采用指向的对象无关
		 在myeclipse中开发的时候，使用引用的方式访问带有static的方法，程序会出现警告
		 所以带有static方法还是建议使用“类名.”的方式访问*/
	}
	//带有static的方法，需要使用“类名.”的方式访问
	public static void doSome(){
		System.out.println("do Some!");
	}
}
