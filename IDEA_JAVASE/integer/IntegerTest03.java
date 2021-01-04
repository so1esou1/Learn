package com.bjpowernode.javase.integer;
/*
关于Integer类的构造方法，有两个：
    Integer(int)
    Integer(String)
 */
public class IntegerTest03 {
    public static void main(String[] args) {
        //java9之后不建议使用这个构造方法了。出现横线表示已过时
        //将数字100转换成Integer包装类型(int-->Integer)
        Integer x = new Integer(100);
        System.out.println(x);

        //将String类型的数字转换成Integer包装类型(String -- > Integer)
        Integer y = new Integer("123");
        System.out.println(y);

        //类似，可以猜出来Double等类的构造方法
        //double --> Double
        Double d = new Double(1.23);
        //String -->Double
        System.out.println(d);
        Double e = new Double("3.14");
        System.out.println(e);
    }
}
