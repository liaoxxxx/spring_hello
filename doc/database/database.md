
## 连接数据库

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
        @Resource
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
    @Resource
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
