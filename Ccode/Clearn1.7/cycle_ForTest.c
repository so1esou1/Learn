#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <windows.h>
#include <stdlib.h>

//int main()
//{
	//for循环是使用得最多的循环
	//需求：用for循环在屏幕上打印1-100的数字
	/*int i = 0;  //初始化
//以下对应 初始化 判断   调整      执行顺序：初始化->判断->continue语句->调整   与while语句不同，这里的continue不会导致死循环
	for (i = 1; i <= 10; i++)
	{
		if (i == 5)
			continue;
		printf("%d\n", i);//因为执行顺序，最终输出结果是1234678910
	}*/


	/*int i = 0;
	for (i = 0; i < 10; i++)
	{
		if (i = 5)  //再次注意：这里是被改成5，不是判断等于5！！！！最后会死循环，所以最好不要在for循环体内改变循环变量，防止循环失去控制
			printf("haha\n");
		printf("hehe\n");
	}*/
	
	
	/*int arr[10] = { 1,2,3,4,5,6,7,8,9,10 };
	int i = 0;
	for (i = 0; i < 10; i++)   //尽量使用左边是闭区间（i=0），右边是开区间的写法(i < 10),刚好10次循环、打印、10个元素
	{
		printf("%d", arr[i]);
	}*/


	//for循环的一些变种：
	/*for (;;)
	{
		printf("hehe\n");    //输出hehe的死循环
		//for循环初始化、调整、判断都可以省略，如果判断条件被省略，就是恒为真！！！！
		//如果不是非常熟练，建议不要随便省略相关代码
	}*/
	/*
	int i = 0;
	int j = 0;
	for(; i < 10 ; i++)
	{
		for(; j < 10;j ++)
		{
			printf("hehe\n");
		}
	//判断这段代码输出几个hehe？
	答案是10个，j循环10次，但是因为没有j=0，就不会更新，回到第一个循环后，j仍=10，不能再次循环（就很难讲清），这就是随便省略会带来的意想不到的后果
	}
	*/
	/*int x, y;
	for (x = 0, y = 0; x < 2 && y < 5; ++x, y++)
	{
		printf("hehe\n");
		//输出几个hehe？
		//2个hehe
	}*/
	//笔试题：
	/*int i = 0;
	int k = 0;
	for (i = 0, k = 0; k = 0; i++, k++)
		k++;   //循环几次？
	//循环0次，k是赋值语句不是判断语句，根本不执行
	*/



	//do...while循环：
	//用do...while打印1-10的数字：
	/*int i = 1;
	do 
	{
		printf("%d ", i);
		i ++;
	} 
	while (i <= 10);
	*/

	//计算1到10的阶乘
	/*int i = 0;
	int n = 0;
	int ret = 1;  //不能给0，否则相乘仍为0
	scanf("%d", &n);  
	for (i = 1; i <= n; i++)
	{
		ret = ret * i;
	}
	printf("ret = %d\n", ret);*/


	//计算1到10阶乘的和
	//这个例子需要仔细思考下！！！
	/*int i = 0;
	int n = 0;
	int ret = 1;
	int sum = 0;
	for (n = 1; n <= 10; n++)
	{
		ret = 1;  
		for (i = 1; i <= n; i++)//这种写法最终得出错误的结果，因为每次在内部的循环，i、ret都会循环多次，
								//ret1 = 1*1;ret2 = 1*1*2;ret3 = 2*1*2*3..........
								//因此，要将ret每次都应该从起始位置开始，从1开始，因此，要在上方指定位置给ret赋值成1
								//只有这样才不会有一个累计的效果！！！！
		{
			ret = ret * i;
		}
		//n的阶乘
		//再将n的阶乘累积加在一起
		sum = sum + ret;
	}
	printf("sum = %d\n", sum);*/

	//优化上一个程序：
	/*int n = 0;
	int ret = 1;
	int sum = 0;
	for (n = 1; n <= 3; n++)
	{
		ret = ret * n;
		sum = sum + ret;
	}
	printf("sum = %d\n", sum);*/


	//*****二分法算法查找一个元素的方法示例，理解思想：
	/*int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
	int k = 6;//查找元素为6

	int sz = sizeof(arr) / sizeof(arr[0]); //计算元素个数
	int left = 0;  //左下标
	int right = sz - 1; //右下表

	while (left <= right)
	{
		int mid = (left + right) / 2;
		if (arr[mid] > k)
		{
			right = mid - 1;
		}
		else if (arr[mid] < k)
		{
			left = mid + 1;
		}
		else
		{
			printf("找到了，下标是：%d\n", mid);
			break;
		}
	}
	if (left > right)
	{
		printf("找不到\n");
	}*/



	//编写一段代码，演示多个字符从两端移动，向中间汇聚(很有参考意义)
	//打印welcome to bit!!!!!!
	//要求先w###############!，再we##################!!，再wel################!!!，依此类推。。。
	//思想：把welcome to bit!!!!!!弄成数组，一次一次替代#符号，arr1元素赋值到arr2上
	/*char arr1[] = "welcome to bit!!!!!!";
	char arr2[] = "####################";
	int left = 0;
	//int right = sizeof(arr1)/sizeof(arr1[0]) - 2;  //算出最后一个代码的下标,-2是因为char最后有一个隐藏的字符"\n"
	//用函数的写法：
	int right = strlen(arr1) - 1;
	
	while (left <= right)//循环结束的条件是left和right间没有其他元素了
	{
		arr2[left] = arr1[left];
		arr2[right] = arr1[right];
		printf("%s\n", arr2);
		//每打印一次休息一秒
		Sleep(1000);
		//休息一秒后把屏幕清空
		system("cls");//执行系统命令的函数,cls是清空屏幕
		left++;  //移位
		right--;
	}*/


	//模拟用户登录，并且只能登录三次，如果三次输入错误，则退出程序
	/*int i = 0;
	char password[20] = { 0 };
	for (i = 0; i < 3; i++)
	{
		printf("请输入密码：>");
		scanf("%s",password );
		//if (password == "123456")  //"=="不能用来比较两个字符串是否相等，应该用一个库函数-strcmp
		if (strcmp(password,"123456") == 0)
		{
			printf("登录成功\n");
			break;
		}
		else
		{
			printf("密码错误\n");
		}
	}
	if (i == 3)
	{
		printf("三次密码均错误，退出程序\n");
	}*/


