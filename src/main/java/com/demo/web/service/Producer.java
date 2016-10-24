package com.demo.web.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dxk on 2016/10/19.
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sender() throws Exception{
        for (int i = 1; i < 10; i++) {
            amqpTemplate.convertAndSend("Hello, world!");
            System.out.println("-------------发送第"+i+"条消息成功");
            Thread.sleep(2000);
        }

    }

}
