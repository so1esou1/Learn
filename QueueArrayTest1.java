package com.csu.queue;

/*
数组模拟队列:

问题：这个程序的问题是取出数据后也无法在底部添加数据，数组只能用到一次，无法达到复用效果。即使把所有数据取出来之后也无法进行添加
    环形队列可以解决这个问题
    需要将这个数组使用算法，改进成一个环形的队列 取模：%
 */
import java.util.Scanner;

public class QueueArrayTest1 {
    public static void main(String[] args) {
        //测试
        //创建一个队列
        QueueArray queueArray = new QueueArray(3);
        char key = ' ';         //创建用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);     //接收一个字符
            switch (key){
                case 's':
                    queueArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    queueArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queueArray.getQueue();
                        System.out.println("取出的数据是" + res + "\n");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queueArray.headQueue();
                        System.out.println("队列头的数据是" + res + "\n");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//创建一个队列的类
class QueueArray{
    private int maxSize;    //数组的最大容量
    private int front;      //队列头部指针
    private int rear;       //队列尾部指针
    private int[] array;    //存放队列的数组,模拟队列

    //创建队列的构造器
    public QueueArray(int arrMaxSize){
        maxSize = arrMaxSize;
        array = new int[maxSize];
        front = -1;     //初始化时先赋值为-1，指向队列头部(初始化时还不能进入队列中)
        rear = -1;      //指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    //判断队列是否是满的的方法
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //判断队列是否为空的情况
    public boolean isEmpty(){
        return front == rear;
    }
    //添加数据到队列的方法,通过rear取
    public void addQueue(int n){
        //判断队列是否满，满则不能
        if (isFull()){
            System.out.println("队列满，不能加数据");
            return;
        }
        rear ++;    //让rear后移
        array[rear] = n;
    }
    //取出队列的数据，出队列，通过front取
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front ++;   //让front后移
        return array[front];
    }
    //显示队列的所有数据
    public void showQueue(){
        //遍历
        //队列为空，进行提示
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0;i < array.length;i ++){
            System.out.printf("array[" + i + "]=" + array[i] + "\na");
        }
    }
    //显示队列的头部是多少，注意：这里不是取出数据
    public int headQueue(){
        //判断是否为空
        if (isEmpty()){
            throw new RuntimeException("没有数据");
        }
        return array[front + 1];   //注意+1
    }

}
