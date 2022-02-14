package com.liaoxx.spring_hello.config;

import com.liaoxx.spring_hello.constants.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@Configuration
public class RabbitMqConfig {

    //作者：暮色妖娆丶
    //链接：https://zhuanlan.zhihu.com/p/384200726
    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void enableConfirmCallback() {
        //confirm 监听，当消息成功发到交换机 ack = true，没有发送到交换机 ack = false
        //correlationData 可在发送时指定消息唯一 id
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if(!ack){
                //记录日志、发送邮件通知、落库定时任务扫描重发
            }
        });

        //当消息成功发送到交换机没有路由到队列触发此监听
        rabbitTemplate.setReturnsCallback(returned -> {
            //记录日志、发送邮件通知、落库定时任务扫描重发
        });
    }


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