//编写一个程序，数1-100间所有整数中出现多少个数字9(个位为9，%10则一定余9；十位为9，则/10一定商9)
/*	int i = 0;
	int count = 0;
	for (i = 0; i < 100; i++) 
	{
		if (i % 10 == 9)
			count++;
		if (i / 10 == 9)
			count++;
	}
	printf("count = %d\n", count);  //20个9（99这个数中9出现了两次）*/


//计算分数相加：1/1 + 1/2 - 1/3 +。-。。。+1/99 - 1/ 100的值
/*	int i = 0;
	int sum = 0;
	for (i = 1; i <= 100; i++)
	{
		sum += 1 / i;
	}
	printf("%d\n", sum);//结果是1，计算机中的/与数学中的/有所不同！！！！！！*/
	//要这样写：	
	/*int i = 0;
	double sum = 0.0;
	int flag = 1;
	for (i = 1; i <= 100; i++)
	{
		sum += flag * 1.0 / i;//这种写法最后才被判断为小数！！！！
		flag = - flag;
	}
	printf("%lf\n", sum);   //0.688172*/



	//写一行乘法口诀表
	//1*1=1
	//2*1=2 2*2=4
	//3*1=3 3*2=6 3*3=9
	/*int i = 0;
	//确定打印9行
	for (i = 1; i <= 9; i++)
	{
		//打印一行
		int j = 1;
		for (j = 1; j <= i; j++)
		{
			printf("%d * %d = %2d ", i, j, i * j);  //2表示打印两位，记得空格，不然不美观
		}
		printf("\n");
	}*/




	//***搭建一个猜数字游戏，电脑会生成一个随机数，与我们想的数字匹配，猜对/猜错，可以多次玩
#include <stdlib.h>
#include <time.h>
//rand生成0-32767之间的随机数
void game()
{
	//1、生成一个随机数
	int ret = 0;
	int guess = 0;  //获取猜的数
	ret = rand()%100+1;   //生成随机数的函数,伪随机，随机数已经设定好了。再将数字限定在1-100
	//printf("%d\n", ret);

	//2、猜数字
	while (1)
	{
		printf("请猜数字:>");
		scanf("%d", &guess);
		if (guess > ret)
		{
			printf("猜大了\n");
		}
		else if (guess < ret)
		{
			printf("猜小了\n");
		}
		else
		{
			printf("恭喜你，猜对了！\n");
			break;
		}
	}

}
void menu()
{
		printf("**************************\n");
		printf("**1 . play      0 . exit**\n");
		printf("**************************\n");
}
int main()
	{
	int input = 0;
	srand((unsigned int)time(NULL));  //解决rand伪随机的问题,输入一直发生变化的时间来形成随机数,“时间戳”来设置随机数的随机起点
		do
		{
			menu();
			printf("请选择>:");
			scanf("%d", &input);
			switch (input)
			{
			case 1:
				game();  //猜数字游戏的过程
				break;
			case 0:
				printf("退出游戏\n");
				break;
			default:
				printf("选择错误\n");
				break;
			}
		} while (input);      //do...while循环至少执行一次

	return 0;
}