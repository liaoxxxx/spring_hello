##关于log4j

>1.引入log4j
```xml
 <!-- https://mvnrepository.com/artifact/log4j/log4j -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
```
>2.报错信息 （未配置log4j的配置文件）
```txt 

log4j:WARN No appenders could be found for logger (druid.sql.Connection).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
```
#####解决方案
````text
运行 Spring Boot 的Maven项目，运行程序出现log4j警告代码如下：

log4j:WARN No appenders could be found for logger (druid.sql.Connection).
log4j:WARN Please initialize the log4j system properly.

虽然不影响使用，但是看着还是不爽，也缺少了调试信息的输出，各种百度后发现，是未配置log4j的配置文件引起的。

需要把log4j.properties文件放在main文件夹的resources下，如图：

````
![webjars](/doc/imgs/2019020410434978.png)
````text
将下面的内容写入文件

1.应用于控制台 

log4j.rootLogger=DEBUG, stdout
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
2.应用于文件 
log4j.appender.FILE = org.apache.log4j.FileAppender 
log4j.appender.FILE.File = file.log 
log4j.appender.FILE.Append = false 
log4j.appender.FILE.layout = org.apache.log4j.PatternLayout 
log4j.appender.FILE.layout.ConversionPattern = [framework] % d - % c -%- 4r [ % t] %- 5p % c % x - % m % n 

# Use this layout for LogFactor 5 analysis 

3.应用于文件 
log4j.appender.FILE = org.apache.log4j.FileAppender 
log4j.appender.FILE.File = file.log 
log4j.appender.FILE.Append = false 
log4j.appender.FILE.layout = org.apache.log4j.PatternLayout 
log4j.appender.FILE.layout.ConversionPattern = [framework] % d - % c -%- 4r [ % t] %- 5p % c % x - % m % n 

因为是测试，我只选择了1，应用控制台,

在运行应该没问题,但是如果还是没用，那可能因为你的src不是source目录，需要设置一下，因为要确保log4j.properties这个文件一定放在source文件夹下
--------------------- 
作者：gbz2000 
来源：CSDN 
原文：https://blog.csdn.net/gbz2000/article/details/86762544 
版权声明：本文为博主原创文章，转载请附上博文链接！
````
