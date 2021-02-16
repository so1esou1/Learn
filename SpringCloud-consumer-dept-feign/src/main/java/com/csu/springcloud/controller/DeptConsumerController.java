package com.csu.springcloud.controller;

import com.csu.springcloud.pojo.Dept;
import com.csu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //理解：消费者不应该有service层
    //RestTemplate ... 供我们直接调用就可以了!注册到Spring中
    //RestTemplate提供多种便捷访问远程Http服务的方法。简单的restful服务模板，简单粗暴无脑

    @Autowired
    private RestTemplate restTemplate;       //参数：url,实体:Map,Class<T>,responseType


    @Autowired
    private DeptClientService service = null;

    private static final String REST_URL_PREFIX = "http://localhost:8001";      //把地址前缀写成固定的常量
    //通过ribbon，我们这里的地址应该是一个变量，通过服务名来访问
    //private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";   这里没有进行修改



    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }    //http://localhost/consumer/dept/add?dname='233'
    /*通过feign注解方式实现的写法:
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return this.service.addDept(dept);
    }
     */



    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }
    /*通过feign注解方式实现的写法:
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.service.queryById(id);
    }
     */


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
    }
    /*通过feign注解方式实现的写法:
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.service.queryAll();
    }
     */

}
