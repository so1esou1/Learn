#include <stdio.h>

//����һ���ṹ��=������
struct Book
{
	char name[20];  //c�������
	short price;	//55
};

int main()
{
	/*int a = 10;//������4���ֽڵĿռ�
	//printf("%p\n",&a);  //0020FCC0   16����
	//�洢��ַ�ķ�ʽ
	int* p = &a;//p��һ��������ָ������������a�ĵ�ַ,��int*������
	//printf("%p\n", p);  //��ַ��012FFCA8
	//���õ�ַ�ķ�ʽ
	*p = 20;  //*�������ò�����/��ӷ��ʲ������������Ǹ�*���ǲ�������ֻ�Ǹ���־�������*��ͬ
	printf("a= %d\n", a);  //�����a= 20��˵������ͨ��p��ָ�룩��a��ֵ�����޸�*/


	/*double d = 3.14;
	double* pd = &d;
	*pd = 5.5;
	printf("%lf\n", d);  //5.500000
	printf("%lf\n", *pd);   //5.500000
	printf("%d\n", sizeof(pd));  //�����4����ʵҲ������8��32λ��4����64λ��8���Ĳ�ͬ��*/


	//���ýṹ�����ʹ���һ�������͵Ľṹ���������
	struct Book b1 = { "c�������",55 };
	/*printf("����:%s\n", b1.name);   //����:c�������
	printf("�۸�:%dԪ\n", b1.price);   //�۸�:55Ԫ
	b1.price = 15;
	printf("�޸ĺ�ļ۸�:%dԪ\n", b1.price);  //�޸ĺ�ļ۸�:15Ԫ*/
	struct Book* pb = &b1;
	//����pb��ӡ���ҵ������ͼ۸�
	//ԭд��printf("%s\n", (*pb).name);
	//ԭд��printf("%dԪ\n",(*pb).price);
	//�򵥵�д����
	printf("%s\n", pb->name);
	printf("%dԪ\n", pb->price);
	//. �ṹ��.��Ա
	//-> �ṹ��ָ��->��Ա

	//�޸����������������飬����ֱ�Ӹģ���Ҫʹ�ú���strcpy��
	//strcpy(b1.name, "C++");    strcpy-string copy - �ַ������� -�⺯�� -string.h




	return 0;

}
