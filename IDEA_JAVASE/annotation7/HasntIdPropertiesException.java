package com.bjpowernode.java.annotation7;
/*
这是一个自定义异常
 */
public class HasntIdPropertiesException extends RuntimeException{
    public HasntIdPropertiesException(){

    }
    public HasntIdPropertiesException(String s){
        super(s);
    }
}
