#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <windows.h>
#include <stdlib.h>

//int main()
//{
	//forѭ����ʹ�õ�����ѭ��
	//������forѭ������Ļ�ϴ�ӡ1-100������
	/*int i = 0;  //��ʼ��
//���¶�Ӧ ��ʼ�� �ж�   ����      ִ��˳�򣺳�ʼ��->�ж�->continue���->����   ��while��䲻ͬ�������continue���ᵼ����ѭ��
	for (i = 1; i <= 10; i++)
	{
		if (i == 5)
			continue;
		printf("%d\n", i);//��Ϊִ��˳��������������1234678910
	}*/


	/*int i = 0;
	for (i = 0; i < 10; i++)
	{
		if (i = 5)  //�ٴ�ע�⣺�����Ǳ��ĳ�5�������жϵ���5��������������ѭ����������ò�Ҫ��forѭ�����ڸı�ѭ����������ֹѭ��ʧȥ����
			printf("haha\n");
		printf("hehe\n");
	}*/
	
	
	/*int arr[10] = { 1,2,3,4,5,6,7,8,9,10 };
	int i = 0;
	for (i = 0; i < 10; i++)   //����ʹ������Ǳ����䣨i=0�����ұ��ǿ������д��(i < 10),�պ�10��ѭ������ӡ��10��Ԫ��
	{
		printf("%d", arr[i]);
	}*/


	//forѭ����һЩ���֣�
	/*for (;;)
	{
		printf("hehe\n");    //���hehe����ѭ��
		//forѭ����ʼ�����������ж϶�����ʡ�ԣ�����ж�������ʡ�ԣ����Ǻ�Ϊ�棡������
		//������Ƿǳ����������鲻Ҫ���ʡ����ش���
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
	//�ж���δ����������hehe��
	����10����jѭ��10�Σ�������Ϊû��j=0���Ͳ�����£��ص���һ��ѭ����j��=10�������ٴ�ѭ�����ͺ��ѽ��壩����������ʡ�Ի���������벻���ĺ��
	}
	*/
	/*int x, y;
	for (x = 0, y = 0; x < 2 && y < 5; ++x, y++)
	{
		printf("hehe\n");
		//�������hehe��
		//2��hehe
	}*/
	//�����⣺
	/*int i = 0;
	int k = 0;
	for (i = 0, k = 0; k = 0; i++, k++)
		k++;   //ѭ�����Σ�
	//ѭ��0�Σ�k�Ǹ�ֵ��䲻���ж���䣬������ִ��
	*/



	//do...whileѭ����
	//��do...while��ӡ1-10�����֣�
	/*int i = 1;
	do 
	{
		printf("%d ", i);
		i ++;
	} 
	while (i <= 10);
	*/

	//����1��10�Ľ׳�
	/*int i = 0;
	int n = 0;
	int ret = 1;  //���ܸ�0�����������Ϊ0
	scanf("%d", &n);  
	for (i = 1; i <= n; i++)
	{
		ret = ret * i;
	}
	printf("ret = %d\n", ret);*/


	//����1��10�׳˵ĺ�
	//���������Ҫ��ϸ˼���£�����
	/*int i = 0;
	int n = 0;
	int ret = 1;
	int sum = 0;
	for (n = 1; n <= 10; n++)
	{
		ret = 1;  
		for (i = 1; i <= n; i++)//����д�����յó�����Ľ������Ϊÿ�����ڲ���ѭ����i��ret����ѭ����Σ�
								//ret1 = 1*1;ret2 = 1*1*2;ret3 = 2*1*2*3..........
								//��ˣ�Ҫ��retÿ�ζ�Ӧ�ô���ʼλ�ÿ�ʼ����1��ʼ����ˣ�Ҫ���Ϸ�ָ��λ�ø�ret��ֵ��1
								//ֻ�������Ų�����һ���ۼƵ�Ч����������
		{
			ret = ret * i;
		}
		//n�Ľ׳�
		//�ٽ�n�Ľ׳��ۻ�����һ��
		sum = sum + ret;
	}
	printf("sum = %d\n", sum);*/

	//�Ż���һ������
	/*int n = 0;
	int ret = 1;
	int sum = 0;
	for (n = 1; n <= 3; n++)
	{
		ret = ret * n;
		sum = sum + ret;
	}
	printf("sum = %d\n", sum);*/


	//*****���ַ��㷨����һ��Ԫ�صķ���ʾ�������˼�룺
	/*int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
	int k = 6;//����Ԫ��Ϊ6

	int sz = sizeof(arr) / sizeof(arr[0]); //����Ԫ�ظ���
	int left = 0;  //���±�
	int right = sz - 1; //���±�

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
			printf("�ҵ��ˣ��±��ǣ�%d\n", mid);
			break;
		}
	}
	if (left > right)
	{
		printf("�Ҳ���\n");
	}*/



	//��дһ�δ��룬��ʾ����ַ��������ƶ������м���(���вο�����)
	//��ӡwelcome to bit!!!!!!
	//Ҫ����w###############!����we##################!!����wel################!!!���������ơ�����
	//˼�룺��welcome to bit!!!!!!Ū�����飬һ��һ�����#���ţ�arr1Ԫ�ظ�ֵ��arr2��
	/*char arr1[] = "welcome to bit!!!!!!";
	char arr2[] = "####################";
	int left = 0;
	//int right = sizeof(arr1)/sizeof(arr1[0]) - 2;  //������һ��������±�,-2����Ϊchar�����һ�����ص��ַ�"\n"
	//�ú�����д����
	int right = strlen(arr1) - 1;
	
	while (left <= right)//ѭ��������������left��right��û������Ԫ����
	{
		arr2[left] = arr1[left];
		arr2[right] = arr1[right];
		printf("%s\n", arr2);
		//ÿ��ӡһ����Ϣһ��
		Sleep(1000);
		//��Ϣһ������Ļ���
		system("cls");//ִ��ϵͳ����ĺ���,cls�������Ļ
		left++;  //��λ
		right--;
	}*/


	//ģ���û���¼������ֻ�ܵ�¼���Σ������������������˳�����
	/*int i = 0;
	char password[20] = { 0 };
	for (i = 0; i < 3; i++)
	{
		printf("���������룺>");
		scanf("%s",password );
		//if (password == "123456")  //"=="���������Ƚ������ַ����Ƿ���ȣ�Ӧ����һ���⺯��-strcmp
		if (strcmp(password,"123456") == 0)
		{
			printf("��¼�ɹ�\n");
			break;
		}
		else
		{
			printf("�������\n");
		}
	}
	if (i == 3)
	{
		printf("��������������˳�����\n");
	}*/


