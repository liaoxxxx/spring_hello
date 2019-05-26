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
>3.报错信息 （日志jar包冲突报错：Class path contains multiple SLF4J bindings）
```txt 
"C:\Program Files\Java\jdk-11.0.1\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always -Dcom.sun.management.jmxremote -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.5\lib\idea_rt.jar=5936:C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.5\bin" -Dfile.encoding=UTF-8 -classpath D:\coding\spring_hello\target\classes;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot-starter-web\2.1.3.RELEASE\spring-boot-starter-web-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot-starter\2.1.3.RELEASE\spring-boot-starter-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot\2.1.3.RELEASE\spring-boot-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.1.3.RELEASE\spring-boot-autoconfigure-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.1.3.RELEASE\spring-boot-starter-logging-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\11828\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\11828\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.11.2\log4j-to-slf4j-2.11.2.jar;C:\Users\11828\.m2\repository\org\apache\logging\log4j\log4j-api\2.11.2\log4j-api-2.11.2.jar;C:\Users\11828\.m2\repository\org\slf4j\jul-to-slf4j\1.7.25\jul-to-slf4j-1.7.25.jar;C:\Users\11828\.m2\repository\javax\annotation\javax.annotation-api\1.3.2\javax.annotation-api-1.3.2.jar;C:\Users\11828\.m2\repository\org\yaml\snakeyaml\1.23\snakeyaml-1.23.jar;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot-starter-json\2.1.3.RELEASE\spring-boot-starter-json-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.9.8\jackson-databind-2.9.8.jar;C:\Users\11828\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.9.0\jackson-annotations-2.9.0.jar;C:\Users\11828\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.9.8\jackson-core-2.9.8.jar;C:\Users\11828\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.9.8\jackson-datatype-jdk8-2.9.8.jar;C:\Users\11828\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.9.8\jackson-datatype-jsr310-2.9.8.jar;C:\Users\11828\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.9.8\jackson-module-parameter-names-2.9.8.jar;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot-starter-tomcat\2.1.3.RELEASE\spring-boot-starter-tomcat-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\org\apache\tomcat\embed\tomcat-embed-core\9.0.16\tomcat-embed-core-9.0.16.jar;C:\Users\11828\.m2\repository\org\apache\tomcat\embed\tomcat-embed-el\9.0.16\tomcat-embed-el-9.0.16.jar;C:\Users\11828\.m2\repository\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.16\tomcat-embed-websocket-9.0.16.jar;C:\Users\11828\.m2\repository\org\hibernate\validator\hibernate-validator\6.0.14.Final\hibernate-validator-6.0.14.Final.jar;C:\Users\11828\.m2\repository\javax\validation\validation-api\2.0.1.Final\validation-api-2.0.1.Final.jar;C:\Users\11828\.m2\repository\org\jboss\logging\jboss-logging\3.3.2.Final\jboss-logging-3.3.2.Final.jar;C:\Users\11828\.m2\repository\com\fasterxml\classmate\1.4.0\classmate-1.4.0.jar;C:\Users\11828\.m2\repository\org\springframework\spring-web\5.1.5.RELEASE\spring-web-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\spring-beans\5.1.5.RELEASE\spring-beans-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\spring-webmvc\5.1.5.RELEASE\spring-webmvc-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\spring-aop\5.1.5.RELEASE\spring-aop-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\spring-context\5.1.5.RELEASE\spring-context-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\spring-expression\5.1.5.RELEASE\spring-expression-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\com\jayway\jsonpath\json-path\2.4.0\json-path-2.4.0.jar;C:\Users\11828\.m2\repository\net\minidev\json-smart\2.3\json-smart-2.3.jar;C:\Users\11828\.m2\repository\net\minidev\accessors-smart\1.2\accessors-smart-1.2.jar;C:\Users\11828\.m2\repository\org\ow2\asm\asm\5.0.4\asm-5.0.4.jar;C:\Users\11828\.m2\repository\org\assertj\assertj-core\3.11.1\assertj-core-3.11.1.jar;C:\Users\11828\.m2\repository\net\bytebuddy\byte-buddy\1.9.10\byte-buddy-1.9.10.jar;C:\Users\11828\.m2\repository\org\springframework\spring-core\5.1.5.RELEASE\spring-core-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\spring-jcl\5.1.5.RELEASE\spring-jcl-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\webjars\jquery\3.3.1-2\jquery-3.3.1-2.jar;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot-starter-jdbc\2.1.3.RELEASE\spring-boot-starter-jdbc-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\com\zaxxer\HikariCP\3.2.0\HikariCP-3.2.0.jar;C:\Users\11828\.m2\repository\org\springframework\spring-jdbc\5.1.5.RELEASE\spring-jdbc-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\spring-tx\5.1.5.RELEASE\spring-tx-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\mybatis\spring\boot\mybatis-spring-boot-starter\1.3.2\mybatis-spring-boot-starter-1.3.2.jar;C:\Users\11828\.m2\repository\org\mybatis\spring\boot\mybatis-spring-boot-autoconfigure\1.3.2\mybatis-spring-boot-autoconfigure-1.3.2.jar;C:\Users\11828\.m2\repository\org\mybatis\mybatis\3.4.6\mybatis-3.4.6.jar;C:\Users\11828\.m2\repository\org\mybatis\mybatis-spring\1.3.2\mybatis-spring-1.3.2.jar;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot-starter-data-jpa\2.1.3.RELEASE\spring-boot-starter-data-jpa-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot-starter-aop\2.1.3.RELEASE\spring-boot-starter-aop-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\org\aspectj\aspectjweaver\1.9.2\aspectjweaver-1.9.2.jar;C:\Users\11828\.m2\repository\javax\transaction\javax.transaction-api\1.3\javax.transaction-api-1.3.jar;C:\Users\11828\.m2\repository\javax\xml\bind\jaxb-api\2.3.1\jaxb-api-2.3.1.jar;C:\Users\11828\.m2\repository\javax\activation\javax.activation-api\1.2.0\javax.activation-api-1.2.0.jar;C:\Users\11828\.m2\repository\org\hibernate\hibernate-core\5.3.7.Final\hibernate-core-5.3.7.Final.jar;C:\Users\11828\.m2\repository\javax\persistence\javax.persistence-api\2.2\javax.persistence-api-2.2.jar;C:\Users\11828\.m2\repository\org\javassist\javassist\3.23.1-GA\javassist-3.23.1-GA.jar;C:\Users\11828\.m2\repository\antlr\antlr\2.7.7\antlr-2.7.7.jar;C:\Users\11828\.m2\repository\org\jboss\jandex\2.0.5.Final\jandex-2.0.5.Final.jar;C:\Users\11828\.m2\repository\org\dom4j\dom4j\2.1.1\dom4j-2.1.1.jar;C:\Users\11828\.m2\repository\org\hibernate\common\hibernate-commons-annotations\5.0.4.Final\hibernate-commons-annotations-5.0.4.Final.jar;C:\Users\11828\.m2\repository\org\springframework\data\spring-data-jpa\2.1.5.RELEASE\spring-data-jpa-2.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\data\spring-data-commons\2.1.5.RELEASE\spring-data-commons-2.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\spring-orm\5.1.5.RELEASE\spring-orm-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\springframework\spring-aspects\5.1.5.RELEASE\spring-aspects-5.1.5.RELEASE.jar;C:\Users\11828\.m2\repository\mysql\mysql-connector-java\8.0.15\mysql-connector-java-8.0.15.jar;C:\Users\11828\.m2\repository\com\alibaba\druid\1.1.14\druid-1.1.14.jar;C:\Users\11828\.m2\repository\log4j\log4j\1.2.17\log4j-1.2.17.jar;C:\Users\11828\.m2\repository\org\apache\commons\commons-dbcp2\2.6.0\commons-dbcp2-2.6.0.jar;C:\Users\11828\.m2\repository\org\apache\commons\commons-pool2\2.6.1\commons-pool2-2.6.1.jar;C:\Users\11828\.m2\repository\org\springframework\boot\spring-boot-starter-thymeleaf\2.1.3.RELEASE\spring-boot-starter-thymeleaf-2.1.3.RELEASE.jar;C:\Users\11828\.m2\repository\org\thymeleaf\thymeleaf-spring5\3.0.11.RELEASE\thymeleaf-spring5-3.0.11.RELEASE.jar;C:\Users\11828\.m2\repository\org\thymeleaf\thymeleaf\3.0.11.RELEASE\thymeleaf-3.0.11.RELEASE.jar;C:\Users\11828\.m2\repository\org\attoparser\attoparser\2.0.5.RELEASE\attoparser-2.0.5.RELEASE.jar;C:\Users\11828\.m2\repository\org\unbescape\unbescape\1.1.6.RELEASE\unbescape-1.1.6.RELEASE.jar;C:\Users\11828\.m2\repository\org\thymeleaf\extras\thymeleaf-extras-java8time\3.0.3.RELEASE\thymeleaf-extras-java8time-3.0.3.RELEASE.jar;C:\Users\11828\.m2\repository\us\codecraft\webmagic-core\0.7.3\webmagic-core-0.7.3.jar;C:\Users\11828\.m2\repository\org\apache\httpcomponents\httpclient\4.5.7\httpclient-4.5.7.jar;C:\Users\11828\.m2\repository\org\apache\httpcomponents\httpcore\4.4.11\httpcore-4.4.11.jar;C:\Users\11828\.m2\repository\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;C:\Users\11828\.m2\repository\org\apache\commons\commons-lang3\3.8.1\commons-lang3-3.8.1.jar;C:\Users\11828\.m2\repository\us\codecraft\xsoup\0.3.1\xsoup-0.3.1.jar;C:\Users\11828\.m2\repository\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;C:\Users\11828\.m2\repository\org\slf4j\slf4j-log4j12\1.7.25\slf4j-log4j12-1.7.25.jar;C:\Users\11828\.m2\repository\commons-collections\commons-collections\3.2.2\commons-collections-3.2.2.jar;C:\Users\11828\.m2\repository\org\jsoup\jsoup\1.10.3\jsoup-1.10.3.jar;C:\Users\11828\.m2\repository\commons-io\commons-io\1.3.2\commons-io-1.3.2.jar;C:\Users\11828\.m2\repository\com\alibaba\fastjson\1.2.28\fastjson-1.2.28.jar;C:\Users\11828\.m2\repository\us\codecraft\webmagic-extension\0.7.3\webmagic-extension-0.7.3.jar;C:\Users\11828\.m2\repository\redis\clients\jedis\2.9.1\jedis-2.9.1.jar com.liaoxx.spring_hello.SpringHelloApplication
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/C:/Users/11828/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/C:/Users/11828/.m2/repository/org/slf4j/slf4j-log4j12/1.7.25/slf4j-log4j12-1.7.25.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [ch.qos.logback.classic.util.ContextSelectorStaticBinder]
```

#####解决方案
```text
问题定位：从日志里看到两个日志jar包冲突了
解决问题：根据日志给出的本地路径，进入到/C:/Users/11828/.m2/repository/下，删除其中一个，
删除后，重启即可。
```
