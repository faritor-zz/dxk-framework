package com.demo.event;

import com.rabbitmq.client.Channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * 测试mq消费者类
 */
@Component
public class Consumer2 implements ChannelAwareMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(Consumer2.class);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        if (message != null || message.getBody().length != 0) {
            try {
                String data = new String(message.getBody(), "utf-8");
                logger.debug("-------------二号消费者接收消息为 data：" + data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
