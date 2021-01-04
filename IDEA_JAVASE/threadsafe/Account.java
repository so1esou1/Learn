package com.bjpowernode.java.threadsafe;
/*
银行账户
    不使用线程同步机制的情况下，多线程对同一个账户进行取款，出现线程安全问题
 */
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

    //取款的方法
    public void withdraw(double money){
        //t1和t2并发这个方法。。。（t1和t2是两个栈。两个栈操作堆中同一个对象）
        //取款前余额
        double before = this.getBalance();
        //取款后的余额
        double after = before - money;

        //这里用休眠模拟一下网络延迟，一定会出问题
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //更新余额
        //假设t1的程序执行到这里还未执行以下代码，t2进入，可能出现问题
        this.setBalance(after);
    }
}


