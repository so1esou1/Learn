#include <stdio.h>

//创建一个结构退=体类型
struct Book
{
	char name[20];  //c语言设计
	short price;	//55
};

int main()
{
	/*int a = 10;//申请了4个字节的空间
	//printf("%p\n",&a);  //0020FCC0   16进制
	//存储地址的方式
	int* p = &a;//p是一个变量（指针变量），存放a的地址,用int*来声明
	//printf("%p\n", p);  //地址：012FFCA8
	//调用地址的方式
	*p = 20;  //*：解引用操作符/间接访问操作符，上面那个*不是操作符，只是个标志，跟这个*不同
	printf("a= %d\n", a);  //结果：a= 20，说明可以通过p（指针）对a的值进行修改*/


	/*double d = 3.14;
	double* pd = &d;
	*pd = 5.5;
	printf("%lf\n", d);  //5.500000
	printf("%lf\n", *pd);   //5.500000
	printf("%d\n", sizeof(pd));  //结果是4，其实也可以是8（32位（4）和64位（8）的不同）*/


	//利用结构体类型创建一个该类型的结构体变量出来
	struct Book b1 = { "c语言设计",55 };
	/*printf("书名:%s\n", b1.name);   //书名:c语言设计
	printf("价格:%d元\n", b1.price);   //价格:55元
	b1.price = 15;
	printf("修改后的价格:%d元\n", b1.price);  //修改后的价格:15元*/
	struct Book* pb = &b1;
	//利用pb打印出我的书名和价格
	//原写法printf("%s\n", (*pb).name);
	//原写法printf("%d元\n",(*pb).price);
	//简单的写法：
	printf("%s\n", pb->name);
	printf("%d元\n", pb->price);
	//. 结构体.成员
	//-> 结构体指针->成员

	//修改书名（书名是数组，不能直接改，需要使用函数strcpy）
	//strcpy(b1.name, "C++");    strcpy-string copy - 字符串拷贝 -库函数 -string.h




	return 0;

}
