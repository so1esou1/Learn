package equals;
//equals方法重写的时候要彻底
public class Test2 {
	public static void main(String[] args) {
		User u1 = new User("zhangsan",new Address("北京","大兴区","11111"));
		User u2 = new User("zhangsan",new Address("北京","大兴区","11111"));
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
	//重写equals，重写规则：当一个用户的用户名和家庭住址都相同，表示同一个用户
	//这个equals判断User对象和User对象是否相等
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
		//以上并未重写equals方法
		//这里的equals方法判断的是:Address和Address对象是否相等
		public boolean equals(Object obj){
			if(obj == null || !(obj instanceof Address)) return false;
			if(this == obj) return true;
			//if(城市相同 && 街道相同 && 邮编相同)
			Address a = (Address)obj;
			if(this.city.equals(a.city) 
					&& this.street.equals(a.street) 
					&& this.zipcode.equals(a.zipcode)){
				return true;
			}
			return false;
		}
	
}