#**spring_hello**

> **项目介绍**

##**你好**

* * *

##连接数据库

##jdbc 连接数据库 的配置和测试


###1.在application.properties 中的配置
```` java
server.port=8088

spring.datasource.url = jdbc:mysql://127.0.0.1:3306/go_db

spring.datasource.username = root

spring.datasource.password = root       

spring.datasource.driverClassName = com.mysql.jdbc.Driver

spring.datasource.max-active=20

spring.datasource.max-idle=8

spring.datasource.max-maxWait=100

spring.datasource.min-idle=8

spring.datasource.initial-size=10
````

###2.测试 在SpringHelloApplicationTests.classs中测试

````java
package com.liaoxx.spring_hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SpringHelloApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads() {
        System.out.println("打印dataSource,getClass-----------------------");
        System.out.println(dataSource.getClass());
        System.out.println("打印dataSource,getClass-----------------------");
    }

}
````

* 运行测试时会出现报警
````
Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. 
The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
````

* 报警原因
````
异常错误：Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. 
The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.

这个问题 是在我整合项目过程中出现的，用了最新的mysql 连接驱动

以前版本的jdbc.properties

jdbc.driverClass   = com.mysql.dbc.Driver
jdbc.url      = jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT
jdbc.username = root
jdbc.password = root123

现在按照最新官方提示支持将com.mysql.jdbc.Driver  改为  com.mysql.cj.jdbc.Driver

jdbc.driverClass   = com.mysql.cj.jdbc.Driver
jdbc.url      = jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT
jdbc.username = root
jdbc.password = root123
--------------------- 
作者：不信成不了大牛 
来源：CSDN 
原文：https://blog.csdn.net/anaini1314/article/details/71157791 
版权声明：本文为博主原创文章，转载请附上博文链接！
````