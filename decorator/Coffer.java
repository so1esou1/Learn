package com.csu.decorator;

public class Coffer extends Drink{
    @Override
    public float cost() {
        return super.getPrice();
    }
}
