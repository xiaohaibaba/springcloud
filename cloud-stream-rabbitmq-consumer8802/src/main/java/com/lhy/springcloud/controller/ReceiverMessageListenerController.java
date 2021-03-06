package com.lhy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/31 17:49
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiverMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者1号， -----> 接受到的消息： " + message.getPayload()
                + "\t port: " + serverPort);

    }
}
