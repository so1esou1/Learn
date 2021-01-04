package com.bjpowernode.day24.homework;

/**
 * 高射炮，是武器，只能攻击不能移动
 */
public class GaoShePao extends Weapon implements Shootable{
    public void shoot(){
        System.out.println("高射炮开炮");
    }
}
