package implement;

public class CustomerTest {


	public static void main(String[] args) {
		//������ʼ����
		FoodMenu cooker = new ChinaCooker();
		//�����˿Ͷ���
		Customer customer = new Customer(cooker1);
		//�˿͵��
		customer.order();

	}

}
