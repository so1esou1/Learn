#include <stdio.h>
int main()
{
//if���ʾ����


	/*int age = 10;
	if (age < 18)//С��18��
	{printf("δ����\n"); 
	printf("����̸����\n");
	}    //�����ӡ�����Ļ��ǵ�Ҫ�Ӵ����ţ�����飬һ�������ž���һ������飩
		
	else {
		if (age >= 18 && age < 23) //18��23
			printf("����\n");
		else if (age >= 28 && age < 50) //28��50
			printf("׳��\n");
		else if (age >= 50 && age < 90)  //50��90��
			printf("����\n");
		else                            //����90��
			printf("�ϲ���\n");
	}*/


	/*int a = 0;
	int b = 2;
	if (a == 1)
		if (b == 2)
			printf("hehe\n");
	else
		printf("haha\n");
	//��δ���û���κν����*else���������ifƥ��*������a���ж��ˣ�bû���жϣ�elseҲû����
	��Ҫ���haha�������������*/
	

	/*int a = 0;
	int b = 2;
	if (a == 1)
	{
		if (b == 2)
			printf("hehe\n");
	}                   //ע������ʹ�úô����Ŵ����
		else
			printf("haha\n");  //haha
    */


	/*int num = 4;
	if (num = 5)   //"="�Ǹ�ֵ�����ж���ȣ��������ս�����ǡ��Ǻǡ�
	{
		printf("�Ǻ�\n");
	}
	//Ϊ�˱�������д��=�ŵ������Ժ��������д��
	if(5 == num)   ����д�������׳���    */


	//�ж�һ�����Ƿ�������
	/*int i = 1;
	while (i < 100)
	{
		if (i % 2 == 1)
			printf("%d", i);
		i++;
	}
	��һ��д����δ�õ��ж�
	int i = 1;
	while (i < 100)
	{
		printf("%d", i);
		i += 2;
	}*/



//switch���ʾ����
	/*int day = 0;
	scanf("%d", &day);
	if (1 == day)
		printf("����1\n");
	else if (2 == day)
		printf("����2\n");
	else if(3 == day)
		printf("����3\n");
	else if (4 == day)
		printf("����4\n");
	................��if���д�Ļ�̫�����ˣ�switch��ר������ʵ�����ֶ��֧������*/


	/*int day = 0;
	scanf_s("%d", &day);
	switch (day)  //һ��Ҫ�����ͣ��������͵Ļᱨ����java���ǲ�����
	{
	case 1:       //case��һ��Ҫ�����ͳ��������Ǳ��������ʽ
		printf("����1\n");
		break;
	case 2:
		printf("����2\n");   
		break;
	case 3:
		printf("����3\n");
		break;
	case 4:
		printf("����4\n");
		break;
	case 5:
		printf("����5\n");
		break;
	case 6:
		printf("����6\n");
		break;
	case 7:
		printf("������\n");
		break;
	default:
		printf("�������\n");   //�����������ϵ�case��ʱ��ʹ��default���
		//û��break�Ļ��ᷢ����͸���󣡣�����
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
			n++;  //��䲻ִ��
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
	printf("m = %d,n = %d\n", m, n);   //�����m = 5,n = 3

	return 0;
}