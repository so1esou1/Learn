package com.bjpowercode.javase.Test004;
//�û���
public class User {
	private int id;//ʵ������
	private String name;

	//���캯��
	//setter and getter
	public User(){
		
	}
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int a){
		id = a;		
	}
	/*���³���id��ʵ������id�޹أ����ܲ������ַ�ʽ
	 public void steId(int id){
	 	id = id;
	 }
	 */
	//��������д��
	public void steId(int id){
		this.id = id;//�Ⱥ�ǰ���id��ʵ������id��������Ǿֲ�����id
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
}
