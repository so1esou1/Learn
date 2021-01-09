#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>

//一维数组的创建（及一些特殊数组示例）
/*int main()
{
	//数组-存放整型10个
	int arr[10];  //里面必须是常量
	char arr2[5];
	
	//数组的初始化：在创建数组的同时给数组的内容一些合理初始值（初始化）
	int arr3[5] = { 1,2,3 };        //不完全初始化，剩下的元素默认的初始化为0
	char arr4[5] = { 'a','b' };
	char arr5[5] = { "ab" };    //注意！这个数组放入的是a、b和\0这三个元素，最后两个元素仍默认是0.因此结果还是3个0
	char arr6[5] = { 'a',98 };  //这里的用98代表字母b是可以的
	char arr7[] = { "abcdef" };   //没有给数组大小的，会根据初始化的值自动给一个长度，这个是7个元素

	printf("%d\n", sizeof(arr7));      //打印结果是7，sizeof是计算arr7所占空间的大小
	printf("%d\n", strlen(arr7));      //打印结果是6，strlen在求字符串长度，找到\0就停止了，且\0不算进去
	//sizeof和strlen没有什么关联，strlen只能求字符串长度，是库函数，需要引用头文件
	//sizeof是计算变量、数组、类型的大小，单位是字节，是操作符

	return 0;
}*/


//strlen和sizeof的比较示例
/*int main()
{
	char arr1[] = "abc";
	char arr2[] = { 'a','b','c' };
	printf("%d\n", sizeof(arr1));    //打印结果是4
	printf("%d\n", sizeof(arr2));    //打印结果是3
	printf("%d\n", strlen(arr1));    //打印结果是3
	printf("%d\n", strlen(arr2));    //打印结果是15，是个随机值，因为strlen函数找不到\0，无法停下来

	return 0;
}*/



//数组的下标
/*int main()
{
	char arr[] = "abcdef";  //[a][b][c][d][e][f][\0]
	//打印元素d
	printf("%c\n", arr[3]);
	//打印出所有元素
	int i = 0;
	for (i = 0; i < strlen(arr); i++)
	{ 
		printf("%c \n", arr[i]);
	}
	int arr1[] = { 1,2,3,4,5,6,7,8,9,0 };
	int sz = sizeof(arr1) / sizeof(arr1[0]);
	int c = 0;
	for (c = 0; c < sz; c++)
	{
		printf("%d\n", arr1[c]);
	}


	return 0;
}*/



//一维数组在内存中的存储
int main()
{
	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
	int sz = sizeof(arr) / sizeof(arr[0]);
	int i = 0;
	for (i = 0; i < sz; i++)
	{
		printf("&arr[%d] = %p\n",i,&arr[i]);
	}
	/*
	&arr[0] = 00AFF9A0
	&arr[1] = 00AFF9A4
	&arr[2] = 00AFF9A8
	&arr[3] = 00AFF9AC
	&arr[4] = 00AFF9B0
	&arr[5] = 00AFF9B4
	&arr[6] = 00AFF9B8
	&arr[7] = 00AFF9BC
	&arr[8] = 00AFF9C0
	&arr[9] = 00AFF9C4
	*/

	return 0;
}