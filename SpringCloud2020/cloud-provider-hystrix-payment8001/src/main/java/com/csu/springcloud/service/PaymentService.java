package com.csu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/*

 */
@Service
public class PaymentService {

    //正常访问的方法:
    public String paymentInfo_OK(Integer id){
        return "线程池: " + Thread.currentThread().getName() + "paymentInfo_OK,id: " + id + "\t" + "正确";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })    //选定一个备选的fallback兜底的方法.再设置方法出现的方案，超过3s走兜底方案
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + "paymentInfo_TimeOut,id: " + id + "\t" + "耗时 " + timeNumber + "秒钟";
    }

    //paymentInfo_TimeOut的兜底方案:
    public String paymentInfo_TimeOutHandler(Integer id){
        //返回友好提示:
        return "线程池: " + Thread.currentThread().getName() + "paymentInfo_TimeOut,id: " + id + "\t" + "失败罗 " ;
    }



    //=========================================================
    //服务熔断:
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 在10s的时间窗口期内持续访问
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();  //一个随机数字

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    //服务熔断后的兜底方案:
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
