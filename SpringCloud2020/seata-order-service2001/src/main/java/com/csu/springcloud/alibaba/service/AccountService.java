package com.csu.springcloud.alibaba.service;

import com.csu.springcloud.alibaba.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author so1esou1
 * @ClassName
 * @Date 2021.1.4
 * @TODO
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
        @PostMapping(value = "/account/decrease")
        CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
