package finalize;

public class Test1 {
	public static void main(String[] args) {
	/*	//创建对象
		Person p = new Person();
		//怎么把Person变成垃圾？
		p = null;*/
		//JDK13后垃圾收器能力增强，多造点垃圾来使finalize执行
		for(int i = 0;i < 1000000;i++){
			Person p = new Person();
			p = null;
		}
	}
	
}
//项目开发中有这样的需求：所有对象在JVM中被释放的时候，请记录一下释放时间！
//这个记录的代码写到finalize()方法中
class Person{
	//重写finalize()方法
	//Person类型的对象被垃圾回收器回收的时候，垃圾回收器负责调用:p.finalize();
	protected void finalize() throws Throwable{
		System.out.println("即将被销毁！");
	}
}