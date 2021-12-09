
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
``````text
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
