package equals;
//equals������д��ʱ��Ҫ����
public class Test2 {
	public static void main(String[] args) {
		User u1 = new User("zhangsan",new Address("����","������","11111"));
		User u2 = new User("zhangsan",new Address("����","������","11111"));
		System.out.println(u1.equals(u2));  //true
	}
}
class User{
	String name;
	Address addr;
	
	public User(){
	}
	public User(String name,Address addr){
		this.name = name;
		this.addr = addr;
	}
	//��дequals����д���򣺵�һ���û����û����ͼ�ͥסַ����ͬ����ʾͬһ���û�
	//���equals�ж�User�����User�����Ƿ����
	public boolean equals(Object obj){
		if(obj == null || !(obj instanceof User)) return false;
		if(this == obj) return true;
		
		User u = (User)obj;

		if(this.name.equals(u.name) && this.addr.equals(u.addr)){
			return true;
		}
		return false;
	}
}
class Address{
	String city;
	String street;
	String zipcode;
	
	public Address(){
		
	}
	public Address(String city,String street,String zipcode){
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
		//���ϲ�δ��дequals����
		//�����equals�����жϵ���:Address��Address�����Ƿ����
		public boolean equals(Object obj){
			if(obj == null || !(obj instanceof Address)) return false;
			if(this == obj) return true;
			//if(������ͬ && �ֵ���ͬ && �ʱ���ͬ)
			Address a = (Address)obj;
			if(this.city.equals(a.city) 
					&& this.street.equals(a.street) 
					&& this.zipcode.equals(a.zipcode)){
				return true;
			}
			return false;
		}
	
}