package com.bjpowercode.javase.test001;
/*Animal��Cat��Bird������֮��Ĺ�ϵ��
  cat�̳�animal��bird�̳�animal����cat��birdû���κμ̳й�ϵ
 */
public class Test {

	public static void main(String[] args) {
		//��ǰ��д�ĳ���
		Animal a1 = new Animal();
		a1.move();
		Cat c1 = new Cat();
		c1.move();
		Bird b1 = new Bird();
		b1.move();
		//ʹ�ö�̬�﷨����
		Animal a2 = new Cat();//cat is a animal,new Cat()�����Ķ����������Cat��a2������õ�����������Animal��������ת��Ϊ�����ͣ�����ת��
		a2.move();
		/*java�﷨��Զ��Ϊ����׶Ρ����н׶Σ��ȷ�������׶Σ��ٷ������н׶Σ������޷�ͨ�������޷����еģ�����׶α��������a2������õ���������ΪAnimal
		����Animal.class�ֽ�������move()���������Ա���ͨ���ˣ�������̳�Ϊ��̬�󶨡�����׶ΰ󶨣�ֻ�о�̬�󶨳ɹ�����к���������
		�ڳ������н׶Σ�JVM���ڴ�����ʵ�����Ķ�����Cat������ô���ϳ��������н׶�һ�������Cat�����move()��������ʱ�����˳���Ķ�̬�󶨣����н׶ΰ�
		����������ָ�������Ͷ������ֻ��Ƶ��³����ڱ���׶ΰ󶨺����н׶ΰ����ֲ�ͬ����̬/״̬�����ֻ��ƿ��Գ�Ϊ��̬��*/
		/*a2.catchMouse���ܵ��õ�ԭ�򣺱���׶α�������鵽��鵽a2��������Animal���ͣ���Animal.class�ֽ����ļ���
		 ��catchMouse()������û���ҵ������¾�̬��ʧ�ܣ�û�а󶨳ɹ���Ҳ����˵����ʧ���ˣ�Ҳû������
		 */
		//����ת�ͣ�����ת�͵�ʱ���������õķ����������������еģ��ڸ������в����ڣ������������ת��
		Cat c2 = (Cat)a2;
		c2.catchMouse();
		
		//����������ָ�������Ͷ��󡾶�̬��
		Animal a3 = new Bird();
		/*Cat c3 = (Cat)a3;����û�����⣬��Ϊ��������⵽a3������������Animal��Animal��Cat����ڼ̳й�ϵ��
		�������н׶λ�����쳣��JVM���ڴ�����ʵ���ڵĶ�����Bird���ͣ��޷�ת����Cat�����������ͼ䲻���ڼ̳й�ϵ����ʱ�����������쳣��java.lang.ClasscastException����ת���쳣�������쳣����������ת��ʱ�ᷢ��*/
		/*�����쳣ֻ����ǿ������ת����ʱ�����ڣ�������ת�͡�������������������������д���
		����ת��ֻҪ�ܱ���ͨ�������п϶������������*/
		//����İ취��ʹ��instanceof��������Ա���,instance���Է����ʵ��
		if(a3 instanceof Cat){//a3��һ��Cat���͵Ķ���
			Cat c3 = (Cat)a3;
		}else if(a3 instanceof Bird){//a3��һ��Bird���͵Ķ���
			Bird b2 = (Bird)a3;
			b2.fly();
		}
		
	}

}