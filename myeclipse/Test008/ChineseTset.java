package com.bjpowercode.javase.Test008;

public class ChineseTset {

	public static void main(String[] args) {
		//创建中国人对象1
		Chinese zhangsan = new Chinese("1","张三","中国");
		System.out.println(zhangsan.id + "," + zhangsan.name + "," +zhangsan.country);
		//创建中国人对象2
		Chinese lisi = new Chinese("2","李四","中国");
		System.out.println(lisi.id + "," + lisi.name + "," +lisi.country);
		//创建中国人对象3
		Chinese wangwu = new Chinese("3","王五","中国");
		System.out.println(wangwu.id + "," + wangwu.name + "," +wangwu.country);
	}

}
