package equals;

public class Test1 {
	public static void main(String[] args) {
		int a = 100;
		int b = 100;
		System.out.println(a == b);
		
		MyTime t1 = new MyTime(2008,8,8);
		MyTime t2 = new MyTime(2008,8,8);
		System.out.println(t1 == t2);  //false
		//重写Object equals之前
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
	//重写Object类的equals方法
/*	public boolean equals(Object obj){
		//当年相同、月相同、日也相同时，表示两个日期相等，两个对象相等
		//获取第一个日期的年月日
		int year1 = this.year;
		int month1 = this.month;
		int day1 = this.day;
		//获取第二个日期的年月日
		if(obj instanceof MyTime){    //强制类型转换，向下转换
			MyTime t =(MyTime)obj;
			int year2 = t.year;
			int month2 = t.month;
			int day2 = t.day;
			//开始比对
			if(year1 == year2 && month1 == month2 && day1 == day2){
				return true;
			}
		}

		//程序能够执行到此处表示日期不想等
		return false;
	}
*/
/*	//更高效的写法：
	public boolean equals(Object obj){
		//如果obj是空，直接返回false
		if(obj == null){
			return false;
		}
		//如果obj不是个MyTime，没必要比，直接返回false
		if(!(obj instanceof MyTime)){    //“！”代表“不是”
			return false;
		}
		//如果this和obj保存的地址相同，没必要继续比较了，直接返回true
		if(this == obj){
			return true;
		}
		//程序执行到此处说明obj不是null，obj是MyTime类型
		MyTime t = (MyTime)obj;
		if(this.year == t.year && this.month == t.month && this.day == t.day ){
			return true;
		}
		//程序能到这，返回false
		return false;
	}
*/
	//再次改良：
	public boolean equals(Object obj){
		//如果obj是空，直接返回false
		if(obj == null){
			return false;
		}
		//如果obj不是个MyTime，没必要比，直接返回false
		if(!(obj instanceof MyTime)){    //“！”代表“不是”
			return false;
		}
		//如果this和obj保存的地址相同，没必要继续比较了，直接返回true
		if(this == obj){
			return true;
		}
		//程序执行到此处说明obj不是null，obj是MyTime类型
		MyTime t = (MyTime)obj;
		return this.year == t.year && this.month == t.month && this.day == t.day ;
	}
}



