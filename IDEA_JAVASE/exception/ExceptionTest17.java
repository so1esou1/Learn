package com.bjpowernode.javase.exception;
/*
之前在讲解方法覆盖的时候，当时遗留了一个问题
    重写之后的方法不能比重写前的方法抛出更多的（更宽泛的）异常，可以更少。

 */
class Animal{
    public void doSome(){

    }
    public void doOther() throws Exception{

    }
}
class Cat extends Animal{
    /*编译报错
    public void doSome() throws  Exception{

    }*/

    //编译正常。
    /*public void doOther(){

    }*/

    //编译正常
    /*public void doOther() throws Exception{

    }*/

    //编译正常
    public void doOther() throws NullPointerException{

    }
}
/*
总结异常中的关键字：
    异常捕捉：
        try
        catch
        finally

    throws 在方法声明的位置上使用，表示上报异常信息给调用者
    throw 手动抛出异常！
 */
