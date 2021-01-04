package com.bjpowernode.java.threadsafe;

public class AccountThread extends Thread{
    //确保两个线程共享同一个账户对象
    private Account act;

    //通过构造方法传递过来账户对象
    public  AccountThread(Account act){
        this.act = act;
    }
    public void run(){
        //run方法执行表示取款操作
        //假设取款5000元
        double money = 5000;
        //取款
        //多线程并发执行这个方法
        act.withdraw(money);

        System.out.println(Thread.currentThread().getName() + "对" + act.getActno() + "取款"+ money + "账户取款成功，余额：" + act.getBalance());
    }
}
//解决方法可以去看threadsafe2包下的内容
