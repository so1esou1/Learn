package com.csu.springcloud.controller;

import com.csu.springcloud.pojo.Dept;
import com.csu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;



    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")    //只要这个方法调用失败了，就调用hystrixGet,不会像之前一样直接崩
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept == null){
            throw new RuntimeException("id=>" + id + "不存在，或者信息无法找到");
        }
        return dept;
    }

    //备选方法,熔断版
    public Dept hystrixGet(@PathVariable("id") Long id){
        Dept dept = new Dept();
        dept.setDeptno(id);
        dept.setDname("id=>" + id + "没有对应的信息，null--@Hystrix");
        dept.setDb_source("no this database in MySQL");
        return dept;
    }

}
