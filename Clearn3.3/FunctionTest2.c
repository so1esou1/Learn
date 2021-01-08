#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>   //会把stdio.h的代码全部拷贝过来
#include <string.h>

//模块写法示范
/*#include "Add.h"
int main()
{
	int a = 10;
	int b = 20;
	int sum = Add(a, b);
	printf("%d\n", sum);
	return 0;    //查看头文件和源文件,分模块去写
}*/



//递归：程序调用自身的编程技巧。一个过程或函数在其定义中有直接或间接调用自身的一种方法，通常把
//一个大型复杂的问题转化为一个与原问题相似的规模小的问题来求解，递归策略只需少量程序就可描述出解题过程
//所需要的多次重复计算，大大减少了程序的代码量。递归的主要思考方式：把大事化小

//一个简单的递归：
/*int main()
{
	printf("hehe\n");
	main();
	return 0;
}     //这个递归会死循环打印递归。递归最终会栈溢出（stack overflow，递归常见错误），自己结束
      //https://stackoverflow.com/  程序员的知乎
*/

//递归练习1：用递归，要求拿到输入的数字，一个一个打印出来
/*void print(int n)
{
	if (n > 9)  //说明至少是两位数，判断位数
	{
		print(n / 10);
	}
	printf("%d ", n%10);
	//分析：print使用了递归，不断算商并检测位数，一开始得到1的时候，略过print打印出"1 "；然后回去12的时候，12%10打印出2；然后123%10，打印3.......
}
int main()
{
	unsigned int num = 0;
	scanf_s("%d", &num);     //输入1234
	//递归
	print(num);
	//思路：
	//print(1234)
	//print(123) 4
	//print(12) 3  4
	//print(1) 2  3  4
	
	return 0;
}    //递归减少了很多代码量
*/     

//*****递归的两个必要条件：
//1、写递归时要找到约束限制条件，否则容易陷入死循环、栈溢出
//2、每次递归需要越来越接近这个限制条件，否则也会不断循环，不能停下来




//递归练习2：
//编写函数，不创建临时变量，求字符串长度
/*int my_strlen(char* str)   //str存放的是数组首元素b的地址（数组元素是：b i t \0，一次把第一、第二、第三字符打印，\0时代表结束）
{
	int count = 0;
	while (*str != '\0')      //while用于循环
	{
		count++;
		str++;  //str这个指针也往后走一位
	}
	return count;
}这还是创建了临时变量，下面的函数是用递归代替了count*/
//递归的方法：
int my_strlen(char* str)
{
	//把大事化小
	//my_strlen("bit");
	//1 + my_strlen("it");
	//1 + 1+ my_strlen("t");
	//1 + 1+ 1+ my_strlen("");只剩最后的\0了
	//1+1+1 = 3 大事化小
	if (*str != '\0')
		return 1 + my_strlen(str + 1);
	else
		return 0;
}

int main()
{
	//创建临时变量的方法
	char arr[] = "bit";
	//int len = strlen(arr);
	//printf("%d\n", len);

	//不创建临时变量的方法
	//模拟实现一个strlen函数
	int len = my_strlen(arr);   //arr是数组，数组传参，传过去的不是整个数组，而是首元素的地址
	printf("len = %d\n",len);
	return 0;
}