package com.bjpowercode.javase.test001;
/*Animal、Cat、Bird三个类之间的关系：
  cat继承animal，bird继承animal，但cat和bird没有任何继承关系
 */
public class Test {

	public static void main(String[] args) {
		//以前编写的程序
		Animal a1 = new Animal();
		a1.move();
		Cat c1 = new Cat();
		c1.move();
		Bird b1 = new Bird();
		b1.move();
		//使用多态语法机制
		Animal a2 = new Cat();//cat is a animal,new Cat()创建的对象的类型是Cat，a2这个引用的数据类型是Animal，子类型转换为父类型，向上转型
		a2.move();
		/*java语法永远分为编译阶段、运行阶段，先分析编译阶段，再分析运行阶段，编译无法通过，是无法运行的；编译阶段编译器检查a2这个引用的数据类型为Animal
		由于Animal.class字节码中有move()方法，所以编译通过了，这个过程称为静态绑定、编译阶段绑定，只有静态绑定成功后才有后续的运行
		在程序运行阶段，JVM堆内存中真实创建的对象是Cat对象，那么以上程序在运行阶段一定会调用Cat对象的move()方法，此时发生了程序的动态绑定，运行阶段绑定
		父类型引用指向子类型对象这种机制导致程序在编译阶段绑定和运行阶段绑定两种不同的形态/状态，这种机制可以称为多态。*/
		/*a2.catchMouse不能调用的原因：编译阶段编译器检查到检查到a2的类型是Animal类型，从Animal.class字节码文件中
		 找catchMouse()方法，没有找到，导致静态绑定失败，没有绑定成功，也就是说编译失败了，也没有运行
		 */
		//向下转型：向下转型的时机：当调用的方法是子类型中特有的，在父类型中不存在，必须进行向下转型
		Cat c2 = (Cat)a2;
		c2.catchMouse();
		
		//父类型引用指向子类型对象【多态】
		Animal a3 = new Bird();
		/*Cat c3 = (Cat)a3;编译没有问题，因为编译器检测到a3的数据类型是Animal，Animal和Cat间存在继承关系。
		但是运行阶段会出现异常，JVM对内存中真实存在的对象是Bird类型，无法转换成Cat对象，两种类型间不存在继承关系，此时出现了著名异常：java.lang.ClasscastException类型转换异常，这种异常总是在向下转型时会发生*/
		/*以上异常只会在强制类型转换的时候会存在，“向下转型”存在隐患（编译过，但是运行错）
		向上转型只要能编译通过，运行肯定不会出现问题*/
		//避免的办法：使用instanceof运算符可以避免,instance可以翻译成实例
		if(a3 instanceof Cat){//a3是一个Cat类型的对象
			Cat c3 = (Cat)a3;
		}else if(a3 instanceof Bird){//a3是一个Bird类型的对象
			Bird b2 = (Bird)a3;
			b2.fly();
		}
		
	}

}
