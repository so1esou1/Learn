#include <stdio.h>

//��ϰһ��дһ�������ж��Ƿ�������
/*is_prime(int x)
{
	//����������1�����Ƿ���0
	int n = 0;
	for (n = 2; n < x; n++)
	{
		if (x % n == 0)
			return 0;   //return 0��break��ֹͣ����ǿ���㷺
	}
	//������˵��һ����n = x,��������
	return 1;
}   //��������Ƶ�ʱ�򣬹���Ҫ��һ�ɾ���Ҫ������/�ɸ����ԣ������ں����д�ӡ0��1����Ҫֱ�Ӵ�ӡ�������
int main()
{
	int i = 0;
	for (i = 0; i <= 100; i++)
	{
		//�ж�i�Ƿ�Ϊ������
		if (is_prime(i) == 1)   //is_prime���ж������ĺ���
			printf("%d ", i);
	}

	return 0;
}*/


//��ϰ����дһ��������ʵ��һ��������������Ķ��ֲ��ң�ע�����壩
  //��һ�����������в��Ҿ����ĳ����������ҵ��˷�����������±꣬û�ҵ�����-1��
  //д�����ļ���:��д������ô�ã���д������ôʵ�֣�
/*int binary_search(int arr[],int k)
{
	//�㷨��ʵ��
	//�۰���ң������м��Ԫ��1234��5��678910���٣�8�����٣�9����ˡ�
	int sz = sizeof(arr) / sizeof(arr[0]);
	int left = 0;
	int right = sz - 1 ;

	while (left <= right)
	{
		int mid = (left + right) / 2;  //�м�Ԫ�ص��±�
		if (arr[mid] < k)
		{
			left = mid - 1;
		}
		else if (arr[mid] > k)
		{
			right = mid - 1;
		}
		else
		{
			return mid;  //��ȵ���������ҵ���
		}
	}
}*****������д������һ�������⣺�������鴫�ν�ȥ���ڲ���������sizeof�ķ�ʽ��Ԫ�ظ����ˣ�
���������ֻ��һ����ʱ������Ϊ�˱����˷ѣ�ֻ�Ǵ���ȥһ��������Ԫ�صĵ�ַ����
���������arrֻ��һ��ָ�룡��
*/
//��ȷ��д����
int binary_search(int arr[], int k,int sz)
{
	//������ĳ��ȵĳ���д����������Ϳ��Ա���
	int left = 0;
	int right = sz - 1;

	while (left <= right)
	{
		int mid = (left + right) / 2;  
		if (arr[mid] < k)
		{
			left = mid - 1;
		}
		else if (arr[mid] > k)
		{
			right = mid - 1;
		}
		else
		{
			return mid; 
		}
	}
	return -1;
}
int main()
{
	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
	int k = 7;
	int sz = sizeof(arr) / sizeof(arr[0]);
	int ret = binary_search(arr, k, sz);
	if (ret == -1)
	{
		printf("�Ҳ���ָ��������\n");
	}
	else
	{
		printf("�ҵ��ˣ��±��ǣ�%d\n", ret);
	}

	return 0;
}

//дһ��������ÿ����һ�������������num��ֵ����1
/*
void Add(int *p)
{
	(*p)++;     //*����д��*p++����Ϊ++���ȼ��ϸߣ����Ϊ*(p++)


}int main()
{
	int num = 0;
	Add(&num);
	printf("num = %d\n",num);
	Add(&num);
	printf("num = %d\n",num);
	Add(&num);
	printf("num = %d\n",num);
	return 0;
}


*/