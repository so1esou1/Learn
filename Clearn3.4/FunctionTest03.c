#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>

//�ݹ������
//�������ظ�����һ����




//��n�Ľ׳�
/*int Fac1(int n)  //����ѭ���ķ�ʽ
{
	int i = 0;
	int ret = 1;
	for (i = 1; i <= n; i++)
	{
		ret *= i;
	}
	return ret;
}
int Fac2(int n)          //�ݹ�ķ�ʽ      n�Ľ׳˵�ԭ��n*Fac(n - 1)
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
	//ret = Fac1(n);   //��ѭ���ķ�ʽ��ʵ��
	ret = Fac2(n);  //ʹ�õݹ�ķ�ʽ
	printf("%d\n", ret);

	return 0;
}*/



//쳲��������У�ǰ������֮����ڵ�������������     1 1 2 3 5 8 13 21 34 55.....
//���n��쳲���������
/*int Fib(int n)     //�ݹ��д��
{
	if (n <= 2)
		return 1;
	else
		return Fib(n - 1) + Fib(n - 2);
}     //*���ִ���д��Ч��̫���ˣ���ֵһ�����Ҫ�����ǰ���㡣�����д��ѭ���ķ�ʽ
*/
/*int Fib(int n)       //ѭ����д��
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
	//��д������ô�ã���д����������д����ʽ����TDD-������������
	ret = Fib(n);
	printf("ret = %d\n", ret);
	return 0;
}*/


//�ݹ���ܴ���ջ��������󣡣���
/*ѡ��ݹ��ѭ�������ݣ�
 ���ȿ����ַ�������д���ݹ��ջ���ʱ��ѭ��
 */ 


//�ݹ�ջ���ʾ����
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

//�ݹ�����⣺��ŵ�����⡢������̨������