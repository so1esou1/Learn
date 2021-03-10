package com.csu.observer.improver;
/*
    定义登记注册、移除和通知方法的接口
 */
public interface Subject {
    public void registerObserver(Observers o);
    public void removeObserver(Observers o);
    public void notifyObservers();
}
