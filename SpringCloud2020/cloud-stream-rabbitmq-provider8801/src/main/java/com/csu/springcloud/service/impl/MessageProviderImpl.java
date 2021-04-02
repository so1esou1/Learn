package com.csu.springcloud.service.impl;

import com.csu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/*
    发送消息的实现类
 */
@EnableBinding(Source.class) //定义消息的推送管道,不是@Service
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;  // 消息发送的管道

    @Override
    public String send()
    {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return null;
    }
}
