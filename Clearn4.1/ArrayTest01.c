#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>

//һά����Ĵ�������һЩ��������ʾ����
/*int main()
{
	//����-�������10��
	int arr[10];  //��������ǳ���
	char arr2[5];
	
	//����ĳ�ʼ�����ڴ��������ͬʱ�����������һЩ�����ʼֵ����ʼ����
	int arr3[5] = { 1,2,3 };        //����ȫ��ʼ����ʣ�µ�Ԫ��Ĭ�ϵĳ�ʼ��Ϊ0
	char arr4[5] = { 'a','b' };
	char arr5[5] = { "ab" };    //ע�⣡�������������a��b��\0������Ԫ�أ��������Ԫ����Ĭ����0.��˽������3��0
	char arr6[5] = { 'a',98 };  //�������98������ĸb�ǿ��Ե�
	char arr7[] = { "abcdef" };   //û�и������С�ģ�����ݳ�ʼ����ֵ�Զ���һ�����ȣ������7��Ԫ��

	printf("%d\n", sizeof(arr7));      //��ӡ�����7��sizeof�Ǽ���arr7��ռ�ռ�Ĵ�С
	printf("%d\n", strlen(arr7));      //��ӡ�����6��strlen�����ַ������ȣ��ҵ�\0��ֹͣ�ˣ���\0�����ȥ
	//sizeof��strlenû��ʲô������strlenֻ�����ַ������ȣ��ǿ⺯������Ҫ����ͷ�ļ�
	//sizeof�Ǽ�����������顢���͵Ĵ�С����λ���ֽڣ��ǲ�����

	return 0;
}*/


//strlen��sizeof�ıȽ�ʾ��
/*int main()
{
	char arr1[] = "abc";
	char arr2[] = { 'a','b','c' };
	printf("%d\n", sizeof(arr1));    //��ӡ�����4
	printf("%d\n", sizeof(arr2));    //��ӡ�����3
	printf("%d\n", strlen(arr1));    //��ӡ�����3
	printf("%d\n", strlen(arr2));    //��ӡ�����15���Ǹ����ֵ����Ϊstrlen�����Ҳ���\0���޷�ͣ����

	return 0;
}*/



//������±�
/*int main()
{
	char arr[] = "abcdef";  //[a][b][c][d][e][f][\0]
	//��ӡԪ��d
	printf("%c\n", arr[3]);
	//��ӡ������Ԫ��
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



//һά�������ڴ��еĴ洢
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