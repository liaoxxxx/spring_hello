#使用spring data jpa
****
>##1.在pom.xml 引入spring data jpa

````xml
  <!-- spring data jpa-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-start-data-jpa</artifactId>
        </dependency>
````

>##2.配置Jpa数据源  略
````properties
#jpa 配置
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect

````

>##3.在 "entity" 包 创建【实体类】 
```java
package com.liaoxx.spring_hello.entity;
import javax.persistence.*;
@Entity     //标注为实体类
@Table(name="admin")      //标注表名为"admin";
public class Admin {
    @Id //标注为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //标注为自增主键
    private int  id;
    @Column         //标注为字段
    private String username;
    @Column
    private String password;
    /* 省略部分Column */
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
        /* 省略部getter() 和setter() */
}
```

>##4.创建Repository接口 继承JpaRepository

```java
package com.liaoxx.spring_hello.repository;

import com.liaoxx.spring_hello.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
//继承JpaRepository 来完成对数据库的操作
public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
```

