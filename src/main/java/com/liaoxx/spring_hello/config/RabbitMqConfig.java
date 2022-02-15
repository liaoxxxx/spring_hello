package com.liaoxx.spring_hello.config;

import com.liaoxx.spring_hello.constants.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
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

    //rabbitAdmin 用于管理 exchanges, queues and bindings等
    @Bean
    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    //queue 声明队列：queue"+QueueEnum.TypeQueueOrderRight
    @Bean
    Queue queueOrderDelayRight(RabbitAdmin rabbitAdmin) {
        Queue queue = new Queue(QueueEnum.TypeQueueOrderRight, true);  //订单延迟处理队列
        rabbitAdmin.declareQueue(queue);
        return queue;
    }

    //exchange 声明交换：exchange"+QueueEnum.TypeQueueOrderRight
    @Bean
    TopicExchange exchangeOrderRight(RabbitAdmin rabbitAdmin) {
        TopicExchange topicExchange = new TopicExchange(QueueEnum.TypeQueueOrderRight);
        rabbitAdmin.declareExchange(topicExchange);
        return topicExchange;
    }

    //绑定exchange和queue
    @Bean
    Binding bindingExchangeOrderRight(Queue queueOrderDelayRight, TopicExchange exchange, RabbitAdmin rabbitAdmin) {
        Binding binding = BindingBuilder.bind(queueOrderDelayRight).to(exchange).with(QueueEnum.TypeQueueOrderRight);
        rabbitAdmin.declareBinding(binding);
        return binding;
    }



        /////////////////////////////////////////////////////////////////////////////////////




    
    
    
    
    
    
    
    
    
    
    
    
    @Bean
    public Queue QueueOrderSpellDelayRight() {

        return new Queue(QueueEnum.TypeQueueOrderSpellRight,true);  //拼团自动延迟处理取消
    }
    @Bean
    public Queue QueueOrderDelayReceiving() {

        return new Queue(QueueEnum.TypeQueueOrderReceiving,true);  //订单延迟处理队列
    }
    @Bean
    public Queue QueueMerchantActivityDelayCancel() {

        return new Queue(QueueEnum.TypeQueueMerchantActivityCancel,true);  //订单延迟处理队列
    }
}
