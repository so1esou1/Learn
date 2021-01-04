package com.bjpowernode.java.threadsafe2;

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
        //synchronized(this)  //这里写this不行，这里的this是AccountThread对象，这个对象不共享

        /*synchronized(act){
            act.withdraw(money);
        }   在这里写synchronized也可以，但是这里会扩大同步的范围，效率更低了
        */
        act.withdraw(money);
        System.out.println(Thread.currentThread().getName() + "对" + act.getActno() + "取款"+ money + "账户取款成功，余额：" + act.getBalance());
    }
    //效率变慢了，不过确实变安全了
}

