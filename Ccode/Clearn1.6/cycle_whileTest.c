#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	/*int i = 1;
	while (i <= 10) 
	{
		if (i == 5)
			continue;   //continue（跳过/终止本次循环）输出1234，但程序没有结束，陷入了死循环了，5被拿去一直和if (i == 5)比较
		printf("%d\n", i);
		i++;
	}*/


	/*int ch = 0;
	while ((ch = getchar()) != EOF)  //EOF:end of file -> -1   getchar:接收键盘输入
	{
		putchar(ch);//输出结果就是输入的值。
	}*/


	/*int ret = 0;
	char password[20] = { 0 };
	printf("请输入密码:>");
	scanf("%s", password);  //输入密码，并存放到password数组中
	printf("请确认(Y/N):>");
	ret = getchar();  //Y/N
	if (ret == 'Y')
	{
		printf("确认成功\n");
	}
	else
	{
		printf("放弃确认\n");
	}    //结果输出为“放弃确认”，解答见画图    修改见下*/


	/*int ret = 0;
	char password[20] = { 0 };
	printf("请输入密码:>");
	scanf("%s", password);  //输入密码，并存放到password数组中
	//缓冲区还剩一个'\n'
	//读取一下'\n'
	getchar();   //这个getchar可以把'\n'读走
	printf("请确认(Y/N):>");
	ret = getchar();  //Y/N
	if (ret == 'Y')
	{
		printf("确认成功\n");
	}
	else
	{
		printf("放弃确认\n");
	}*/
	
	
	//还可以用循环的方法解决这个问题*****
	/*int ret = 0;
	int ch = 0;
	char password[20] = { 0 };
	printf("请输入密码:>");
	scanf("%s", password);
	while ((ch = getchar()) != '\n')    //判断ch是否是'\n'
	{
		;   //循环体里什么都不用做，所以直接写';'
	}
	printf("请确认(Y/N):>");
	ret = getchar(); 
	if (ret == 'Y')
	{
		printf("确认成功\n");
	}
	else
	{
		printf("放弃确认\n");
	}*/


	int ch = 0;
	while ((ch = getchar()) != EOF)
	{
		if (ch < '0' || ch > '9')
			continue;
		putchar(ch);  //只输出数字字符
	}

	return 0;
}