package com.bjpowernode.day24.homework;
/*
武器的下标越界异常,添加武器异常
 */
public class AddWeaponException extends Exception{
    public AddWeaponException(){

    }
    public AddWeaponException(String s){
        super(s);
    }
}
