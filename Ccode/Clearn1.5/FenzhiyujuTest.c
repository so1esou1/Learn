#include <stdio.h>
int main()
{
//if语句示例：


	/*int age = 10;
	if (age < 18)//小于18岁
	{printf("未成年\n"); 
	printf("不能谈恋爱\n");
	}    //这里打印两个的话记得要加大括号（代码块，一个大括号就是一个代码块）
		
	else {
		if (age >= 18 && age < 23) //18到23
			printf("青年\n");
		else if (age >= 28 && age < 50) //28到50
			printf("壮年\n");
		else if (age >= 50 && age < 90)  //50到90岁
			printf("老年\n");
		else                            //大于90岁
			printf("老不死\n");
	}*/


	/*int a = 0;
	int b = 2;
	if (a == 1)
		if (b == 2)
			printf("hehe\n");
	else
		printf("haha\n");
	//这段代码没有任何结果，*else会找最近的if匹配*，所以a被判断了，b没被判断，else也没启动
	想要输出haha，见下面的例子*/
	

	/*int a = 0;
	int b = 2;
	if (a == 1)
	{
		if (b == 2)
			printf("hehe\n");
	}                   //注意这里使用好大括号代码块
		else
			printf("haha\n");  //haha
    */


	/*int num = 4;
	if (num = 5)   //"="是赋值不是判断相等，所以最终结果还是“呵呵”
	{
		printf("呵呵\n");
	}
	//为了避免这种写错=号的现象，以后最好这样写：
	if(5 == num)   反着写，不容易出错    */


	//判断一个数是否是奇数
	/*int i = 1;
	while (i < 100)
	{
		if (i % 2 == 1)
			printf("%d", i);
		i++;
	}
	另一种写法，未用到判断
	int i = 1;
	while (i < 100)
	{
		printf("%d", i);
		i += 2;
	}*/



//switch语句示例：
	/*int day = 0;
	scanf("%d", &day);
	if (1 == day)
		printf("星期1\n");
	else if (2 == day)
		printf("星期2\n");
	else if(3 == day)
		printf("星期3\n");
	else if (4 == day)
		printf("星期4\n");
	................用if语句写的话太繁琐了，switch是专门用来实现这种多分支的语句的*/


	/*int day = 0;
	scanf_s("%d", &day);
	switch (day)  //一定要是整型，其他类型的会报错，在java中是布尔型
	{
	case 1:       //case后一定要跟整型常量（不是变量）表达式
		printf("星期1\n");
		break;
	case 2:
		printf("星期2\n");   
		break;
	case 3:
		printf("星期3\n");
		break;
	case 4:
		printf("星期4\n");
		break;
	case 5:
		printf("星期5\n");
		break;
	case 6:
		printf("星期6\n");
		break;
	case 7:
		printf("星期天\n");
		break;
	default:
		printf("输入错误\n");   //当不符合以上的case的时候，使用default语句
		//没有break的话会发生穿透现象！！！！
	}*/
	

	int n = 1;
	int m = 2;
	switch (n)
	{
	case 1:m++;   //m = 3
	case 2:n++;   //n = 2
	case 3:
		switch (n)
		{
		case 1:
			n++;  //这句不执行
		case 2:
			m++;   //m = 4
			n++;   //n = 3
			break;
		}
	case 4:m++;   //m = 5
		break;
	default:
		break;
	}
	printf("m = %d,n = %d\n", m, n);   //结果是m = 5,n = 3

	return 0;
}