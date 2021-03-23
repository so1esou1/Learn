package com.csu.jvm;

/**
 * @author so1esou1
 * @ClassName   演示栈、栈溢出
 * @Date 2021.1.4
 * @TODO
 */
public class StackTest1 {
    public static void main(String[] args) {
        new StackTest1().test();
    }
    public void test(){
        a();
    }
    public void a(){
        test();
    }
}
