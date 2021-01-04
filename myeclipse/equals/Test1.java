package equals;

public class Test1 {
	public static void main(String[] args) {
		int a = 100;
		int b = 100;
		System.out.println(a == b);
		
		MyTime t1 = new MyTime(2008,8,8);
		MyTime t2 = new MyTime(2008,8,8);
		System.out.println(t1 == t2);  //false
		//��дObject equals֮ǰ
		boolean flag = t1.equals(t2);
		System.out.println(flag);//false
	}
}
class MyTime{  //extends Object
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
	//��дObject���equals����
/*	public boolean equals(Object obj){
		//������ͬ������ͬ����Ҳ��ͬʱ����ʾ����������ȣ������������
		//��ȡ��һ�����ڵ�������
		int year1 = this.year;
		int month1 = this.month;
		int day1 = this.day;
		//��ȡ�ڶ������ڵ�������
		if(obj instanceof MyTime){    //ǿ������ת��������ת��
			MyTime t =(MyTime)obj;
			int year2 = t.year;
			int month2 = t.month;
			int day2 = t.day;
			//��ʼ�ȶ�
			if(year1 == year2 && month1 == month2 && day1 == day2){
				return true;
			}
		}

		//�����ܹ�ִ�е��˴���ʾ���ڲ����
		return false;
	}
*/
/*	//����Ч��д����
	public boolean equals(Object obj){
		//���obj�ǿգ�ֱ�ӷ���false
		if(obj == null){
			return false;
		}
		//���obj���Ǹ�MyTime��û��Ҫ�ȣ�ֱ�ӷ���false
		if(!(obj instanceof MyTime)){    //�������������ǡ�
			return false;
		}
		//���this��obj����ĵ�ַ��ͬ��û��Ҫ�����Ƚ��ˣ�ֱ�ӷ���true
		if(this == obj){
			return true;
		}
		//����ִ�е��˴�˵��obj����null��obj��MyTime����
		MyTime t = (MyTime)obj;
		if(this.year == t.year && this.month == t.month && this.day == t.day ){
			return true;
		}
		//�����ܵ��⣬����false
		return false;
	}
*/
	//�ٴθ�����
	public boolean equals(Object obj){
		//���obj�ǿգ�ֱ�ӷ���false
		if(obj == null){
			return false;
		}
		//���obj���Ǹ�MyTime��û��Ҫ�ȣ�ֱ�ӷ���false
		if(!(obj instanceof MyTime)){    //�������������ǡ�
			return false;
		}
		//���this��obj����ĵ�ַ��ͬ��û��Ҫ�����Ƚ��ˣ�ֱ�ӷ���true
		if(this == obj){
			return true;
		}
		//����ִ�е��˴�˵��obj����null��obj��MyTime����
		MyTime t = (MyTime)obj;
		return this.year == t.year && this.month == t.month && this.day == t.day ;
	}
}



