###Spring Boot 2.x（十二）：Swagger2的正确玩法
#####vi的技术博客 https://zhuanlan.zhihu.com/p/76991268
###Swagger2简介

> 简单的来说，Swagger2的诞生就是为了解决前后端开发人员进行交流的时候API文档难以维护的痛点，它可以和我们的Java程序完美的结合在一起，并且可以与我们的另一开发利器Spring Boot来配合使用。

####开始使用
#####第一步：导入POM文件

         <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency> 

        <!-- 这里使用 swagger-bootstrap-ui 替代了原有丑陋的ui，拯救处女座~ -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>swagger-bootstrap-ui</artifactId>
            <version>1.9.0</version>
        </dependency>
#####第二步：添加配置类

> 我们需要新增一个Swagger2Config 的配置类：

```java


/**
 *    Swagger2 配置类
 * @author vi    
 * @since 2019/3/6 8:31 PM
 */
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("indi.viyoung.viboot.*"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("viboot-swagger2")    //标题
                .description("Restful-API-Doc")    //描述
                .termsOfServiceUrl("https://www.cnblogs.com/viyoung") //这里配置的是服务网站，我写的是我的博客园站点~欢迎关注~
                .contact(new Contact("Vi的技术博客", "https://www.cnblogs.com/viyoung", "18530069930@163.com")) // 三个参数依次是姓名，个人网站，邮箱
                .version("1.0") //版本
                .build();
    }
}
```
#####第三步：在启动类中添加配置
> 注意一定要记得添加@EnableSwagger2注解

```java


/**
 * @author vi
 * @since 2019/3/6 6:35 PM
 */
@SpringBootApplication
@ComponentScan(value = "indi.viyoung.viboot.*")
@MapperScan(value = "indi.viyoung.viboot.swagger2.mapper")
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class ViBootSwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViBootSwaggerApplication.class, args);
    }
}
```

#####第四步：通过注解来完成API文档
######1. @Api
> 注解名称注解属性作用域属性作用@Apitags类说明该类的作用value类说明该类的作用

```java
@Api(value = "用户类控制器",tags="用户类控制器")
public class UserController {
  //...
}
```


######2 . @ApiOperation
>注解名称注解属性作用域属性作用@ApiOperation()value方法描述方法作用notes方法提示内容tags方法分组


```java
    @ApiOperation(value = "获取用户列表",notes = "获取用户列表")
    public List<User> get() {
         //...   
    }
```
######3. @ApiParam
> 注解名称注解属性作用域属性作用@ApiParam()name方法参数参数名value方法参数参数说明required方法参数是否必填


```java
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    public User get(@ApiParam(name="id",value="用户id",required=true) Long id) {
        log.info("GET..{}...方法执行。。。",id);
        return userService.getById(id);
    }
```

######4. @ApiModel && @ApiModelProperty
> 注解名称注解属性作用域属性作用@ApiModel()value类对象名description类描述@ApiModelProperty()value方法字段说明name方法属性名dataType方法属性类型required方法是否必填example方法举例hidden方法隐藏
>
```java
@ApiModel(value="user对象",description="用户对象user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户ID",example = "1000001",hidden=true)
    private Long id;

    @ApiModelProperty(value="用户名",required = true,dataType = "String")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;
}
```
######5. @ApiImplicitParam && @ApiImplicitParams
> `@ApiImplicitParam`可以单个用于方法至上，多个参数的话可以把`@ApiImplicitParam`放到`@ApiImplicitParams`中，这里只罗列`@ApiImplicitParam`的属性：
注解名称注解属性作用域属性作用@ApiImplicitParam()value方法参数说明name方法参数名dataType方法数据类型paramType方法参数类型example方法举例

```java
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    public void put(User user) {
        userService.updateById(user);
        log.info("PUT方法执行。。。");
    }
```
> 这里需要注意一点，我们并没有在注解中写图中圈中的两个参数，这个是去读取了我们刚刚为User类的注解，并将用户名设置为必填！

######6.@ApiResposne && @ApiResponses
> @ApiResponses与@ApiResponse的关系和@ApiImplicitParam && @ApiImplicitParams 的关系和用法都是类似的

> 注解名称注解属性作用域属性作用@ApiResponse()response方法返回类code方法返回码message方法返回信息examples方法例子

******************************
###错误:
#### 1. com.google.common.collect.FluentIterable.append(Ljava/lang/Iterable;)Lcom/go

> Springfox-Swagger升级到2.9.2导致的NoSuchMethodError异常 https://www.w3cschool.cn/swaggerbootstrapui/swaggerbootstrapui-5jpf32j7.html

#### 解决
> 排除低版本的guava即可.
```xml
<dependency>
<groupId>com.google.guava</groupId>
<artifactId>guava</artifactId>
<version>20.0</version>
<scope>compile</scope>
</dependency>
```

#### 2. SpringBoot访问doc.html页面404 https://www.w3cschool.cn/swaggerbootstrapui/swaggerbootstrapui-j1gi32j0.html

````java
@SpringBootApplication
public class SwaggerBootstrapUiDemoApplication  implements WebMvcConfigurer{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath*:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath*:/META-INF/resources/webjars/");
    }
}
````
