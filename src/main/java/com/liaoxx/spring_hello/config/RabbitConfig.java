package com.liaoxx.spring_hello.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue() {
        return new Queue("default");
    }

    public String EXCHANGE ="directEX";

    public String ROUTINGKEY ="directRK";



}
