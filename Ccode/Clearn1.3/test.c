#include <stdio.h>

void test()
{
	static int a = 1;  //a是一个静态局部变量，没有static的时候，进入这个函数就创建一次变量a，出去就销毁，加入static的时候，不会刷新变量a
	a++;
	printf("a = %d\n", a); //2 3 4 5 6
}

//static声明外部函数示例：
extern int Add(int, int);

//#define MAX 100    #define定义标识符常量

//#define定义宏-带参数
//函数的实现
int Max(int x, int y)
{
	if (x > y)
		return x;
	else
		return y;
}
//宏的定义方式和函数定义很相似
#define MAX(X,Y) (X>Y?X:Y)

int main()
{
	//指针简述
	int a = 10;//4个字节
	int* p = &a;//取地址
	printf("%p\n", &a);
	printf("%p\n", p);//两个地址一样,0135FA08
	*p = 20;//* -- 解引用操作符
	printf("a = %d\n", a);//a = 20
	//&a;  取地址
	//有一种变量是用来存放地址的--指针变量
	//printf("%p\n", &a);



	//#define定义常量和宏
	/*int a = MAX;*/
	/*int a = 10;
	int b = 20;
	//函数的方式
	int max = Max(a, b);
	printf("max = %d\n", max);
	//宏的方式
	max = MAX(a, b);
	//调宏后相当于max = (a>b?a:b);
	printf("max = %d\n", max);*/


	//static关键字示例，static修饰局部变量，局部变量的生命周期变长了
	/*int i = 1;
	while (i < 5)
	{
		test();
		i++;
	}*/

	//static修饰全局变量，改变了变量的作用域，以下程序不能调用g_val，只能在自己所在的源文件内部使用，出了源文件就无法使用了
		//extern---声明外部符号的
	/*extern int g_val;
	printf("g_val = %d\n", g_val);*/


	//static关键字声明外部函数示例，改变了函数的链接属性
	//普通函数具有外部链接属性，static修饰后，外部链接属性变成了内部链接属性
	/*int a = 10;
	int b = 20;
	int sum = Add(a, b);
	printf("sum = %d\n", sum);  //无法调用add的函数了*/


	//typedef关键字示例
	/*typedef unsigned int u_int;//将unsigned int重新定义为u_int（相当于别名）
	unsigned int num = 20;
	u_int num2 = 20;*/



	//字符串的结束标志是'\0'，转义字符，被隐藏了

	/*int a = 10;
	int b = 10;
	int max = 0;
	max = (a > b ? a : b);  //判断a与b大小，a大则输出a的值，b大则输出b的值（三目操作符）
	if (a > b)
		max = a;
	else
		max = b;*/


	/*int a = 10;
	int b = a++;//后置++，先把a的值赋给b，再将a加1
	int c = 10;
	int d = ++c;//前置++，先计算a的值，再赋给b
	printf("a = %d b = %d\n", a, b);//a =11,b = 10
	printf("c = %d d = %d\n", c, d);//c =11,d = 11*/

	

	return 0;

}