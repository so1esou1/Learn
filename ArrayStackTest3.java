package com.csu.stack;

/*
    上一个程序无法处理两位数的运算，在这里进行改进
    问题出现在第37行，如果为数直接压栈进了数栈
 */
public class ArrayStackTest3 {
    public static void main(String[] args) {
        String expression = "70+2*6-4";
        Stack3 numStack = new Stack3(10);
        Stack3 operStack = new Stack3(10);


        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";        //用于拼接多位数


        while (true){
            ch = expression.substring(index,index + 1).charAt(0);
            if (operStack.isOper(ch)){
                if (!operStack.isEmpty()){
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    //operStack.push(ch);
                    //分析思路：
                    //1、当处理多位数时，不能发现是一个数就立即入栈，因为它可能是多位数
                    //2、在处理数时，需要向expression表达式的index后面再看一位，如果是数就继续扫描，如果是符号才入栈
                    //3、因此我们需要定义一个变量用于拼接

                    //处理多位数:
                    keepNum += ch;

                    //如果ch已经是expression的最后一位了，就直接入栈
                    if (index == expression.length() - 1){
                        numStack.push(Integer.parseInt(keepNum));
                    }else {     //否则继续进行判断
                        //判断下一个数是不是数字，如果是就继续扫描，如果是运算符则入栈
                        if (operStack.isOper(expression.substring(index + 1,index + 2).charAt(0))){     //注意，只是往后看，index不要后移
                            //如果后一位是运算符则入栈     keepNum长这样： "123"，需要转成int
                            numStack.push(Integer.parseInt(keepNum));
                            //重要点:要清空keepNum！！！
                            keepNum = "";
                        }
                    }

                }
            }else{
                numStack.push(ch - 48);
            }
            index ++;
            if (index >= expression.length()){
                break;
            }
        }

        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println("表达式" + expression + "结果是:" + numStack.pop());
    }
}


class Stack3{
    private int maxSize;
    private int[] stack;
    private int top = -1;
    public Stack3(int maxSize) {
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
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top ++;
        stack[top] =value;
    }
    //出栈,将栈顶的数据返回
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空,没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top;i >= 0;i --){
            System.out.println("stack[" + i + "] = " + stack[i]);
        }
    }

    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/' ;
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case  '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    public int peek(){
        return stack[top];
    }
}
