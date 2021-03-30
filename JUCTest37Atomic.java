package com.csu.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
    原子引用解决ABA问题
 */
public class JUCTest37Atomic {
    /*
        Integer使用了对象缓存机制，默认范围是-128~127,推荐使用静态工厂方法valueof获取对象实例，而不是new，
        因为valueof使用缓存，而new一定会创建新的对象分配新的内存空间
        注意：如果泛型是保证类，注意对象的引用问题
     */
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(5,1);

    public static void main(String[] args) {
        //创建AtomicReference类:
        //1是时间戳，每次被执行了就+1

        new Thread(()->{
            int stamp1 = atomicStampedReference.getStamp();      //获取版本号
            System.out.println("a1=>" + stamp1);        //查看当前的版本号时间戳

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(5,      //期望的值
                    6,           //更新的值
                    atomicStampedReference.getStamp(),          //拿到当前的时间戳
                    atomicStampedReference.getStamp()+1);       //时间戳+1
            System.out.println("a2=>" + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(6,      //期望的值
                    5,           //更新的值
                    atomicStampedReference.getStamp(),          //拿到当前的时间戳
                    atomicStampedReference.getStamp()+1);       //时间戳+1
            System.out.println("a3=>" + atomicStampedReference.getStamp());

        },"a").start();



        new Thread(()->{
            int stamp2 = atomicStampedReference.getStamp();
            System.out.println("b1=>" + stamp2);            //查看当前时间戳

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicStampedReference.compareAndSet(5,
                    15,
                    stamp2,
                    stamp2 + 1
            ));         //false,修改失败，因为stamp改变了
            System.out.println("b2=>" + atomicStampedReference.getStamp());

        },"b").start();
    }
}
