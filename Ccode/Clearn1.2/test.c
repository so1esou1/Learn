#define _CRT_SECURE_NO_WARNINGS 1   //Դ�ļ��ĵ�һ�У�������仰������ͨ��ĳЩ����
#include<stdio.h>
#include <String.h>
int main()
{
	/*int num1 = 0;
	int num2 = 0;
	int sum = 0;
	scanf("%d%d", &num1, &num2);  //ʹ������һ���Ĳ���ȫ�ԣ�VS��������͵ĺ����ṩ�����е�д����������������ƽ̨
	sum = num1 + num2;
	printf("sum = %d\n", sum);
	return 0;*/


	/*
	���泣��
	3;
	100;
	3.14
	*/
	
	//const-�����ԣ��ڱ���ǰ�����֮�����ٱ���
	//const int num = 4;

	//ö�ٳ���


	//if���ʾ��
	/*int input = 0;
	printf("�������\n");
	printf("��Ҫ�ú�ѧϰ��(1/0)>:");
	scanf("%d", &input);   //1/0
	if (input == 1)
		printf("��offer\n");
	else
		printf("������\n");*/

	//while���ʾ��
	int line = 0;
	printf("�������\n");

	while (line < 20000)
	{
		printf("��һ�д���%d\n",line);
		line++;
	}
	if(line >= 20000)
	printf("��offer\n");



	return 0;
}