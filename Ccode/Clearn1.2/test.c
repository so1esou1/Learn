#define _CRT_SECURE_NO_WARNINGS 1   //源文件的第一行，加上这句话，可以通过某些警告
#include<stdio.h>
#include <String.h>
int main()
{
	/*int num1 = 0;
	int num2 = 0;
	int sum = 0;
	scanf("%d%d", &num1, &num2);  //使用上有一定的不安全性，VS针对这类型的函数提供了自有的写法，不适用于其他平台
	sum = num1 + num2;
	printf("sum = %d\n", sum);
	return 0;*/


	/*
	字面常量
	3;
	100;
	3.14
	*/
	
	//const-常属性，在变量前面加了之后不能再变了
	//const int num = 4;

	//枚举常量


	//if语句示例
	/*int input = 0;
	printf("加入比特\n");
	printf("你要好好学习吗？(1/0)>:");
	scanf("%d", &input);   //1/0
	if (input == 1)
		printf("好offer\n");
	else
		printf("卖红薯\n");*/

	//while语句示例
	int line = 0;
	printf("加入比特\n");

	while (line < 20000)
	{
		printf("敲一行代码%d\n",line);
		line++;
	}
	if(line >= 20000)
	printf("好offer\n");



	return 0;
}