package com.csu.observer.improver;
/*
    观察者接口，有更新的方法
 */
public interface Observers {
    public void update(float temperature,float pressure,float humidity);
}
