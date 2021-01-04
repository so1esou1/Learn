package com.bjpowernode.java.threadsafe2;
/*
银行账户
    使用线程同步机制的情况下，解决线程安全问题
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


    public void withdraw(double money){
        //要解决的话，以下几行代码必须是排队的，不能并发
        //一个线程把这里的代码全部执行结束之后，另一个线程才能够进来
        /*
        线程同步机制的语法是：
            synchronized(){
                //线程同步代码块
            }
            ***synchronized后面小括号中传的这个数据是相当关键的
            这个数据必须是多线程共享的数据。才能达到多线程排队

            ()中写什么？
                那要看你想让哪些线程同步。
                假设t1、t2、t3、t4、t5，只希望t1、t2、t3排队，t4、t5不排队怎么办？
                一定要在()中写一个t1、t2、t3共享的对象
                而这个对象对于t4、t5来说不是共享的
         */
        synchronized (this){    //填共享对象,这个共享对象应该是账户对象
                            //账户对象是共享的，那么this就是账户对象
            //java语言中任何对象都有一把锁🔒，只是把它叫做锁，其实是一个标记
        //synchronized ("abc"){    这样也可以，因为abc在字符串常量池里。“全天下人都等着你取款”

            /*以下代码的执行原理：
                1、假设t1和t2线程并发，开始执行以下代码的时候，肯定有一个先一个后
                2、假设t1先执行了，遇到了synchronized，这个时候自动找后面共享对象的对象锁，
                找到之后并占有这把锁，然后执行同步代码块中的程序，在程序执行过程中一直都是
                占有这把锁的，直到同步代码块代码结束，这把锁才会释放。
                3、假设t1已经占有这把锁，此时t2也遇到synchronized关键字，也会去占有后面共享对象
                的这把锁，结果这把锁被t1占有，t2只能在同步代码块外面等待t1的结束，直到t1把
                同步代码块执行结束了，t1会归还这把锁，此时t2终于等到这把锁，然后t2占有这把锁后，
                进入同步代码块执行程序。

                这样就达到了线程排队执行。
                需要注意的是：这个共享对象一定要选好了，一定是需要排队执行的线程对象所共享的。

             */
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
}


