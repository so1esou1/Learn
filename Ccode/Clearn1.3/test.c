#include <stdio.h>

void test()
{
	static int a = 1;  //a��һ����̬�ֲ�������û��static��ʱ�򣬽�����������ʹ���һ�α���a����ȥ�����٣�����static��ʱ�򣬲���ˢ�±���a
	a++;
	printf("a = %d\n", a); //2 3 4 5 6
}

//static�����ⲿ����ʾ����
extern int Add(int, int);

//#define MAX 100    #define�����ʶ������

//#define�����-������
//������ʵ��
int Max(int x, int y)
{
	if (x > y)
		return x;
	else
		return y;
}
//��Ķ��巽ʽ�ͺ������������
#define MAX(X,Y) (X>Y?X:Y)

int main()
{
	//ָ�����
	int a = 10;//4���ֽ�
	int* p = &a;//ȡ��ַ
	printf("%p\n", &a);
	printf("%p\n", p);//������ַһ��,0135FA08
	*p = 20;//* -- �����ò�����
	printf("a = %d\n", a);//a = 20
	//&a;  ȡ��ַ
	//��һ�ֱ�����������ŵ�ַ��--ָ�����
	//printf("%p\n", &a);



	//#define���峣���ͺ�
	/*int a = MAX;*/
	/*int a = 10;
	int b = 20;
	//�����ķ�ʽ
	int max = Max(a, b);
	printf("max = %d\n", max);
	//��ķ�ʽ
	max = MAX(a, b);
	//������൱��max = (a>b?a:b);
	printf("max = %d\n", max);*/


	//static�ؼ���ʾ����static���ξֲ��������ֲ��������������ڱ䳤��
	/*int i = 1;
	while (i < 5)
	{
		test();
		i++;
	}*/

	//static����ȫ�ֱ������ı��˱��������������³����ܵ���g_val��ֻ�����Լ����ڵ�Դ�ļ��ڲ�ʹ�ã�����Դ�ļ����޷�ʹ����
		//extern---�����ⲿ���ŵ�
	/*extern int g_val;
	printf("g_val = %d\n", g_val);*/


	//static�ؼ��������ⲿ����ʾ�����ı��˺�������������
	//��ͨ���������ⲿ�������ԣ�static���κ��ⲿ�������Ա�����ڲ���������
	/*int a = 10;
	int b = 20;
	int sum = Add(a, b);
	printf("sum = %d\n", sum);  //�޷�����add�ĺ�����*/


	//typedef�ؼ���ʾ��
	/*typedef unsigned int u_int;//��unsigned int���¶���Ϊu_int���൱�ڱ�����
	unsigned int num = 20;
	u_int num2 = 20;*/



	//�ַ����Ľ�����־��'\0'��ת���ַ�����������

	/*int a = 10;
	int b = 10;
	int max = 0;
	max = (a > b ? a : b);  //�ж�a��b��С��a�������a��ֵ��b�������b��ֵ����Ŀ��������
	if (a > b)
		max = a;
	else
		max = b;*/


	/*int a = 10;
	int b = a++;//����++���Ȱ�a��ֵ����b���ٽ�a��1
	int c = 10;
	int d = ++c;//ǰ��++���ȼ���a��ֵ���ٸ���b
	printf("a = %d b = %d\n", a, b);//a =11,b = 10
	printf("c = %d d = %d\n", c, d);//c =11,d = 11*/

	

	return 0;

}