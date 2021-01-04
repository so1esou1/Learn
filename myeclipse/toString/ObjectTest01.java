package toString;

public class ObjectTest01 {
	public static void main(String[] args) {
		MyTime t1 = new MyTime(1970,1,1);
		//一个日期对象转换成字符串形式的话，我可能还是希望能看到具体的日期信息，而不是一个对象的内存地址
		String s1 = t1.toString();
		
		//MyTime类重写toString方法前
		System.out.println(s1);//toString.MyTime@2e6e1408
		//注意：输出引用的时候，会自动调用toString()方法
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
	//重写toString()方法
	//这个toString越简洁越好，可读性越强越好
	public String toString(){
		return this.year + "年" + this.month + "月" + this.day + "日";
	}
}
