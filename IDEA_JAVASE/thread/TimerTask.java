package com.bjpowernode.java.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/*
使用定时器指定定时任务
 */
public class TimerTask {
    public static void main(String[] args) throws  Exception{
        //创建定时器对象
        Timer timer = new Timer();
        //Timer timer = new Timer(true);  //守护线程的方式

        //指定定时任务
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date firstTime = sdf.parse("2021-01-01 00:30:00");
        timer.schedule(new LogTimerTask(),firstTime,1000*10);//(定时任务,第一次执行时间,间隔多久执行一次)
    }
}

//编写一个定时任务类，可以写一个匿名内部类
//假设这是一个记录日志的定时任务
class LogTimerTask extends java.util.TimerTask {

    @Override
    public void run() {
        //编写你需要执行的任务就行了
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = sdf.format(new Date());
        System.out.println(strTime + ":成功完成了一次数据备份！");
    }
}
