package implement;

public class Customer {
  //�˿�������һ���˵�
	//�����������д���ͱ�ʾд���ˣ������ˣ�û���˿ɲ���ˣ�
	//ChinaCooker cc;  �вͳ�ʦ
	//AmericaCooker ac;  ���ͳ�ʦ
	//�������/�ӿڱ�̣���������д�Ϻã�OCP����ԭ��
	private FoodMenu foodMenu;
	//Cat is a Animal, ��������is a�ı�ʾ����������Ϊ�̳�
	//Customer has a FoodMenu, ��������has a�ı�ʾ�������Ե���ʽ����
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
	//�ṩ��˵ķ���
	public void order(){
		//���õ��˵�
		//ʹ��get�������ò˵�
		//FoodMenu fm = this.getFoodMenu();
		//Ҳ���Բ�����get��������Ϊ�ڱ�����˽�е������ǿ��Է��ʵ�
		foodMenu.shiZiChaoJiDan();
		foodMenu.yuXiangRouSi();
	}
}
