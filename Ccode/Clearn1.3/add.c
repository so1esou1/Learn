static int g_val = 2020;//全局变量,加上static后改变了变量的作用域

//定义一个函数
static int Add(int x, int y)
{
	int z = x + y;
	return z;
}