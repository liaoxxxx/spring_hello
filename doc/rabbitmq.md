
# AMQP 的Rabbit MQ  的使用  
摘自:Spring Boot系列(八)：RabbitMQ详解 - 极乐君的文章 - 知乎
https://zhuanlan.zhihu.com/p/25069044

##一. 图解RabbitMQ - EnjoyMoving的文章 - 知乎 https://zhuanlan.zhihu.com/p/48779080



##二.简单-配置,及代码范例
>1.配置pom包，主要是添加spring-boot-starter-amqp的支持
```xml
<dependency>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```
 
 
 
>  2 .配置文件 
```text
spring.application.name=spirng-boot-rabbitmq

spring.rabbitmq.host=192.168.0.86
spring.rabbitmq.port=5672
spring.rabbitmq.username=admin
spring.rabbitmq.password=123456


```



> 3 . 队列配置
 
 
```java
@Configuration
   public class RabbitConfig {
   
       @Bean
       public Queue Queue() {
           return new Queue("default");
       }
   
   }
``` 

## 三.复杂 配置
### 1.配置



## 四.常见错误


>1.org.springframework.amqp.rabbit.listener.BlockingQueueConsumer$DeclarationException: Failed to declare queue(s):[default]

 >原因 : 未定义相应的队列
>
>
 ```java
@Configuration
 public class RabbitConfig {
 
     @Bean
     public Queue Queue() {
         return new Queue("default"); //相应的队列名
     }
 
 }
 ```
