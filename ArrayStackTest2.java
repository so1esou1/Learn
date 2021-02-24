package com.csu.stack;
/*
    使用栈实现计算器的功能
 */
public class ArrayStackTest2 {
    public static void main(String[] args) {
        //测试
        String expression = "3+2*6-2";
        //创建两个栈，数栈和符号栈
        Stack2 numStack = new Stack2(10);         //数栈可以有10个数字
        Stack2 operStack = new Stack2(10);          //符号栈

        //定义需要的相关变量
        int index = 0;      //用于扫描的值（索引），来遍历我们的表达式
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;        //运算的结果
        char ch = ' ';      //将每次扫描得到的char保存到ch

        //开始用while循环地扫描expression
        while (true){
            //1、先一次得到expression地每一个字符
            ch = expression.substring(index,index + 1).charAt(0);       //substring截取字符串,charAt把字符串转成字符
            //2、判断ch是什么，然后进行相应的处理
            if (operStack.isOper(ch)){
                //判断当前符号栈是否为空
                if (!operStack.isEmpty()){
                    //如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数,
                    // 在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();         //弹出num1、num2、oper三个值
                        res = numStack.cal(num1,num2,oper);     //进行运算
                        //把运算的结果入数栈
                        numStack.push(res);
                        //记得再将当前符号入符号栈
                        operStack.push(ch);
                    }else {
                        //如果为空，直接加进去
                        operStack.push(ch);
                    }
                }else {
                    //如果为空，直接入符号栈
                    operStack.push(ch);
                }
            }else{           //如果是数，直接入数栈
                numStack.push(ch - 48);         //ascii码之间的差距导致要-48
            }
            //让index + 1并判断是否扫描到最后一位
            index ++;
            if (index >= expression.length()){
                break;
            }
        }

        //当表达式扫描完毕，就顺序地从数栈和符号栈中pop出相应地数和符号并运行
        while (true){
            //如果符号栈为空，则计算到最后的结果，数栈只有一个数【就是结果】
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);         //最后将res重新放回数栈中
        }
        System.out.println("表达式" + expression + "结果是:" + numStack.pop());
    }
}


//栈直接使用上一个栈即可,但需要扩展功能:返回符号优先级、判断是否为运算符、计算的方法、返回当前栈顶值(不是pop)
class Stack2{
    private int maxSize;
    private int[] stack;
    private int top = -1;
    public Stack2(int maxSize) {
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

    //新功能：返回程序的优先级，优先级由程序员来定.优先级使用数字表示，数字越大则优先级越高
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;  //假定目前计算器中只有加减乘除
        }
    }

    //新功能：判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/' ;
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;        //用于存放计算的结果
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case  '-':
                res = num2 - num1;         //注意:要把后面的数作为减数
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

    //返回当前栈顶值的方法(不是pop)
    public int peek(){
        return stack[top];
    }
}

