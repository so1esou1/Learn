#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
//��ַ��http://cplusplus.com/     http://en.cppreference.com
//�⺯����ѧϰһ���ǿ��ĵ�

//дһ���ӷ��ĺ���
/*int Add(int x, int y)
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
}*/



	//memset �ڴ����ú���
/*int main()
{
	char arr[] = "hello world";  //��hello�����*����
	memset(arr, '*', 5);
	printf("%s\n", arr);
	//��֤Դͷ�����㹻������Ȼ���������BUG

	return 0;
}*/


//����ѧ���Զ��庯����ʹ�ã������Լ����ú���
//һ�������Ļ�����ɣ�����
/*ret_type fun_name(paral, *)
{
	statement;  //���������壬������������ôʵ�ֵ�
}    //ret_type:��������    fun_name��������    paral����������*/


//дһ���������ҳ������������ֵ
//���庯��
/*int get_max(int x, int y)   //int ��ʾ�������͵�����
{
	if (x > y)
		return x;
	else
		return y;

}
int main()
{
	int a = 10;
	int b = 20;
	//������ʹ�ó���
	int max = get_max(a,b);  //����������.a����x��b����y�����бȽ�
	printf("max = %d\n", max);

	return 0;
}*/


//дһ�������������������ͱ���������
//��װһ������
/*void Swap1(int x,int y)   //void û�з���ֵ
{
	int temp = 0;
	temp = x;
	x = y;
	y = temp;
	//����д�����У����ս��a��b��û�еõ���������Ҫ�����޸�(��ָ��ķ��������޸�)
	//***��ʵ�δ����βε�ʱ���β���ʵ��ʵ�ε�һ����ʱ���������βε��޸��ǲ���ı�ʵ�εģ�������
}*/
/*void Swap2(int* pa,int* pb)  //a�ĵ�ַ����pa��b�ĵ�ַ����pb��ͨ����ַ�Ĵ���ֵ
{
	int temp = 0;
	temp = *pa;
	*pa = *pb;
	*pb = temp;
}
int main()
{
	int a = 10;
	int b = 20;
	int temp = 0;
	
	//Swap1(a,b);
	//����swap2����
	Swap2(&a, &b);
	//��ʼ����
	/*temp = a;
	a = b;
	b = temp;   �����д��һ����������ȥ
	//��������
	printf("a = %d b = %d\n", a, b);
	return 0;
}*/



//���庯��
//�β�-��ʽ����
//*ʵ�Σ���ʵ���������Ĳ����������ǳ��������������ʽ�������ȣ������Ǻ������͵������ڱ���������ʱ����������ȷ����ֵ���Ա��ֵ�����βΡ�
//* �βΣ��������������еı�������Ϊ��ʽ����ֻ���ں��������õĹ��̲���ʵ�����������ڴ浥Ԫ����
//���Խ���ʽ��������ʽ����������������ɺ��Զ����٣����ֻ���ں����в���Ч
/*int get_max(int x, int y)
{
	if (x > y)
		return x;
	else
		return y;
}
int main()
{
	int a = 10;
	int b = 20;
	//������ʹ��
	int max = get_max(a, b);
	printf("max = %d\n", max);
	max = get_max(100, 300 - 1);
	max = get_max(100, get_max(3, 7));

	printf("max = %d\n", max);

	return 0;
}*/

/* ***�������õķ��ࣺ1����ֵ���ã��������βκ�ʵ�ηֱ�ռ�в�ͬ���ڴ�飬
���βε��޸Ĳ���Ӱ��ʵ�Ρ����Ժ�ֻ��ֵ�����иı亯������ĳЩ�����Ļ�����ʹ�ã�
2����ַ���ã��Ѻ����ⲿ�����������ڴ��ַ���ݸ�����������һ�ֵ��ú����ķ�ʽ��
�����ú����ͺ�����ߵı�����������������ϵ��Ҳ����
�����ڲ�����ֱ�Ӳ��������ⲿ�ı�����*/



//������Ƕ�׵��ú���ʽ����
//Ƕ�׵��ã�
/*void new_line()
{
	printf("hehe\n");
}
void three_line()
{
	int i = 0;
	for (i = 0; i < 3; i++)
	{
		new_line();
	}
}
int main()
{
	three_line();   //����������three_line()��three_line()����new_line
	return 0;
}*/

//��ʽ���ʣ���һ�������ķ���ֵ��Ϊ��һ�������Ĳ���
#include <string.h>
/*int main()
{
	char arr[20] = "hello";
	int ret = strlen(strcat(arr, "bit"));
	printf("%d\n", ret);
	return 0;
}*/
/*int main()
{
	printf("%d", printf("%d", printf("%d", 43)));
	return 0;
}   //�����ӡ�����4321�����������ӡ��printf����ֵ�Ǵ�ӡ���ַ��ĸ�����43->2->1*/



//��������:    ʹ��֮ǰ������������,ͨ�������Ͷ���ϲ���һ�𡣣���������һ��ŵ�ͷ�ļ�.h�У���������һ��ŵ�.cԴ�ļ��У�" #include"...""�������ã�
//��ģ���д��������ֹ�
int Add(int x, int y);  

int main()
{
	int a = 10;
	int b = 20;
	int sum = 0;
	sum = Add(a, b);
	printf("%d\n", sum);
	return 0;
}
//�����Ķ��壺
int Add(int x, int y)
{
	int z = x + y;
	return z;
}
