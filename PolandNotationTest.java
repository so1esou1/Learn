package com.csu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    需求：实现逆波兰计算器。输入一个逆波兰表达式(后缀表达式)，使用栈(Stack), 计算其结果。支持小括号和多位数整数
    逆波兰表达式适合计算器计算
 */
public class PolandNotationTest {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        String suffixExpression = "3 4 + 5 * 6 - ";
        //思路：
        // 1、先将"3 4 + 5 * 6 - "放到一个arraylist中
        //2、将ArrayList传递一个方法，遍历ArrayList,配合栈完成计算

        //测试:
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);

        int res = calculate(rpnList);
        System.out.println("计算的结果是:" + res);


    }

    //将逆波兰表达式依次将数据和运算符放到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        //创建一个栈，只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历 ls
        for (String item : ls) {
            //这里使用一个正则表达式取出数
            if (item.matches("\\d+")) {      //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());       //先弹出的用num2接收，后弹出的用num1接收
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }


}



