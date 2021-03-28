package com.csu.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/*
    ForkJoin工作窃取的例子:

    写一个求和计算的任务:
    3000    6000(ForkJoin)    9000(Stream并行流)


    如何使用forkjoin?
        1、通过forkJoinPool来执行
        2、计算任务:forkJoinPool.execute(ForkJoinTask task)
        3、计算类必须要继承RecursiveTask
 */
public class JUCTest29ForkJoin1 extends RecursiveTask<Long> {
    private Long start;
    private Long end;

    //临界值:
    private Long temp = 10000L;
    //构造器:
    public JUCTest29ForkJoin1(Long start, Long end) {
        this.start = start;
        this.end = end;
    }
    //重写RecursiveTask中的compute()计算方法
    @Override
    protected Long compute() {
        if ((end - start) < temp){
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else {     //forkjoin
            Long middle = (start + end)/2;      //中间值
            //把一个任务拆成两个:
            JUCTest29ForkJoin1 forkJoin1 = new JUCTest29ForkJoin1(start, middle);
            forkJoin1.fork();       //拆分任务，把线程压入线程队列
            JUCTest29ForkJoin1 forkJoin2 = new JUCTest29ForkJoin1(middle+1, end);
            forkJoin2.fork();

            //获取结果:
            return forkJoin1.join() + forkJoin2.join();
        }
    }


    //普通程序员的方法:
    public static void test1(){
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 1L;i <= 10_0000_0000;i ++){
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间:" + (end-start));
    }

    //第二种程序员:
    public static void test2() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new JUCTest29ForkJoin1(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);

        Long sum = submit.get();//查看任务

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间:" + (end-start));
    }


    //第三种程序员:
    public static void test3(){
        //使用Stream并行流:

        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L, 10_0000_0000).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间:" + (end-start));
    }


    public static void main(String[] args) {
        //测试三种方式执行的时间:
        test1();        //效率低

        try {
            test2();        //效率较高
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test3();            //效率最高
    }
}
