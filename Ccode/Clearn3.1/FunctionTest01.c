#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//дһ���ӷ��ĺ���
int Add(int x, int y)
{
	int z = 0;
	z = x + y;
	return z;
}
int main() {
	int a = 10;
	int b = 20;
	int sum = Add(a, b);
	printf("%d\n", sum);

	return 0;
}