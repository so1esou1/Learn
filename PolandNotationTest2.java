package com.csu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotationTest2 {
    public static void main(String[] args) {
        //实现一个将中缀表达式转成后缀表达式的功能:
        //1、将 1+((2+3)×4)-5 => 转成 1 2 3 + 4 × + 5 –
        //2、因为直接对str进行操作不方便，因此先将 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3、将得到的中缀表达式对应的 List => 后缀表达式对应的 List
        // 即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList);

        List<String> suffixExpression = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List=" + suffixExpression);

        System.out.println("expression=" + calculate(suffixExpression));

    }

        //将得到的中缀表达式对应的 List => 后缀表达式对应的 List
        public static List<String> parseSuffixExpressionList(List<String> ls){
            //定义两个栈
            Stack<String> s1 = new Stack<String>();         //符号栈
            //因为s2这个栈在整个转换过程中没有pop操作，且后面还需要逆序输出，因此比较麻烦，这里不用栈，直接使用List<String>来替代
            //Stack<String> s2 = new Stack<String>();         //存储中间结果的栈s2
            List<String> s2 = new ArrayList<String>();

            //开始遍历ls
            for (String item : ls){
                //如果是一个数就入栈s2
                if (item.matches("\\d+")){
                    s2.add(item);
                }else if (item.equals("(")){        //如果是左括号的话...
                    s1.push(item);
                }else if (item.equals(")")){        //如果是右括号的话,则依次弹出s1栈顶的运算符，并压入s2，知道遇到左括号为止，此时将这一对括号丢弃
                    while (!s1.peek().equals("(")){
                        s2.add(s1.pop());   //把s1栈的内容弹出来加到s2
                    }
                    s1.pop();       //消除小括号
                }else {
                    //当item的优先级<=栈顶运算符的优先级时，将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                    //问题：缺少比较优先级高低的方法，下面写好了Operation()方法
                    while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                        s2.add(s1.pop());
                    }
                    //还需要将item压入栈中
                    s1.push(item);
                }
            }
            // 将s1中剩余的运算符依次弹出并加入s2
            while (s1.size() != 0){
                s2.add(s1.pop());
            }
            return s2;      //因为是存放到List，有序，按正常顺序输出就是对应的逆波兰
        }


        //先定义一个方法:将中缀表达式转成对应的List
        public static List<String> toInfixExpressionList(String s){
            //先定义一个List存放中缀对应的内容
            List<String> ls = new ArrayList<String>();
            int i = 0;          //这个相当于指针，用于遍历 中缀表达式字符串
            String str;         //做对多位数的拼接工作
            char c;             //每遍历到一个字符就放入到c中
            do{
                //如果c是一个非数字，就需要加入到ls里去
                if ((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57 ){
                    ls.add("" + c);
                    i ++;       //i需要后移
                }else {         //如果是一个数，需要考虑到多位数的问题
                    str = "";   //先将str置成空串""
                    while (i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57){
                        str += c;       //拼接
                        i ++;
                    }
                    ls.add(str);
                }
            }while (i < s.length());
            return ls;
        }




//将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList 中
public static List<String> getListString(String suffixExpression) {
    //将 suffixExpression 分割
    String[] split = suffixExpression.split(" ");
    List<String> list = new ArrayList<String>();
    for(String ele: split) {
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

//编写一个类Operation，可以返回运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
