package com.liaoxx.spring_hello.config;

import com.liaoxx.spring_hello.constants.QueueEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class RabbitMqConfig {




    @Bean
    public Queue QueueOrderDelayRight() {

        return new Queue(QueueEnum.TypeQueueOrderRight);  //订单延迟处理队列
    }

    @Bean
    public Queue QueueOrderSpellDelayRight() {

        return new Queue(QueueEnum.TypeQueueOrderSpellRight);  //拼团自动延迟处理取消
    }
    @Bean
    public Queue QueueOrderDelayReceiving() {

        return new Queue(QueueEnum.TypeQueueOrderReceiving);  //订单延迟处理队列
    }
    @Bean
    public Queue QueueMerchantActivityDelayCancel() {

        return new Queue(QueueEnum.TypeQueueMerchantActivityCancel);  //订单延迟处理队列
    }
}
