package com.bjpowernode.javase.exception;
/*
SUN提供的异常时不够用得，实际开发过程中有很多业务，
这些业务出现异常之后，JDK都是没有的，和业务挂钩的。
    异常类程序员可以自己定义吗？  可以
java中怎么自定义异常呢？
    两步：1、编写一个类继承Exception或者RunTimeException
    2、提供两个构造方法，一个无参数的，一个带有String参数的
死记硬背。
 */
public class MyException extends  Exception{      //编译时异常
    public MyException(){

    }
    public MyException(String s){
        super(s);
    }
}//看ExceptionTest15


/*public class MyException extends RunTimeException{     //运行时异常
}
*/