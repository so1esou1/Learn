package com.csu.testrenwu.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //需求：在一段特定的时间执行这个方法     Timer~
    //Cron表达式
    //秒 分 时 日 月 周
    @Scheduled(cron = "30 15 10 * * ?")  //意思是每天的10点15分30秒执行一次
    //@Scheduled(cron = "30 0/5 10,18 * * ?")   //每天的10点和18点，每隔5分钟执行一次
    //@Scheduled(cron = "0 15 10 ? * 1-6")    //每个月的周一到周六10.15分执行一次
    public void hello(){
        System.out.println("hello,你被执行了");
    }
}
