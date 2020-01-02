package com.liaoxx.spring_hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.liaoxx.spring_hello.mapper")  //@MapperScan，可以省去单独给每个Mapper上标识@Mapper的麻烦。
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SpringHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHelloApplication.class, args);
    }

}
