package finalize;

public class Test1 {
	public static void main(String[] args) {
	/*	//��������
		Person p = new Person();
		//��ô��Person���������
		p = null;*/
		//JDK13����������������ǿ�������������ʹfinalizeִ��
		for(int i = 0;i < 1000000;i++){
			Person p = new Person();
			p = null;
		}
	}
	
}
//��Ŀ���������������������ж�����JVM�б��ͷŵ�ʱ�����¼һ���ͷ�ʱ�䣡
//�����¼�Ĵ���д��finalize()������
class Person{
	//��дfinalize()����
	//Person���͵Ķ����������������յ�ʱ�������������������:p.finalize();
	protected void finalize() throws Throwable{
		System.out.println("���������٣�");
	}
}