#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
//网址：http://cplusplus.com/     http://en.cppreference.com
//库函数的学习一般是看文档

//写一个加法的函数
/*int Add(int x, int y)
{
	int z = 0;
	z = x + y;
	return z;
}
int main() {
	int a = 10;
	int b = 20;
	int sum = Add(a, b);
	printf("%d\n", sum);

	return 0;
}*/



	//memset 内存设置函数
/*int main()
{
	char arr[] = "hello world";  //把hello输出成*符号
	memset(arr, '*', 5);
	printf("%s\n", arr);
	//保证源头数据足够长，不然会溢出，成BUG

	return 0;
}*/


//必须学会自定义函数的使用，必须自己设置函数
//一个函数的基本组成：例：
/*ret_type fun_name(paral, *)
{
	statement;  //语句项或函数体，交代函数是怎么实现的
}    //ret_type:返回类型    fun_name：函数名    paral：函数参数*/


//写一个函数，找出两个数的最大值
//定义函数
/*int get_max(int x, int y)   //int 表示返回整型的类型
{
	if (x > y)
		return x;
	else
		return y;

}
int main()
{
	int a = 10;
	int b = 20;
	//函数的使用场景
	int max = get_max(a,b);  //函数及传参.a传给x，b传给y，进行比较
	printf("max = %d\n", max);

	return 0;
}*/


//写一个函数，交换两个整型变量的内容
//封装一个函数
/*void Swap1(int x,int y)   //void 没有返回值
{
	int temp = 0;
	temp = x;
	x = y;
	y = temp;
	//这种写法不行，最终结果a和b并没有得到交换，需要进行修改(用指针的方法进行修改)
	//***当实参传给形参的时候，形参其实是实参的一份临时拷贝，对形参的修改是不会改变实参的！！！！
}*/
/*void Swap2(int* pa,int* pb)  //a的地址给了pa，b的地址给了pb，通过地址的传递值
{
	int temp = 0;
	temp = *pa;
	*pa = *pb;
	*pb = temp;
}
int main()
{
	int a = 10;
	int b = 20;
	int temp = 0;
	
	//Swap1(a,b);
	//调用swap2函数
	Swap2(&a, &b);
	//开始交换
	/*temp = a;
	a = b;
	b = temp;   把这个写到一个函数里面去
	//结束交换
	printf("a = %d b = %d\n", a, b);
	return 0;
}*/



//定义函数
//形参-形式参数
//*实参，真实传给函数的参数，可以是常量、变量、表达式、函数等，无论是何种类型的量，在被函数调用时，都必须有确定的值，以便把值传给形参。
//* 形参：函数名后括号中的变量，因为形式参数只有在函数被调用的过程才能实例化（分配内存单元），
//所以叫形式参数，形式参数当函数调用完成后自动销毁，因此只有在函数中才有效
/*int get_max(int x, int y)
{
	if (x > y)
		return x;
	else
		return y;
}
int main()
{
	int a = 10;
	int b = 20;
	//函数的使用
	int max = get_max(a, b);
	printf("max = %d\n", max);
	max = get_max(100, 300 - 1);
	max = get_max(100, get_max(3, 7));

	printf("max = %d\n", max);

	return 0;
}*/

/* ***函数调用的分类：1、传值调用：函数的形参和实参分别占有不同的内存块，
对形参的修改不会影响实参。（以后只传值不进行改变函数外面某些变量的话可以使用）
2、传址调用：把函数外部创建变量的内存地址传递给函数参数的一种调用函数的方式，
可以让函数和函数外边的变量建立起真正的联系，也就是
函数内部可以直接操作函数外部的变量。*/



//函数的嵌套调用和链式访问
//嵌套调用：
/*void new_line()
{
	printf("hehe\n");
}
void three_line()
{
	int i = 0;
	for (i = 0; i < 3; i++)
	{
		new_line();
	}
}
int main()
{
	three_line();   //主函数调用three_line()，three_line()调用new_line
	return 0;
}*/

//链式访问：把一个函数的返回值作为另一个函数的参数
#include <string.h>
/*int main()
{
	char arr[20] = "hello";
	int ret = strlen(strcat(arr, "bit"));
	printf("%d\n", ret);
	return 0;
}*/
/*int main()
{
	printf("%d", printf("%d", printf("%d", 43)));
	return 0;
}   //这个打印结果是4321，由里向外打印。printf返回值是打印的字符的个数，43->2->1*/



//函数声明:    使用之前声明函数存在,通常声明和定义合并到一起。（函数声明一般放到头文件.h中，函数定义一般放到.c源文件中，" #include"...""进行引用）
//分模块的写法更方便分工
int Add(int x, int y);  

int main()
{
	int a = 10;
	int b = 20;
	int sum = 0;
	sum = Add(a, b);
	printf("%d\n", sum);
	return 0;
}
//函数的定义：
int Add(int x, int y)
{
	int z = x + y;
	return z;
}
