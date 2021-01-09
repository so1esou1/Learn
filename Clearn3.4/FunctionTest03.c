#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>

//递归与迭代
//迭代：重复地做一件事




//求n的阶乘
/*int Fac1(int n)  //这是循环的方式
{
	int i = 0;
	int ret = 1;
	for (i = 1; i <= n; i++)
	{
		ret *= i;
	}
	return ret;
}
int Fac2(int n)          //递归的方式      n的阶乘的原理：n*Fac(n - 1)
{
	if (n <= 1)
		return 1;
	else
		return n* Fac2(n - 1);
}
int main()
{
	int n = 0;
	int ret = 0;
	scanf("%d", &n);
	//ret = Fac1(n);   //用循环的方式来实现
	ret = Fac2(n);  //使用递归的方式
	printf("%d\n", ret);

	return 0;
}*/



//斐波那契数列：前两个数之后等于第三个数的数列     1 1 2 3 5 8 13 21 34 55.....
//求第n个斐波那契数列
/*int Fib(int n)     //递归的写法
{
	if (n <= 2)
		return 1;
	else
		return Fib(n - 1) + Fib(n - 2);
}     //*这种代码写法效率太低了，数值一大就需要多次往前推算。把这个写成循环的方式
*/
/*int Fib(int n)       //循环的写法
{
	int a = 1;
	int b = 1;
	int c = 1;
	while (n > 2)
	{
		c = a + b;
		a = b;
		b = c;
		n--;
	}
	return c;
}
int main()
{
	int n = 0;
	int ret = 0;
	scanf("%d", &n);
	//先写函数怎么用，再写函数，这种写程序方式叫做TDD-测试驱动开发
	ret = Fib(n);
	printf("ret = %d\n", ret);
	return 0;
}*/


//递归可能存在栈溢出的现象！！！
/*选择递归或循环的依据？
 首先看哪种方法容易写；递归会栈溢出时用循环
 */ 


//递归栈溢出示例：
void test(int n)
{
	if (n < 10000)
	{
		test(n + 1);
	}
}
int main()
{
	test(1);
	return 0;
}

//递归测试题：汉诺塔问题、青蛙跳台阶问题