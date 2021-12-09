
###使用 Druid
####1.配置pom.xml,引入Druid
```xml
<!-- https://mvnrepository.com/artifact/com.alibaba/-->
 <dependency>
     <groupId>com.alibaba</groupId>
     <artifactId>druid</artifactId>
     <version>1.1.14</version>
 </dependency>
```

####2.配置application.properties  的spring.datasource项

````text
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource

#连接池配置
spring.datasource.initialSize=5
spring.datasource.minIdle=5
spring.datasource.maxActive=20
#连接等待超时时间
spring.datasource.maxWait=60000
#配置隔多久进行一次检测(检测可以关闭的空闲连接)
spring.datasource.timeBetweenEvictionRunsMillis=60000
#配置连接在池中的最小生存时间
spring.datasource.minEvictableIdleTimeMillis=300000
spring.datasource.validationQuery=SELECT 1 FROM DUAL
spring.datasource.testWhileIdle=true
spring.datasource.testOnBorrow=false
spring.datasource.testOnReturn=false
# 打开PSCache，并且指定每个连接上PSCache的大小
spring.datasource.poolPreparedStatements=true
spring.datasource.maxPoolPreparedStatementPerConnectionSize=20
# 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
spring.datasource.filters=stat,wall,log4j
# 通过connectProperties属性来打开mergeSql功能；慢SQL记录
spring.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000

````

####3.配置Druid @ConfigurationProperties & @Bean

````java
package com.liaoxx.spring_hello.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
public class DruidConfig{
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
}

````
>这时运行[project_name]ApplicationTest.java  报错
```java
package com.liaoxx.spring_hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringHelloApplicationTests {
    @Resource
    DataSource dataSource;
    @Test
    public void contextLoads() {
        //System.out.println("打印dataSource,getClass-----------------------");
        System.out.println(dataSource.getClass());
        //System.out.println("打印dataSource,getClass-----------------------");
    }

}

```

>报错代码 部分 如下
```text

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2019-03-27 02:00:50.021 ERROR 7280 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to bind properties under 'spring.datasource' to javax.sql.DataSource:

    Property: spring.datasource.filters
    Value: stat,wall,log4j
    【Origin: class path resource [application.properties]:32:27】
    Reason: org.apache.log4j.Priority

Action:

Update your application's configuration

2019-03-27 02:00:50.032 ERROR 7280 --- [           main] o.s.test.context.TestContextManager      : Caught exception while allowing TestExecutionListener [org.springframework.test.context.web.ServletTestExecutionListener@1722011b] to prepare test instance [com.liaoxx.spring_hello.SpringHelloApplicationTests@5b852b49]

```

>报错关键点  【Origin: class path resource [application.properties]:32:27】  
错误在 application.properties  的32行 : * spring.datasource.filters=stat,wall,log4j

>原因：
````text
网上查了下，没有找打相关的报错解决办法，所以在解决问题后，整理到网上，帮助有需要的朋友。
springboot整合druid时，引入了druid的数据源，在配置文件application.yml中配置了相关配置

根据报错提示在配置文件的24行，查看配置文件，该行代码是     filters: stat,wall,log4j

看报错原因Reason: org.apache.log4j.Logger，于是猜想少了log4j的相关依赖，在pom中引入相关依赖

<!-- https://mvnrepository.com/artifact/log4j/log4j -->
		<dependency>
		    <groupId>log4j</groupId>
		    <artifactId>log4j</artifactId>
		    <version>1.2.17</version>
		</dependency>
再次启动，成功！
--------------------- 
作者：Peter-OK 
来源：CSDN 
原文：https://blog.csdn.net/xingkongtianma01/article/details/81624313 
版权声明：本文为博主原创文章，转载请附上博文链接！
````