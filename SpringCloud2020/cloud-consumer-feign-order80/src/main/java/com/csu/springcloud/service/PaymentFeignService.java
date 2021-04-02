package com.csu.springcloud.service;

import com.csu.springcloud.entities.CommonResult;
import com.csu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
    作为feign主件的接口
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //故意暂停的程序
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