//��дһ��������1-100�����������г��ֶ��ٸ�����9(��λΪ9��%10��һ����9��ʮλΪ9����/10һ����9)
/*	int i = 0;
	int count = 0;
	for (i = 0; i < 100; i++) 
	{
		if (i % 10 == 9)
			count++;
		if (i / 10 == 9)
			count++;
	}
	printf("count = %d\n", count);  //20��9��99�������9���������Σ�*/


//���������ӣ�1/1 + 1/2 - 1/3 +��-������+1/99 - 1/ 100��ֵ
/*	int i = 0;
	int sum = 0;
	for (i = 1; i <= 100; i++)
	{
		sum += 1 / i;
	}
	printf("%d\n", sum);//�����1��������е�/����ѧ�е�/������ͬ������������*/
	//Ҫ����д��	
	/*int i = 0;
	double sum = 0.0;
	int flag = 1;
	for (i = 1; i <= 100; i++)
	{
		sum += flag * 1.0 / i;//����д�����ű��ж�ΪС����������
		flag = - flag;
	}
	printf("%lf\n", sum);   //0.688172*/



	//дһ�г˷��ھ���
	//1*1=1
	//2*1=2 2*2=4
	//3*1=3 3*2=6 3*3=9
	/*int i = 0;
	//ȷ����ӡ9��
	for (i = 1; i <= 9; i++)
	{
		//��ӡһ��
		int j = 1;
		for (j = 1; j <= i; j++)
		{
			printf("%d * %d = %2d ", i, j, i * j);  //2��ʾ��ӡ��λ���ǵÿո񣬲�Ȼ������
		}
		printf("\n");
	}*/




	//***�һ����������Ϸ�����Ի�����һ����������������������ƥ�䣬�¶�/�´����Զ����
#include <stdlib.h>
#include <time.h>
//rand����0-32767֮��������
void game()
{
	//1������һ�������
	int ret = 0;
	int guess = 0;  //��ȡ�µ���
	ret = rand()%100+1;   //����������ĺ���,α�����������Ѿ��趨���ˡ��ٽ������޶���1-100
	//printf("%d\n", ret);

	//2��������
	while (1)
	{
		printf("�������:>");
		scanf("%d", &guess);
		if (guess > ret)
		{
			printf("�´���\n");
		}
		else if (guess < ret)
		{
			printf("��С��\n");
		}
		else
		{
			printf("��ϲ�㣬�¶��ˣ�\n");
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
	srand((unsigned int)time(NULL));  //���randα���������,����һֱ�����仯��ʱ�����γ������,��ʱ������������������������
		do
		{
			menu();
			printf("��ѡ��>:");
			scanf("%d", &input);
			switch (input)
			{
			case 1:
				game();  //��������Ϸ�Ĺ���
				break;
			case 0:
				printf("�˳���Ϸ\n");
				break;
			default:
				printf("ѡ�����\n");
				break;
			}
		} while (input);      //do...whileѭ������ִ��һ��

	return 0;
}