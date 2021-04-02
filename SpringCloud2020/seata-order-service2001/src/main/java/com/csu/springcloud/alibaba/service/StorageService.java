package com.csu.springcloud.alibaba.service;

import com.csu.springcloud.alibaba.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author so1esou1
 * @ClassName
 * @Date 2021.1.4
 * @TODO
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
