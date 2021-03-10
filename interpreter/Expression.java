package com.csu.interpreter;

import java.util.HashMap;

/*
    抽象的表达式类.声明一个抽象的解释操作,这个方法为抽象语法树中所有的节点（子类）所共享
    程序会使用到栈stack,见课件
 */
public abstract class Expression {
    //通过hashmap键值对，可以获取到各个变量的值
    //解释公式和数值，key就是公式(表达式)，参数[a,b,c],value就是具体值
    public abstract int interpreter(HashMap<String, Integer> var);
}
