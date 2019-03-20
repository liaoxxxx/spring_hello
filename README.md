#spring_hello
  **项目介绍**
    
   ##**你好**
    
* * *
    
##连接数据库
    
 ###jdbc 连接数据库 的配置和测试
    
    
####1.在application.properties 中的配置
````yml
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
    
 ####2.测试 在SpringHelloApplicationTests.classs中测试
    
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



*******************************
*
*
*
##视图


###返回view页面出错的情景
####1.代码如下
````java
package com.liaoxx.spring_hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@Controller
public class AdminController {
    @ResponseBody
    @RequestMapping("/admin/login")
    public String Login(Map<String, Object> map){
        map.put("foo","bar");
        return "/admin/login.html";     //返回了视图页面
    }
}
````

* 第一步检查html文件无错误；
* 第二步检查 return "/admin/login.html";     //返回了视图页面的路径无错误

####2.解决方案 
``````
关于SpringBoot 如何返回一个视图页面(例如JSP)



首先需要在配置文件中配置这一段

spring:  
  mvc:
    view:
      prefix: /pages/
      suffix: .jsp



这个就跟springmvc的配置是一样的， 返回 main/webapp/pages/ 里的  jsp文件

配置完之后 如果访问相应的controller 还是没有跳到对应页面分一下俩种情况

1 , 如果是显示了一串数据，则需要查看相应controller 是否使用了@ResponseBody，
 
或者是@RestController  ， 如果加了这俩个注解的话则无法返回视图，默认返回JSON数据。

2，如果访问后是直接下载下来JSP页面的话，那么是因为JSP文件没有被解析，需要添加多个依赖

<dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
        <version>7.0.59</version>
    </dependency>
--------------------- 
作者：hllll_huang 
来源：CSDN 
原文：https://blog.csdn.net/hllll_huang/article/details/76151450 
版权声明：本文为博主原创文章，转载请附上博文链接！


``````

````
@RestController
@Controller
public class AdminController {
    @ResponseBody
    @RequestMapping("/admin/login")
    public String Login(Map<String, Object> map){
        map.put("foo","bar");
        return "/admin/login.html";     //返回了视图页面
    }
}
````
因为AdminController 使用了@ResponseBody， 或者是@RestController 注解无法返回视图，默认返回JSON数据。
