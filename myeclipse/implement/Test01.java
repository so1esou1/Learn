package implement;
//extends��implementsͬʱ����
//extends�ؼ�����ǰ��implements�ؼ����ں�
public class Test01 {
	public static void main(String[] args) {
		//�������󣨱��濴   Animal��û�����ã�
		Flyable f = new Cat();//��̬
		f.fly();
		
		//ͬһ���ӿڵ���ͬһ��fly()���������ִ��Ч����ͬ
		Flyable f2 = new Pig();
		f2.fly();
	}
}
//�����ࣺ����
class Animal{	
}
/*�ɷ���Ľӿڣ���һ�Գ��
�ܲ�εľ��ǽӿ�
�ڴ����嵽�����ϣ�����֮���нӿڣ��ڴ������Ը���
�ӿ�ͨ����ȡ������Ϊ����*/
interface Flyable{
	void fly();
}
//���������ࣺè��
//Flyable��һ���ӿڣ���һ�Գ��Ľӿڣ�ͨ���ӿڲ嵽è���ϣ���è��ÿ��Է���
class Cat extends Animal implements Flyable{
	public void fly(){
		System.out.println("è���");
	}
}
class Snake extends Animal{
}//���࣬��ʵ�ֽӿڱ�ʾû�г�򣬲��ܷ�

//��ɾͲ�������ӿ�
class Pig extends Animal implements Flyable{
	public void fly(){
		System.out.println("����һֻ��ɵ���");
	}
}