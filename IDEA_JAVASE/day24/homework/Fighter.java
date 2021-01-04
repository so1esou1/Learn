package com.bjpowernode.day24.homework;

/**
 * 战斗机，是武器，可移动、攻击
 */
public class Fighter extends Weapon implements Moveable,Shootable{

    @Override
    public void move() {
        System.out.println("战斗机起飞");
    }

    @Override
    public void shoot() {
        System.out.println("战斗机开炮");
    }
}
