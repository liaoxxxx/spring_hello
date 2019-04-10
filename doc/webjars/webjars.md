#webjars包 的引入，配置以及使用

>##1.[webjars的官网](https://www.webjars.org/)

>##2.在pom.xml 配置要引入的webjars 包 ，以及相应的版本 ,以jquery为例
````xml
<!--引入jquery webjar-->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>jquery</artifactId>
            <version>3.3.1-2</version>
        </dependency>
```` 
>##3.使用： 在maven工具自动载入，索引完成后
访问 www.域名.com/webjars/
