#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main()

{
	//�����������ĺ�
	int num1 = 0;
	int num2 = 0;
	int sum = 0;
	//��������-ʹ�����뺯��scanf
	scanf("%d%d", &num1, &num2);  //&��ȡ��ַ����
	//����������ΪC���Թ涨������Ҫ�����ڵ�ǰ��������ǰ�棬�������汨��
	//int sum = num1 + num2;
	sum = num1 + num2;
	printf("sum = %d\n", sum);

	return 0;

}