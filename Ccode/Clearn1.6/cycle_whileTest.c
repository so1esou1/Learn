#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	/*int i = 1;
	while (i <= 10) 
	{
		if (i == 5)
			continue;   //continue������/��ֹ����ѭ�������1234��������û�н�������������ѭ���ˣ�5����ȥһֱ��if (i == 5)�Ƚ�
		printf("%d\n", i);
		i++;
	}*/


	/*int ch = 0;
	while ((ch = getchar()) != EOF)  //EOF:end of file -> -1   getchar:���ռ�������
	{
		putchar(ch);//���������������ֵ��
	}*/


	/*int ret = 0;
	char password[20] = { 0 };
	printf("����������:>");
	scanf("%s", password);  //�������룬����ŵ�password������
	printf("��ȷ��(Y/N):>");
	ret = getchar();  //Y/N
	if (ret == 'Y')
	{
		printf("ȷ�ϳɹ�\n");
	}
	else
	{
		printf("����ȷ��\n");
	}    //������Ϊ������ȷ�ϡ���������ͼ    �޸ļ���*/


	/*int ret = 0;
	char password[20] = { 0 };
	printf("����������:>");
	scanf("%s", password);  //�������룬����ŵ�password������
	//��������ʣһ��'\n'
	//��ȡһ��'\n'
	getchar();   //���getchar���԰�'\n'����
	printf("��ȷ��(Y/N):>");
	ret = getchar();  //Y/N
	if (ret == 'Y')
	{
		printf("ȷ�ϳɹ�\n");
	}
	else
	{
		printf("����ȷ��\n");
	}*/
	
	
	//��������ѭ���ķ�������������*****
	/*int ret = 0;
	int ch = 0;
	char password[20] = { 0 };
	printf("����������:>");
	scanf("%s", password);
	while ((ch = getchar()) != '\n')    //�ж�ch�Ƿ���'\n'
	{
		;   //ѭ������ʲô��������������ֱ��д';'
	}
	printf("��ȷ��(Y/N):>");
	ret = getchar(); 
	if (ret == 'Y')
	{
		printf("ȷ�ϳɹ�\n");
	}
	else
	{
		printf("����ȷ��\n");
	}*/


	int ch = 0;
	while ((ch = getchar()) != EOF)
	{
		if (ch < '0' || ch > '9')
			continue;
		putchar(ch);  //ֻ��������ַ�
	}

	return 0;
}