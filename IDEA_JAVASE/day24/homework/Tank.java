package com.bjpowernode.day24.homework;

/**
 * 坦克说一个武器，可移动可射击
 */
public class Tank extends Weapon implements Moveable,Shootable {
    public void move(){
        System.out.println("坦克移动");
    }
    public void shoot(){
        System.out.println("坦克开炮");
    }
}
