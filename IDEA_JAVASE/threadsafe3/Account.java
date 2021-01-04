package com.bjpowernode.java.threadsafe3;

public class Account {
    //账号和余额
    private String actno;
    private double balance;

    public Account() {
    }

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //在实例方法上可以使用synchronized吗？
    //答案是可以的！！！
    public synchronized void withdraw(double money){
        //synchronized放在实例方法上一定锁的是this，这种方法很不灵活
        //另外还有缺点，synchronized出现在实例方法上，表示整个方法体都需要同步，可能会无故扩大程序的执行范围，导致程序的执行效率变低
        //这种方式不常用
        //优点：只有一个，代码写得少了，节俭，如果共享的对象就是this，并且需要同步的代码块是整个方法体，建议使用这种方式
        

            double before = this.getBalance();

            double after = before - money;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.setBalance(after);

    }
}


