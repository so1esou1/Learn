package com.bjpowercode.javase.Test009;

public class ChineseTset {

	public static void main(String[] args) {
		//�����й��˶���1
		Chinese zhangsan = new Chinese("1","����");
		System.out.println(zhangsan.id + "," + zhangsan.name + "," + Chinese.country);
		//�����й��˶���2
		Chinese lisi = new Chinese("2","����");
		System.out.println(lisi.id + "," + lisi.name + ","+ Chinese.country);
		//�����й��˶���3
		Chinese wangwu = new Chinese("3","����");
		System.out.println(wangwu.id + "," + wangwu.name + ","+ Chinese.country);
	}

}
