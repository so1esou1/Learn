package implement;
//extends和implements同时出现
//extends关键字在前，implements关键字在后
public class Test01 {
	public static void main(String[] args) {
		//创建对象（表面看   Animal类没起作用）
		Flyable f = new Cat();//多态
		f.fly();
		
		//同一个接口调用同一个fly()方法，最后执行效果不同
		Flyable f2 = new Pig();
		f2.fly();
	}
}
//动物类：父类
class Animal{	
}
/*可飞翔的接口（是一对翅膀）
能插拔的就是接口
内存条插到主板上，他们之间有接口，内存条可以更换
接口通常提取的是行为动作*/
interface Flyable{
	void fly();
}
//动物类子类：猫类
//Flyable是一个接口，是一对翅膀的接口，通过接口插到猫身上，让猫变得可以飞翔
class Cat extends Animal implements Flyable{
	public void fly(){
		System.out.println("猫起飞");
	}
}
class Snake extends Animal{
}//蛇类，不实现接口表示没有翅膀，不能飞

//想飞就插翅膀这个接口
class Pig extends Animal implements Flyable{
	public void fly(){
		System.out.println("我是一只会飞的猪");
	}
}