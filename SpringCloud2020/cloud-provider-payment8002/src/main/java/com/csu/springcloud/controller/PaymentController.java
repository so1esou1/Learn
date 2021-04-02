package com.csu.springcloud.controller;

import com.csu.springcloud.entities.CommonResult;
import com.csu.springcloud.entities.Payment;
import com.csu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/*

 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")        //相当于设置服务端口
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    //新增的功能:
    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);

        if(result > 0)
        {
            return new CommonResult(200,"插入数据库成功,serverPort: ",result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    //查找的功能:
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);

        if(payment != null)
        {
            return new CommonResult(200,"查询成功,serverPort:  ",payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();  //得到服务
        for (String element : services){
            log.info("**********element:" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
            //返回这些信息
        }

        return this.discoveryClient;
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;//返回服务接口
    }
}
