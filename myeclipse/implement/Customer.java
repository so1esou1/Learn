package implement;

public class Customer {
  //顾客手里有一个菜单
	//如果以下这样写，就表示写死了（焊接了，没有了可插拔了）
	//ChinaCooker cc;  中餐厨师
	//AmericaCooker ac;  西餐厨师
	//面向抽象/接口编程，以下这样写较好（OCP开发原则）
	private FoodMenu foodMenu;
	//Cat is a Animal, 但凡满足is a的表示都可以设置为继承
	//Customer has a FoodMenu, 但凡满足has a的表示都以属性的形式存在
	public Customer(){
	}
	public Customer(FoodMenu foodMenu){
		this.foodMenu = foodMenu;
	}
	public void setFoodMenu(FoodMenu foodMenu){
		this.foodMenu = foodMenu;
	}
	public void getFoodMenu(){
		return foodMenu;
	}
	//提供点菜的方法
	public void order(){
		//先拿到菜单
		//使用get方法调用菜单
		//FoodMenu fm = this.getFoodMenu();
		//也可以不调用get方法，因为在本类中私有的属性是可以访问的
		foodMenu.shiZiChaoJiDan();
		foodMenu.yuXiangRouSi();
	}
}
