package com.liaoxx.spring_hello.task;

import com.liaoxx.spring_hello.constants.QueueEnum;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

@Slf4j
public class OrderTask {



    //链接：https://zhuanlan.zhihu.com/p/384200726
    @RabbitListener(queues = "order_right")
    public void Order(String object, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        log.info("消费成功：{},消息内容:{}", deliveryTag, object);
        try {
            /**
             * 执行业务代码...
             * */
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            log.error("签收失败", e);
            try {
                channel.basicNack(deliveryTag, false, true);
            } catch (IOException exception) {
                log.error("拒签失败", exception);
            }
        }
    }
}
