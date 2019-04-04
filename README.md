#spring_hello
  **项目介绍**
    
   
    
* * *
    
##连接数据库
    
 ###jdbc 连接数据库 的配置和测试
    
####1.在pom.xml 中生命依赖 jdbc 以及 mysql 驱动 
```xml
            <!--引入jdbc-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-jdbc</artifactId>
            </dependency>
            <!--引入mysql 驱动-->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
            </dependency>
```    
           
####2.在application.properties 中的配置
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
    
 ####3.测试 在SpringHelloApplicationTests.classs中测试
    
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

####4.java代码 执行 查询 获取的结果：
````java
package com.liaoxx.spring_hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

//@RestController //注解无法返回视图，默认返回JSON数据。
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    JdbcTemplate jdbcTemplate;   // 1.JdbcTemplate
    @RequestMapping("/querylist")
    public String queryUser(Map map){
      List<Map<String,Object>>  list= jdbcTemplate.queryForList("select * from  user where id >=355 and id<=358"); //2.获取 执行 查询 的结果
      map.put("list",list); //传递到视图
      System.out.println(list);
      return "/admin/manager/querylist"; //视图页面文件地址
    }
}

````


####5.遍历展示查询结果
````html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table >
    <tr th:each="prod : ${list}" >
        <td style="border: black 1px solid" th:text="${prod.id}">Onions</td>
        <td style="border: black 1px solid" th:text="${prod.user_name}">Onions</td>
        <td style="border: black 1px solid" th:text="${prod.nick_name}">Onions</td>
    </tr>
</table>
</body>
</html>
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
####jdbc:mysql连接数据库 时区 timezone 报错
#####1.报错页面详情
```
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Fri Mar 22 02:14:54 CST 2019
There was an unexpected error (type=Internal Server Error, status=500).
Failed to obtain JDBC Connection; nested exception is java.sql.SQLException: The server time zone value 'ä¸­å›½æ ‡å‡†æ—¶é—´'
 is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver 
 (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
```
#####2.原因：配置错误的spring.datasource.url = jdbc:mysql://127.0.0.1:3306/bswly?useUnicode=true&characterEncoding=utf-8&useLegacyDatetimeCode=false  没有配置时区

#####3.解决方案  补上时区参数：spring.datasource.url = jdbc:mysql://127.0.0.1:3306/database_name?useUnicode=true&characterEncoding=utf-8&useLegacyDatetimeCode=false&serverTimezone=UTC
*******************************

##Thymeleaf 视图模板引擎


###返回view页面出错的情景  返回字符串如 "/admin/login.html"
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
``````xml
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

````java
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
    @Autowired
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

####使用Mybatis  参照[Spring Boot（六）集成 MyBatis 操作 MySQL 8](https://segmentfault.com/a/1190000016374807)


>1.在pom.xml 文件 添加  Mybatis依赖包 以及相应的数据库驱动  [注意 低版本会出现 @MapperScan注解无法使用](https://blog.csdn.net/hzr0523/article/details/80191909) 

```xml
      <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
           <dependency>
               <groupId>org.mybatis.spring.boot</groupId>
               <artifactId>mybatis-spring-boot-starter</artifactId>
               <version>1.3.2</version>
           </dependency>

        <!--引入mysql 驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
```


>2.在application.properties 文件  配置 mapper 包名 
>注【Mapper是MyBatis的核心，是SQL存储的地方，也是配置数据库映射的地方。】

```text
#配置mapper包名
mybatis.type-aliases-package=com.liaoxx.spring_hello.mapper
```


>3.在程序入口 【 main( ) 】 添加注解@MapperScan("com.liaoxx.spring_hello.mapper")  |   直接在启动文件SpringbootApplication.java的类上配置@MapperScan，这样就可以省去，单独给每个Mapper上标识@Mapper的麻烦。

````java
package com.liaoxx.spring_hello;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.liaoxx.spring_hello.mapper")  //@MapperScan，可以省去单独给每个Mapper上标识@Mapper的麻烦。
@SpringBootApplication
public class SpringHelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringHelloApplication.class, args);
    }
}
````

>4

************
##日志