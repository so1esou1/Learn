package com.bjpowernode.java2.thread;
/*
    生产者/消费者问题(线程通信的应用)

    例子:
    生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
    取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
    生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
    知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
    果店中有产品了再通知消费者来取走产品。

    生产者线程+消费者线程
    共享数据:店员(或产品)
    如何解决线程安全问题？同步机制
    涉及线程通信问题
 */
public class ThreadTest14 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("生产者p1");
        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者c1");
        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者c2");

        p1.start();
        c1.start();
        c2.start();
    }

}




class Clerk{        //店员类
    private int productCount = 0;
    //生产产品
    public synchronized void produceProduct(){      //同步两个方法,锁是clerk
        if (productCount < 20){
            productCount ++;
            System.out.println(Thread.currentThread().getName() + "生产者开始生产第" + productCount + "个产品");

            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public synchronized void consumeProduct(){      //同步方法
        if (productCount > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品");
            productCount --;

            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class Producer extends Thread{     //生产者类
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始生产产品....");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}


class Consumer extends Thread{         //消费者类
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费产品....");
        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
