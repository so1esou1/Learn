package com.csu.stack;

import java.util.Scanner;

/*
    使用数组实现stack
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        //测试栈
        //先创建一个Stack的对象
        Stack stack = new Stack(4);
        String key = "";
        boolean loop = true;        //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:添加数据到栈");
            System.out.println("pop:从栈中取出数据");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println("出栈的数据是:" + res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}




class Stack{
    private int maxSize;    //栈的大小
    private int[] stack;    //数组模拟栈
    private int top;        //栈顶或栈帧
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        //先判断栈是否满
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top ++;
        stack[top] =value;
    }

    //出栈,将栈顶的数据返回
    public int pop(){
        //先判断是否空，抛出异常处理
        if (isEmpty()){
            throw new RuntimeException("栈空,没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示/遍历栈，遍历时需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top;i >= 0;i --){
            System.out.println("stack[" + i + "] = " + stack[i]);
        }
    }
}
