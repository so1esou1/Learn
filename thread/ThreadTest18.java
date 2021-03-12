package com.bjpowernode.java2.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
    实现一个定时器,指定定时任务
    TimeTask类实现了Runnable接口

 */
public class ThreadTest18 {
    public static void main(String[] args) throws ParseException {
        //创建一个定时器对象
        Timer timer = new Timer();
        //Timer timer = new Timer(true);        //守护线程的方式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date firstTime = sdf.parse("2020-03-14 09:30:00");

        //指定定时任务
        timer.schedule(new LogTimerTask(),firstTime,1000*10);   //参数:定时任务，第一次执行时间，间隔多久执行一次
    }
}


//编写一个定时任务类，继承抽象类TimeTask，重写其方法
class LogTimerTask extends TimerTask {         //一个记录日志的定时任务

    @Override
    public void run() {
        //编写需要执行的任务就行
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = sdf.format(new Date());
        System.out.println(strTime + ":成功完成了一次数据备份");
    }
}



