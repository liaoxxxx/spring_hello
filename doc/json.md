## json序列化及反序列化

<br>
<hr>

### 注意事项

<br>

#### 1.需要实现 `Serializable`接口

```java
package com.liaoxx.spring_hello.entity.system;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class SystemShopConfig implements Serializable {   //实现 Serializable接口

}

```

<br>

#### 2.下划线字段与驼峰字段冲突， ` com.alibaba.fastjson.annotation.JSONField`注解 映射json字符中的字段

```java
package com.liaoxx.spring_hello.entity.system;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class SystemShopConfig implements Serializable {

    @Getter
    @Setter
    @JSONField(name = "private_domain")  //JSONField`注解 映射json字符中的字段 
    public int privateDomain;

}

```

<br>

#### 3.在http接口中输出下划线字段

```json
{
  system: {
    private_domain: 1,  //输出下划线字段
  }
}
```

```java
package com.liaoxx.spring_hello.entity.system;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class SystemShopConfig implements Serializable {

    @Getter
    @Setter
    @JSONField(name = "private_domain")     //JSONField`注解 映射json字符中的字段
    @JsonProperty("private_domain")         //输出下划线字段
    public int privateDomain;

}

```