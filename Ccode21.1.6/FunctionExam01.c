#include <stdio.h>

//练习一、写一个函数判断是否是素数
/*is_prime(int x)
{
	//是素数返回1，不是返回0
	int n = 0;
	for (n = 2; n < x; n++)
	{
		if (x % n == 0)
			return 0;   //return 0比break的停止能力强、广泛
	}
	//来到这说明一定是n = x,不是素数
	return 1;
}   //函数在设计的时候，功能要单一干净，要独立性/可复用性，尽量在函数中打印0、1，不要直接打印结果！！
int main()
{
	int i = 0;
	for (i = 0; i <= 100; i++)
	{
		//判断i是否为素数？
		if (is_prime(i) == 1)   //is_prime即判断素数的函数
			printf("%d ", i);
	}

	return 0;
}*/


//练习二、写一个函数，实现一个整型有序数组的二分查找（注意陷阱）
  //在一个有序数组中查找具体的某个数，如果找到了返回这个数的下标，没找到返回-1。
  //写函数的技巧:先写函数怎么用，再写函数怎么实现！
/*int binary_search(int arr[],int k)
{
	//算法的实现
	//折半查找，先找中间的元素1234（5）678910，再（8），再（9）如此。
	int sz = sizeof(arr) / sizeof(arr[0]);
	int left = 0;
	int right = sz - 1 ;

	while (left <= right)
	{
		int mid = (left + right) / 2;  //中间元素的下标
		if (arr[mid] < k)
		{
			left = mid - 1;
		}
		else if (arr[mid] > k)
		{
			right = mid - 1;
		}
		else
		{
			return mid;  //相等的情况，即找到了
		}
	}
}*****这样的写法会有一个大问题：就是数组传参进去后，内部不能再用sizeof的方式算元素个数了！
这里的数组只是一份临时拷贝，为了避免浪费，只是传进去一份数组首元素的地址！！
本质上这个arr只是一个指针！！
*/
//正确的写法：
int binary_search(int arr[], int k,int sz)
{
	//算数组的长度的程序，写到函数外面就可以避免
	int left = 0;
	int right = sz - 1;

	while (left <= right)
	{
		int mid = (left + right) / 2;  
		if (arr[mid] < k)
		{
			left = mid - 1;
		}
		else if (arr[mid] > k)
		{
			right = mid - 1;
		}
		else
		{
			return mid; 
		}
	}
	return -1;
}
int main()
{
	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
	int k = 7;
	int sz = sizeof(arr) / sizeof(arr[0]);
	int ret = binary_search(arr, k, sz);
	if (ret == -1)
	{
		printf("找不到指定的数字\n");
	}
	else
	{
		printf("找到了，下标是：%d\n", ret);
	}

	return 0;
}

//写一个函数，每调用一次这个函数，将num的值增加1
/*
void Add(int *p)
{
	(*p)++;     //*不能写成*p++，因为++优先级较高，会成为*(p++)


}int main()
{
	int num = 0;
	Add(&num);
	printf("num = %d\n",num);
	Add(&num);
	printf("num = %d\n",num);
	Add(&num);
	printf("num = %d\n",num);
	return 0;
}


*/