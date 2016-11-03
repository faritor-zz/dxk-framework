package com.demo.service;

import com.rabbitmq.client.Channel;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by dxk on 2016/10/19.
 */
@Component
public class Consumer implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        if (message != null || message.getBody().length != 0) {
            try {
                String data = new String(message.getBody(), "utf-8");
                System.out.println("-------------接收消息为 data：" + data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
