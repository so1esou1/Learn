package implement;

public class CustomerTest {


	public static void main(String[] args) {
		//创建初始对象
		FoodMenu cooker = new ChinaCooker();
		//创建顾客对象
		Customer customer = new Customer(cooker1);
		//顾客点菜
		customer.order();

	}

}
