package toString;

public class ObjectTest01 {
	public static void main(String[] args) {
		MyTime t1 = new MyTime(1970,1,1);
		//һ�����ڶ���ת�����ַ�����ʽ�Ļ����ҿ��ܻ���ϣ���ܿ��������������Ϣ��������һ��������ڴ��ַ
		String s1 = t1.toString();
		
		//MyTime����дtoString����ǰ
		System.out.println(s1);//toString.MyTime@2e6e1408
		//ע�⣺������õ�ʱ�򣬻��Զ�����toString()����
	}
}
class MyTime{
	int year;
	int month;
	int day;
	
	public MyTime(){
		
	}
	public MyTime(int year,int month,int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//��дtoString()����
	//���toStringԽ���Խ�ã��ɶ���ԽǿԽ��
	public String toString(){
		return this.year + "��" + this.month + "��" + this.day + "��";
	}
}
