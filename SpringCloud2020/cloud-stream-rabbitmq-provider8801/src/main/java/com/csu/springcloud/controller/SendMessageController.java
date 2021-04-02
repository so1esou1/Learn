package com.csu.springcloud.controller;

import com.csu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/*

 */
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
