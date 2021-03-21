

# 一、微服务阶段

javase:OOP
mysql:持久化
html+css+js+jquery+框架:视图
ssm框架：简化了开发流程，配置开始较为复杂

spring再简化:SpringBoot-jar：内嵌tomcat；微服务架构!
服务越来越多:SpringCloud

SpringBoot需要学习:是什么、配置如何编写yaml、自动装配***、集成web开发（业务核心）、集成数据库(druid)、分布式开发(Dubbo+zookeeper)、swagger(接口文档)、任务调度、SpringSecurity/shiro
linux
SpringCloud需要学习什么:微服务、springCloud入门、Restful风格、Eureka、Ribbon、Feign、Hystrix、Zuul路由网关、SpringCloud config:git

新服务架构:服务网络



# 二、SpringBoot概述

一、简化开发，约定大于配置
二、微服务是一种架构风格，要求我们再开发一个应用的时候，这个应用必须构建一系列小毒物的组合;可以通过http的方式进行互通
三、过去的单体应用架构:
  单体应用架构(all in one)是指我们将一个应用中的所有应用服务都封装在一个应用中。无论是ERP、CRM或其他系统，你都把数据库访问、web访问等各个功能放到一个war包中，
这样的好处是易于测试、开发；方便部署；当需要扩展时，只需要将war复制多分，然后放在多个服务器上，再做个负载均衡就行了。
缺点是哪怕修改一个非常小的地方，都需要停掉整个服务。对于大型应用，不可能把所有内容都放在一个应用里，如何维护、分工都是问题

四、微服务架构：打破之前all in one的架构方式，把每个功能元素独立出来。把独立出来的功能元素的动态组合，需要的功能元素才去拿来组合，需要多一些时可以整合多个功能元素，
所以微服务架构是对功能元素进行复制，而没有对整个应用进行复制
  好处:1、节省了调用资源 2、每个功能元素的服务都是可替代的、可独立升级的软件代码（高内聚，低耦合）





# 三、第一个SpringBoot程序:

到底有多简单
官方提供了一个快速生成的网站，IDEA集成了这个网站   https://start.spring.io/

一般开发直接在IDEA中创建:new project-->spring initializr-->开搞

插入依赖：

spring-boot-starter-web用于实现HTTP接口(该依赖中包含了SpringMVC)，使用tomcat作为默认嵌入式容器
spring-boot-starter-test编写单元测试的依赖包

starter是启动器



application.properties配置类:

```properties
# 应用名称
spring.application.name=springboot-02-yaml
# 应用服务 WEB 访问端口
server.port=8080
```



application类:

```java
//这个类本身就是Spring的组件
@SpringBootApplication
public class Springboot01HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01HellobootApplication.class, args);
    }

}
```

controller类:

```java
//自动装配
@RestController
public class HelloController {
    @RequestMapping("/hello")		//输入localhost:8080/hello可获得"hello,world"
    public String hello(){
        //调用业务，接收前端参数
        return "hello,world";	
    }
}
```



##### 注解:

@SpringBootApplication：申明让spring boot自动给程序进行必要的配置，这个配置等同于：

@Configuration ，@EnableAutoConfiguration 和 @ComponentScan 三个配置。

@ResponseBody：表示该方法的返回结果直接写入HTTP response body中，一般在异步获取数据时使用，用于构建RESTful的api。在使用@RequestMapping后，返回值通常解析为跳转路径，加上@esponsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。比如异步获取json数据，加上@Responsebody后，会直接返回json数据。该注解一般会配合@RequestMapping一起使用。

@Controller：用于定义控制器类，在spring项目中由控制器负责将用户发来的URL请求转发到对应的服务接口（service层），一般这个注解在类中，通常方法需要配合注解@RequestMapping。

@RestController：用于标注控制层组件(如struts中的action)，@ResponseBody和@Controller的合集。

@RequestMapping：提供路由信息，负责URL到Controller中的具体函数的映射。

@EnableAutoConfiguration：SpringBoot自动配置（auto-configuration）：尝试根据你添加的jar依赖自动配置你的Spring应用。例如，如果你的classpath下存在HSQLDB，并且你没有手动配置任何数据库连接beans，那么我们将自动配置一个内存型（in-memory）数据库”。你可以将@EnableAutoConfiguration或者@SpringBootApplication注解添加到一个@Configuration类上来选择自动配置。如果发现应用了你不想要的特定自动配置类，你可以使用@EnableAutoConfiguration注解的排除属性来禁用它们。

@ComponentScan：表示将该类自动发现扫描组件。个人理解相当于，如果扫描到有@Component、@Controller、@Service等这些注解的类，并注册为Bean，可以自动收集所有的Spring组件，包括@Configuration类。我们经常使用@ComponentScan注解搜索beans，并结合@Autowired注解导入。可以自动收集所有的Spring组件，包括@Configuration类。我们经常使用@ComponentScan注解搜索beans，并结合@Autowired注解导入。如果没有配置的话，Spring Boot会扫描启动类所在包下以及子包下的使用了@Service , @Repository等注解的类。

@Configuration：相当于传统的xml配置文件，如果有些第三方库需要用到xml文件，建议仍然通过@Configuration类作为项目的配置主类——可以使用@ImportResource注解加载xml配置文件。

@Import：用来导入其他配置类。

@ImportResource：用来加载xml配置文件。

@Autowired：自动导入依赖的bean

@Service：一般用于修饰service层的组件

@Repository：使用@Repository注解可以确保DAO或者repositories提供异常转译，这个注解修饰的DAO或者repositories类会被ComponetScan发现并配置，同时也不需要为它们提供XML配置项。

@Bean：用@Bean标注方法等价于XML中配置的bean。

@Value：注入Spring boot application.properties配置的属性的值。示例代码：

@Inject：等价于默认的@Autowired，只是没有required属性；

@Component：泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。

@Bean:相当于XML中的,放在方法的上面，而不是类，意思是产生一个bean,并交给spring管理。

@AutoWired：自动导入依赖的bean。byType方式。把配置好的Bean拿来用，完成属性、方法的组装，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。当加上（required=false）时，就算找不到bean也不报错。

@Qualifier：当有多个同一类型的Bean时，可以用@Qualifier(“name”)来指定。与@Autowired配合使用。@Qualifier限定描述符除了能根据名字进行注入，但能进行更细粒度的控制如何选择候选者，具体使用方式如下：

@Resource(name=”name”,type=”type”)：没有括号内内容的话，默认byName。与@Autowired干类似的事。

@MapperScan("xxx.xx.xx"):放在主启动类上，整合mybatis时可以选择这种方式去扫描对应的mapper类，对应的,mapper类就不用写@Mapper注解了，这两种方式互相替代

# 四、SpringBoot自动装配原理

##### (1)pom.xml中

1、spring-boot-dependencies：核心依赖在父工程中
2、我们在写或引入一些SpringBoot依赖的时候，不需要指定版本，就是因为有版本仓库
3、启动器：springboot的启动场景
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
比如spring-boot-starter-web会帮我们导入web环境所有的依赖
springboot会将所有的场景都变成一个个的启动器
  如果我们要使用什么功能，只要找到对应的启动器就行了



##### (2)主程序：

Application主类：

```java
@SpringBootApplication		//标注这个类是一个springboot的应用
public class Springboot01HellobootApplication {
    public static void main(String[] args) {
        //将springboot应用启动
        SpringApplication.run(Springboot01HellobootApplication.class, args);
    }
}
```

注解:

@SpringBootApplication下的衍生注解:

@SpringBootConfiguration ：springboot的配置--->@Configuration:spring配置类--->@Component：说明这也是一个spring的组件
@EnableAutoConfiguration ：自动导入配置--->@AutoConfigurationPackage ： 自动配置包 --->@Import({Registrar.class}) ：导入选择器‘包注册’--->@Import({AutoConfigurationImportSelector.class}) ： 自动配置导入选择--->List<String> configurations = this.getCandidateConfigurations(annotationMetadata, attributes); 获取所有的配置--->

​	

```java
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
   List<String> configurations = SpringFactoriesLoader.loadFactoryNames (this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
   Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.");
        return configurations;
    }  	//获取候选的配置
```



META-INF/spring.factories：这是一个自动配置的核心文件，在libaryries下的D:\Maven\maven_repository\org\springframework\boot\spring-boot-autoconfigure\2.3.7.RELEASE\spring-boot-autoconfigure-2.3.7.RELEASE.jar!\META-INF\spring.factories
点开可以看见里面有很多配置文件，里面如果没有的配置就需要手动配置了

Properties properties = PropertiesLoaderUtils.loadProperties(resource);  所有的资源加载到配置类中



**结论:SpringBoot所有的自动配置都在启动类中被扫描并加载:spring.factories所有的自动配置类都在这里面，但是不一定生效，要判断**
**条件是否成立。只要导入了对应的start，就有对应的启动器了，有了启动器，我们自动装配就会生效，然后就配置成功了！**



##### （3）步骤总结：

  1、springboot在启动的时候，从类路径下/META-INF/spring.factories获取指定的值；
  2、将这些自动配置的类导入容器，自动配置类就会生效，帮我们进行自动配置
  3、以前我们需要自动配置的东西，现在springboot帮我们做了
  4、整个javaEE,解决方案和自动配置的东西都在spring-boot-autoconfiguration-2.2.0.RELEASE.jar包下
  5、它会把所有需要导入的组件，以类名的方式返回，这些组件就会被添加到容器
  6、容器中也会存在非常多的xxxAutoConfiguration的文件(@Bean)，就是这些类给容器中导入了这个场景需要的所有组件；并自动配置 @Configuration,javaConfig!
  7、有了自动配置类，就免去了手动配置的工作
在我们的配置文件中能配置的东西，都存在一个固有的规律：xxxAutoConfiguration:默认值  xxxProperties和配置文件的属性绑定，我们就可以使用自定义的配置了



##### （4）自动装配原理的精髓：

  1、SpringBoot启动会加载大量的自动配置类
  2、我们看我们需要的功能有没有在SpringBoot默认写好的自动配置类中
  3、我们再来看这个自动配置类中到底配置了哪些组件(只要我们要用的组件存在在其中，我们就不需要再手动配置了)
  4、给容器中自动配置类添加组件的时候，会从properties类中获取某些属性，我们只需要在配置文件中指定这些属性的值即可
  xxxAutoConfiguration: 自动装配类，给容器中添加组件
  xxxProperties:封装配置文件中相关的属性，通过yaml等文件修改

*可以在yaml文件中通过debug: true，在输出日志中判断哪些属性生效，哪些没有生效



##### (5)画图:

![](F:\CS学习\SpringBoot\SpringBoot自动装配原理.png)

# 五、主启动类怎么运行:

SpringApplication.run的分析：这个方法主要分成两个部分，一是SpringApplication的实例化，二是run方法的执行

##### （1）SpringApplication类:

该类主要做了四件事:
    1、推断应用的类型是普通项目还是web项目
    2、查找并加载所有可用初始化器，设置到initializers属性中
    3、找出所有的应用程序监听器，设置到listeners属性中
    4、推断并设置main方法的定义类，找到运行的主类

```java
@SpringBootApplication		//加上这个类之后，就可以成为主启动类
public class WApplication {
    public static void main(String[] args) {
        
    }
}
```

##### （2）run()方法:

了解:

![](F:\CS学习\SpringBoot\SpringBoot主启动类运行原理.webp)

# 六、yaml

##### (1)properties:

语法结构： key = value

properties只能存键值对

官方不推荐使用properties,推荐使用yaml文件

并且IDEA用properties会乱码



##### (2)xml文件:



##### (3)yaml文件:

语法结构:

key: 空格value		空格必须存在，没有的话报错

yaml比xml文件更加轻巧

```yaml
server:
  port: 8080


#存对象
student:
  name: zhangsan
  age: 3

#对象的行内写法:
customer: {name: zhangsan,age: 3}
#这种写法和JavaScript很像

#写数组,需要"-"符号:
pets:
  - cat
  - dog
  - pig
#数组的行内写法:
pet: [cat,dog,pig]
```

yaml可以直接给实体类赋值：

springboot推荐使用yaml配置文件， @ConfigurationProperties支持更多的功能



##### (4)给属性赋值的几种方式:

a、原生的赋值方式:

```java
@Component      //把普通pojo实例化到spring容器中
public class Dog {
    @Value("旺财")    //spring中给属性赋值
    private String name;
    @Value("3")
    private Integer age;
}    
```

```java
	//springboot的测试类
@SpringBootTest
class Springboot02YamlApplicationTests {
    @Autowired      //自动装配
    private Dog dog;
    
    @Test
    void contextLoads() {
        System.out.println(dog);
    }

}
```

b、使用yaml之后:

1、首先在yaml进行配置:

```yaml
person:
  name: zhangsan
  age: 3
  happy: false
  birth: 2000/12/5
  maps: {k1: v1,k2: v2}     #注意这里的map的Map类型的书写方式
  lists:
    - code
    - music
    - girl
  dog:
    name: 旺财
    age: 3
```

2、在实体类中进行绑定:

```java
@Component
@ConfigurationProperties(prefix = "person")				//使用这种方式绑定配置文件中的实体类对象
public class Person {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}    
```

3、测试类测试:

```java
@SpringBootTest
class Springboot02YamlApplicationTests {

    @Autowired
    private Person person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }
}
```

c、指定配置文件:

```java
@Component
//不用yaml的话，可以使用下面的注解，加载指定的配置文件:
//@PropertySource(value = "classpath:csu.properties")     //即加载resources包下的csu.properties文件
public class Person {
    @Value("${name}")		//使用value注解手动赋值
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}    
```

d、使用SPEL表达式取出配置文件的值:

略



##### (5)JSR303校验

JSR303数据校验(了解):
  springboot中可以用 @validated来校验数据，如果数据异常则会统一抛出异常，方便异常中心统一处理（这个校验挺粗糙的）

  可以在网上找常用的数据检验的注解

```java
@Component
@Validated  //数据校验的注释
public class Person {
    @Email()	//有了这个邮箱的注解后，这个name输入的值必须是邮箱格式的，否则报错，可以用来防止前端输错数据
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}    
```



##### (6)yaml可以放置的路径:

yaml/properties可行的路径：
  1、file:./config/         	优先级最高
  2、file:./		 			   优先级第二
  3、classpath:/config/     优先级第三
  4、classpath:/            	优先级最低位置，也是默认的位置

![image-20210315231245862](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210315231245862.png)



```yaml
# yaml可以在一个文件中进行多环境的配置，使用符号"---"
server:
  port: 8084
spring:
  profiles:
    active: dev         #在默认端口中选择想要激活的端口进行使用

---
server:
  port: 8085
spring:
  profiles: dev                    #取名叫做dev

---
server:
  port: 8086
spring:
  profiles: test
```



同一路径下优先级:properties--->yaml--->yml



 springboot的多环节配置，可以选择激活哪一个配置文件,使用符号:spring.profiles.active=xxx



# 七、SpringBoot Web开发

##### (1)要解决的问题：

  1、导入静态资源
  2、首页
  3、jsp，模块引擎Thymeleaf
  4、装配扩展SpringMVC
  5、增删改查
  6、拦截器
  7、国际化



# 七.一 导入静态资源

![image-20210316070504304](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210316070504304.png)

##### (1)导入静态资源：

这四个目录都能被识别到

CLASSPATH_RESOURCE_LOCATIONS = {"classpath://META-INF/resources","classpath:/resources/","classpath:/static/","classpath:/public/"}

优先级：resource-->static-->public
 	 public下面放一些公共的资源，如大家都会访问的js
 	 static放一些图片
 	 resource放一些上传的文件



总结:在SpringBoot中可以使用以下方式处理静态资源:
  a、webjars				   												映射到localhost:8080/webjars/    一般不用
  b、public、static(默认使用)、/**、resources        映射到localhost:8080/



##### (2)定制首页和图标:

不重要



# 七.二、模板引擎Thymeleaf

![image-20210316071856290](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210316071856290.png)

SpringBoot项目首先是以jar的方式，不是war，用的还是嵌入式的Tomcat，所以现在是默认不支持jsp的。
  如果直接用纯静态页面的方式，会给开发带来非常大的麻烦。SpringBoot推荐使用模板引擎Thymeleaf



```xml
<dependency>
    <groupId>org.thymeleaf</groupId>
    <artifactId>thymeleaf-spring5</artifactId>
</dependency>
<dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-java8time</artifactId>
</dependency>
```

步骤：想要使用thymeleaf，只要导入对应的依赖、约束就可以了，导入后我们将html放在我们的templates目录下即可

命名空间:xmlns:th="[http://www.thymeleaf.org"](http://www.thymeleaf.org"/)

##### (1)语法：

1、th属性，常用th属性如下：

  1）th:text：文本替换；

  2）th:utext：支持html的文本替换。

  3）th:value：属性赋值 

  4）th:each：遍历循环元素

  5）th:if：判断条件，类似的还有th:unless，th:switch，th:case

  6）th:insert：代码块引入，类似的还有th:replace，th:include，常用于公共代码块提取的场景

  7）th:fragment：定义代码块，方便被th:insert引用

  8）th:object：声明变量，一般和*{}一起配合使用，达到偷懒的效果。

  9）th:attr：设置标签属性，多个属性可以用逗号分隔

10)   th:unless   除了，与if相反

2、标准表达式语法：

`${...}` 变量表达式，Variable Expressions

`@{...}` 链接表达式，Link URL Expressions

`#{...}` 消息表达式，Message Expressions

`~{...}` 代码块表达式，Fragment Expressions

`*{...}` 选择变量表达式，Selection Variable Expressions

其他去网上查

![img](https://upload-images.jianshu.io/upload_images/3957912-9885c279bc00746e.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/622/format/webp)

![img](https://upload-images.jianshu.io/upload_images/3957912-532c8174208ff5d8.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/623/format/webp)

![img](https://upload-images.jianshu.io/upload_images/3957912-852ab1a5baced776.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/623/format/webp)

##### (2)常用的内置对象：

ctx ：上下文对象。

vars ：上下文变量。

locale：上下文的语言环境。

request：（仅在web上下文）的 HttpServletRequest 对象。

response：（仅在web上下文）的 HttpServletResponse 对象。

session：（仅在web上下文）的 HttpSession 对象。

servletContext：（仅在web上下文）的 ServletContext 对象

##### (3)常用的内置方法:

strings：字符串格式化方法，常用的Java方法它都有。比如：equals，equalsIgnoreCase，length，trim，toUpperCase，toLowerCase，indexOf，substring，replace，startsWith，endsWith，contains，containsIgnoreCase等

numbers：数值格式化方法，常用的方法有：formatDecimal等

bools：布尔方法，常用的方法有：isTrue，isFalse等

arrays：数组方法，常用的方法有：toArray，length，isEmpty，contains，containsAll等

lists，sets：集合方法，常用的方法有：toList，size，isEmpty，contains，containsAll，sort等

maps：对象方法，常用的方法有：size，isEmpty，containsKey，containsValue等

dates：日期方法，常用的方法有：format，year，month，hour，createNow



示例:

```html
body>
<!--th:元素名 表示thymeleaf的,所有的html元素都可以被thymeleaf接管，接管了就可以使用thymeleaf的表达式-->
<div th:text="${msg}"></div>
<div th:utext="${msg}"></div>

<hr>

<h3 th:each="user:${users}">[[ ${user} ]]</h3>
<!--  <h3 th:each="user:${users}" th:text="${user}"></h3> -->
```



controller类:

```java
//在templates下的所有页面只能通过controller来跳转！
//这个需要模板引擎的支持 thymeleaf的依赖
@Controller
public class IndexController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","<h1>hellospringboot</h1>");

        model.addAttribute("users", Arrays.asList("girl","jing"));
        return "test";
    }
}
```

```html
<body>
<!--th:元素名 表示thymeleaf的,所有的html元素都可以被thymeleaf替换-->
<div th:text="${msg}"></div>
<div th:utext="${msg}"></div>

<hr>


<h3 th:each="user:${users}" th:text="${user}"></h3>
另一种写法:<h3 th:each="user:${users}">[[ ${user} ]]</h3>
```





# 七.三、MVC配置

##### （1）MymvcConfig类:

我们想自定义视图解析器，只需要自己写一个视图解析器并将它注册到bean里，spring会自动装配上

```java
//扩展springMVC：
@Configuration
//@EnableWebMvc    这个注解会导入一个类，DelegatingWebMvcConfiguration:从容器中获取所有的webmvcconfig,这个类继承了WebMvcComfigurationSupport类，会使自动配置失效(底层源码的设置)，所以最好不要随便添加这个注解，除非要自研start
public class MyMvcConfig implements WebMvcConfigurer {     //必须实现这个接口

    /*//ViewResolver 实现了视图解析器接口的类，我们就可以把它看作视图解析器
    @Bean	//使用这个注解将viewresolver放入spring容器中
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }
    
    //可以自定义了一个自己的视图解析器MyViewResolver
    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
     */

```

@EnableWebMvc ： 这个注解会导入一个类，DelegatingWebMvcConfiguration:从容器中获取所有的webmvcconfig,这个类继承了WebMvcComfigurationSupport类，会使自动配置失效(底层源码的设置)，所以最好不要随便添加这个注解，除非要自研start

```java
    //如果我们想要扩展MVC，官方建议我们这样去做：
    //视图跳转：
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/csu").setViewName("test");   //输入csu，会跳转到test页面
    }
}

//结论：如果想diy一些定制化的功能，只需要写这个组件，然后将它交给springboot，然后springboot就会帮我们自动装配
```



##### (2)配置格式化:

```properties
#自定义的配置日期格式化
spring.mvc.format.date-time=yyyy-MM-dd HH:mm:ss
```





# 七.四、MVC实践

##### (1)准备工作:

application.properties进行整体配置:

```properties
# 应用名称
spring.application.name=springboot-05
# 应用服务 WEB 访问端口
server.port=8080

#关闭默认图标
spring.mvc.favicon.enable=false

#关闭模板引擎thymeleaf的缓存
spring.thymeleaf.cache=false	不然不能完整显示


#我们的配置文件放在的真实位置
spring.messages.basename=i18n.login

#时间日期格式化
spring.mvc.format=yyyy-MM-dd
```

1、pojo类:模拟数据库系统:

```java
//部门表
public class Department {
    private Integer id;
    private String departmentName;
}    
//员工表
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;   //性别0女1男
    private Department department;
    private Date birth;
}    
```

2、dao层:模拟数据库

```java
//部门dao
@Repository     //交给spring托管
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> department = null;

    static {
        department = new HashMap<Integer, Department>();     //创建一个部门表

        department.put(101,new Department(101,"教学部"));
        department.put(102,new Department(102,"市场部"));
        department.put(103,new Department(103,"教研部"));
        department.put(104,new Department(104,"运营部"));
        department.put(105,new Department(105,"后勤部"));
    }
    //获得所有部门信息
    public Collection<Department> getDepartments(){
        return department.values();
    }

    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return department.get(id);
    }
}



//员工Dao
@Repository     //交给spring托管
public class EmpolyeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();     //创建一个员工表

        employees.put(1001,new Employee(1001,"张三","123456@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"李四","123457@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"王五","123458@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"赵六","123459@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"吴七","123450@qq.com",0,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee empolyee){
        if (empolyee.getId() == null){
            empolyee.setId(initId++);
        }
        empolyee.setDepartment(departmentDao.getDepartmentById(empolyee.getDepartment().getId()));//看看这段代码

        employees.put(empolyee.getId(),empolyee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过ID查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
```



##### (2)controller层:

indexcontroller:

```java
@Controller
public class IndexController {
    /*@RequestMapping({"/","/index.html"})            //这两种方式都可以转过去，因此弄成一个数组.不建议这样做，建议直接在config类中扩展MVC
    public String index(){
        return "index";
    }*/
}
```



MyMvcConfig:

```java
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //这里配置地址映射、请求的关系
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");		//这里设置首页的地址
        registry.addViewController("/index.html").setViewName("index");		//这里设置首页的地址
        registry.addViewController("/main.html").setViewName("dashboard");	//main地址跳到dashboard页面
    }


    //自定义的国际化组件生效了
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //设置拦截器的配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/css/*","/js/**","/img/**");
        //addPathPatterns("/**"),/**来的要拦截
        // excludePathPatterns("/index.html","/","/user/login","/css/*","/js/**","/img/**)，"/index.html","/","/user/login","/css/*","/js/**","/img/**来的不用拦截

    }
}
```

LoginController:

```java
@Controller
public class LoginController {
    //登录业务
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session)
    {
        //具体的业务:
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);        //为拦截器做准备
            return "redirect:/main.html";   //重定向到main.html，这个已经在config中映射好了
        }else{
            //告诉用户登录失败了
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }

    }


    //注销业务
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
```







##### (3)静态资源部分:

仔细观察有th:的项

index.html:

```html
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">
   <title>Signin Template for Bootstrap</title>
   
   <link th:href="@{/asserts/css/bootstrap.min.css}" rel="stylesheet">
  
   <link th:href="@{/asserts/css/signin.css}" rel="stylesheet">
</head>

<body class="text-center">
   <form class="form-signin" th:action="@{/user/login}">
      <img class="mb-4" th:src="@{/img/bootstrap-solid.svg}" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal" th:text="#{login.tip}">Please sign in</h1>           <!--th:text="#{login.tip}"是绑定i18n的设置，其他地方也一样设置，提交按钮不用text，用value-->

      <!--账号密码输入的消息回显-->
      <p style="color: red" th:text="${msg}" th:if="${not #strings.isEmpty(msg)}"></p>        <!--如果msg为空，不显示这个消息，不为空，才显示这行消息-->

      <input type="text" name="username" class="form-control" th:placeholder="#{login.username}" required="" autofocus="">
      <input type="password" name="password" class="form-control" th:placeholder="#{login.password}" required="">
      <div class="checkbox mb-3">
         <label>
         <input type="checkbox" value="remember-me"> [[#{login.remember}]]
       </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">[[#{login.btn}]]</button>
      <p class="mt-5 mb-3 text-muted">© 2017-2018</p>
      <a class="btn btn-sm" th:href="@{/index.html(l='zh_CN')}">中文</a>		页面国际化的设置
      <a class="btn btn-sm" th:href="@{/index.html(l='en_US')}">English</a>
   </form>

</body>
```



add.html:

```html
<!--只更改了<main>标签下面的内容-->
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">

   <title>Dashboard Template for Bootstrap</title>
   <!-- Bootstrap core CSS -->
   <link th:href="@{/asserts/css/bootstrap.min.css}" rel="stylesheet">

   <!-- Custom styles for this template -->
   <link th:href="@{/asserts/css/dashboard.css}" rel="stylesheet">
   <style type="text/css">
      
      @-webkit-keyframes chartjs-render-animation {
         from {
            opacity: 0.99
         }
         to {
            opacity: 1
         }
      }
      
      @keyframes chartjs-render-animation {
         from {
            opacity: 0.99
         }
         to {
            opacity: 1
         }
      }
      
      .chartjs-render-monitor {
         -webkit-animation: chartjs-render-animation 0.001s;
         animation: chartjs-render-animation 0.001s;
      }
   </style>
</head>

<body>
<!--   <div th:insert="~{dashboard::topbar}"></div>         插入dashboard顶部导航栏-->
<!--th:insert和th:replace都可以用来处理公共部分-->
<!--替换成commons里面的顶部导航栏-->
<div th:replace="~{common/commons::topbar}"></div>

   <div class="container-fluid">
      <div class="row">
         <!--     <div th:insert="~{dashboard::sidebar}"></div>           插入dashboard侧边栏-->
         <!--替换成commons里面的侧边栏-->
         <div th:replace="~{common/commons::sidebar(active='list.html')}"></div>        <!--接收哪个按钮被选中了-->

         <!--员工的表格-->
         <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <form th:action="@{/emp}" method="post">
               <div class="form-group">
                  <label>lastName</label>
                  <input type="text" name="lastName" class="form-group" placeholder="kuangshen">
               </div>
               <div class="form-group">
                  <label>Email</label>
                  <input type="email" name="email" class="form-control" placeholder="22423324@qq.com">
               </div>
               <div class="form-group">
                  <label>Gender</label> <br>
                  <div class="form-check form-check-inline">
                     <input class="form-check-input" type="radio" name="gender" value="1">
                     <label class="form-check-label">男</label>
                  </div>
                  <div class="form-check form-check-inline">
                     <input class="form-check-input" type="radio" name="gender" value="0">
                     <label class="form-check-label">女</label>
                  </div>
               </div>
               <div class="form-group">
                  <label>department</label>
                  <select class="form-control" name="department.id">    <!--注意，department是一个对象，需要其id属性-->
                     <option th:each="dept:${departments}" th:text="${dept.getDepartmentName()}" th:value="${dept.getId()}"></option><!--遍历获取显示所有部门的信息,text是显示的值，value是实际真实的值-->

                  </select>
               </div>
               <div class="form-group">
                  <label>Birth</label>
                  <input type="text" name="birth" class="form-control" placeholder="kuangstudy">
               </div>
               <button type="submit" class="btn btn-primary">添加</button>
            </form>
         </main>
      </div>
   </div>


   <script type="text/javascript" src="asserts/js/jquery-3.2.1.slim.min.js"></script>
   <script type="text/javascript" src="asserts/js/popper.min.js"></script>
   <script type="text/javascript" src="asserts/js/bootstrap.min.js"></script>

   <!-- Icons -->
   <script type="text/javascript" src="asserts/js/feather.min.js"></script>
   <script>
      feather.replace()
   </script>

   <!-- Graphs -->
   <script type="text/javascript" src="asserts/js/Chart.min.js"></script>
   <script>
      var ctx = document.getElementById("myChart");
      var myChart = new Chart(ctx, {
         type: 'line',
         data: {
            labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            datasets: [{
               data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
               lineTension: 0,
               backgroundColor: 'transparent',
               borderColor: '#007bff',
               borderWidth: 4,
               pointBackgroundColor: '#007bff'
            }]
         },
         options: {
            scales: {
               yAxes: [{
                  ticks: {
                     beginAtZero: false
                  }
               }]
            },
            legend: {
               display: false,
            }
         }
      });
   </script>
```



list.html:

```html
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">

   <title>Dashboard Template for Bootstrap</title>
   <!-- Bootstrap core CSS -->
   <link th:href="@{/asserts/css/bootstrap.min.css}" rel="stylesheet">

   <!-- Custom styles for this template -->
   <link th:href="@{/asserts/css/dashboard.css}" rel="stylesheet">
   <style type="text/css">
      /* Chart.js */
      
      @-webkit-keyframes chartjs-render-animation {
         from {
            opacity: 0.99
         }
         to {
            opacity: 1
         }
      }
      
      @keyframes chartjs-render-animation {
         from {
            opacity: 0.99
         }
         to {
            opacity: 1
         }
      }
      
      .chartjs-render-monitor {
         -webkit-animation: chartjs-render-animation 0.001s;
         animation: chartjs-render-animation 0.001s;
      }
   </style>
</head>

<body>
<!--   <div th:insert="~{dashboard::topbar}"></div>         插入dashboard顶部导航栏-->
<!--th:insert和th:replace都可以用来处理公共部分-->
<!--替换成commons里面的顶部导航栏-->
<div th:replace="~{common/commons::topbar}"></div>

   <div class="container-fluid">
      <div class="row">
         <!--     <div th:insert="~{dashboard::sidebar}"></div>           插入dashboard侧边栏-->
         <!--替换成commons里面的侧边栏-->
         <div th:replace="~{common/commons::sidebar(active='list.html')}"></div>        <!--接收哪个按钮被选中了-->

         <!--员工的表格-->
         <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h2><a class="btn btn-sm btn-success" th:href="@{/emp}">添加员工</a></h2>

            <div class="table-responsive">
               <table class="table table-striped table-sm">
                  <thead>
                     <tr>
                        <th>id</th>
                        <th>lastName</th>
                        <th>email</th>
                        <th>gender</th>
                        <th>department</th>
                        <th>birth</th>
                        <th>操作</th>
                     </tr>
                  </thead>
                  <tbody>
                     <tr th:each="emp:${emps}">         <!--动态获取，把模型model中emps给表中emp-->
                        <td th:text="${emp.getId()}"></td>    <!--遍历的思想,展示员工数据-->
                        <td>[[${emp.getLastName()}]]</td>         <!--另一种写法-->
                        <td th:text="${emp.getEmail()}"></td>
                        <td th:text="${emp.getGender()==0?'女':'男'}"></td>        <!--性别部分记得转换-->
                        <td th:text="${emp.department.getDepartmentName()}"></td>
                        <td th:text="${#dates.format(emp.getBirth(),'yyyy-MM-dd HH:mm:ss')}"></td> <!--日期格式需要转换-->
                        <td>
                           <a class="btn btn-sm btn-primary" th:href="@{/emp/}+${emp.getId()}">编辑</a>
                           <a class="btn btn-sm btn-danger" th:href="@{/delemp/}+${emp.getId()}">删除</a>
                        </td>
                     </tr>
                  </tbody>
               </table>
            </div>
         </main>
      </div>
   </div>

   
   <script type="text/javascript" src="asserts/js/jquery-3.2.1.slim.min.js"></script>
   <script type="text/javascript" src="asserts/js/popper.min.js"></script>
   <script type="text/javascript" src="asserts/js/bootstrap.min.js"></script>

   <!-- Icons -->
   <script type="text/javascript" src="asserts/js/feather.min.js"></script>
   <script>
      feather.replace()
   </script>

   <!-- Graphs -->
   <script type="text/javascript" src="asserts/js/Chart.min.js"></script>
   <script>
      var ctx = document.getElementById("myChart");
      var myChart = new Chart(ctx, {
         type: 'line',
         data: {
            labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            datasets: [{
               data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
               lineTension: 0,
               backgroundColor: 'transparent',
               borderColor: '#007bff',
               borderWidth: 4,
               pointBackgroundColor: '#007bff'
            }]
         },
         options: {
            scales: {
               yAxes: [{
                  ticks: {
                     beginAtZero: false
                  }
               }]
            },
            legend: {
               display: false,
            }
         }
      });
   </script>

</body>
```



update.html:

```html
<!--只更改了<main>标签下面的内容-->
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">

   <title>Dashboard Template for Bootstrap</title>
   <!-- Bootstrap core CSS -->
   <link th:href="@{/asserts/css/bootstrap.min.css}" rel="stylesheet">

   <!-- Custom styles for this template -->
   <link th:href="@{/asserts/css/dashboard.css}" rel="stylesheet">
   <style type="text/css">
      /* Chart.js */
      
      @-webkit-keyframes chartjs-render-animation {
         from {
            opacity: 0.99
         }
         to {
            opacity: 1
         }
      }
      @keyframes chartjs-render-animation {
         from {
            opacity: 0.99
         }
         to {
            opacity: 1
         }
      }      
      .chartjs-render-monitor {
         -webkit-animation: chartjs-render-animation 0.001s;
         animation: chartjs-render-animation 0.001s;
      }
   </style>
</head>

<body>
<!--   <div th:insert="~{dashboard::topbar}"></div>         插入dashboard顶部导航栏-->
<!--th:insert和th:replace都可以用来处理公共部分-->
<!--替换成commons里面的顶部导航栏-->
<div th:replace="~{common/commons::topbar}"></div>

   <div class="container-fluid">
      <div class="row">
         <!--     <div th:insert="~{dashboard::sidebar}"></div>           插入dashboard侧边栏-->
         <!--替换成commons里面的侧边栏-->
         <div th:replace="~{common/commons::sidebar(active='list.html')}"></div>        <!--接收哪个按钮被选中了-->

         <!--员工的表格-->
         <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <form th:action="@{/updateEmp}" method="post">
               <input type="hidden" name="id" th:value="${emp.getId()}">     <!--把id放在隐藏域中，不让别人动-->
               <div class="form-group">
                  <label>lastName</label>
                  <input th:value="${emp.getLastName()}" type="text" name="lastName" class="form-group" placeholder="kuangshen">
               </div>
               <div class="form-group">
                  <label>Email</label>
                  <input th:text="${emp.getEmail()}" type="email" name="email" class="form-control" placeholder="22423324@qq.com">
               </div>
               <div class="form-group">
                  <label>Gender</label> <br>
                  <div class="form-check form-check-inline">
                     <input th:checked="${emp.getGender()==1}" class="form-check-input" type="radio" name="gender" value="1">
                     <label class="form-check-label">男</label>
                  </div>
                  <div class="form-check form-check-inline">
                     <input th:checked="${emp.getGender()==0}" class="form-check-input" type="radio" name="gender" value="0">
                     <label class="form-check-label">女</label>
                  </div>
               </div>
               <div class="form-group">
                  <label>department</label>
                  <select class="form-control" name="department.id">    <!--注意，department是一个对象，需要其id属性-->
                     <option th:selected="${dept.getId()==emp.getDepartment().getId()}" th:each="dept:${departments}"
                           th:text="${dept.getDepartmentName()}"
                           th:value="${dept.getId()}"></option><!--遍历获取显示所有部门的信息,text是显示的值，value是实际真实的值-->

                  </select>
               </div>
               <div class="form-group">
                  <label>Birth</label>
                  <input th:value="${#dates.format(emp.getBirth(),'yyyy-MM-dd HH:mm')}" type="text" name="birth" class="form-control" placeholder="kuangstudy">
               </div>
               <button type="submit" class="btn btn-primary">修改</button>
            </form>
         </main>
      </div>
   </div>


   <script type="text/javascript" src="asserts/js/jquery-3.2.1.slim.min.js"></script>
   <script type="text/javascript" src="asserts/js/popper.min.js"></script>
   <script type="text/javascript" src="asserts/js/bootstrap.min.js"></script>

   <!-- Icons -->
   <script type="text/javascript" src="asserts/js/feather.min.js"></script>
   <script>
      feather.replace()
   </script>

   <!-- Graphs -->
   <script type="text/javascript" src="asserts/js/Chart.min.js"></script>
   <script>
      var ctx = document.getElementById("myChart");
      var myChart = new Chart(ctx, {
         type: 'line',
         data: {
            labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            datasets: [{
               data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
               lineTension: 0,
               backgroundColor: 'transparent',
               borderColor: '#007bff',
               borderWidth: 4,
               pointBackgroundColor: '#007bff'
            }]
         },
         options: {
            scales: {
               yAxes: [{
                  ticks: {
                     beginAtZero: false
                  }
               }]
            },
            legend: {
               display: false,
            }
         }
      });
   </script>

</body>
```



404.html:404页面放在template下的error包，springboot会自动找到这个页面

```html
<html lang="en" xmlns:th="http://www.thymeleaf.org">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">

      <title>Dashboard Template for Bootstrap</title>
      <!-- Bootstrap core CSS -->
      <link th:href="@{/asserts/css/bootstrap.min.css}" rel="stylesheet">

      <!-- Custom styles for this template -->
      <link th:href="@{/asserts/css/dashboard.css}" rel="stylesheet">
      <style type="text/css">
         /* Chart.js */
         
         @-webkit-keyframes chartjs-render-animation {
            from {
               opacity: 0.99
            }
            to {
               opacity: 1
            }
         }
         
         @keyframes chartjs-render-animation {
            from {
               opacity: 0.99
            }
            to {
               opacity: 1
            }
         }
         
         .chartjs-render-monitor {
            -webkit-animation: chartjs-render-animation 0.001s;
            animation: chartjs-render-animation 0.001s;
         }
      </style>
   </head>

   <body>
      <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
         <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">Company name</a>
         <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
         <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
               <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">Sign out</a>
            </li>
         </ul>
      </nav>

      <div class="container-fluid">
         <div class="row">
            <nav class="col-md-2 d-none d-md-block bg-light sidebar">
               <div class="sidebar-sticky">
                  <ul class="nav flex-column">
                     <li class="nav-item">
                        <a class="nav-link active" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home">
                              <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                              <polyline points="9 22 9 12 15 12 15 22"></polyline>
                           </svg>
                           Dashboard <span class="sr-only">(current)</span>
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file">
                              <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                              <polyline points="13 2 13 9 20 9"></polyline>
                           </svg>
                           Orders
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart">
                              <circle cx="9" cy="21" r="1"></circle>
                              <circle cx="20" cy="21" r="1"></circle>
                              <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                           </svg>
                           Products
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users">
                              <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                              <circle cx="9" cy="7" r="4"></circle>
                              <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                              <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                           </svg>
                           Customers
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bar-chart-2">
                              <line x1="18" y1="20" x2="18" y2="10"></line>
                              <line x1="12" y1="20" x2="12" y2="4"></line>
                              <line x1="6" y1="20" x2="6" y2="14"></line>
                           </svg>
                           Reports
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers">
                              <polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>
                              <polyline points="2 17 12 22 22 17"></polyline>
                              <polyline points="2 12 12 17 22 12"></polyline>
                           </svg>
                           Integrations
                        </a>
                     </li>
                  </ul>

                  <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
              <span>Saved reports</span>
              <a class="d-flex align-items-center text-muted" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus-circle"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="8" x2="12" y2="16"></line><line x1="8" y1="12" x2="16" y2="12"></line></svg>
              </a>
            </h6>
                  <ul class="nav flex-column mb-2">
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                              <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                              <polyline points="14 2 14 8 20 8"></polyline>
                              <line x1="16" y1="13" x2="8" y2="13"></line>
                              <line x1="16" y1="17" x2="8" y2="17"></line>
                              <polyline points="10 9 9 9 8 9"></polyline>
                           </svg>
                           Current month
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                              <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                              <polyline points="14 2 14 8 20 8"></polyline>
                              <line x1="16" y1="13" x2="8" y2="13"></line>
                              <line x1="16" y1="17" x2="8" y2="17"></line>
                              <polyline points="10 9 9 9 8 9"></polyline>
                           </svg>
                           Last quarter
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                              <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                              <polyline points="14 2 14 8 20 8"></polyline>
                              <line x1="16" y1="13" x2="8" y2="13"></line>
                              <line x1="16" y1="17" x2="8" y2="17"></line>
                              <polyline points="10 9 9 9 8 9"></polyline>
                           </svg>
                           Social engagement
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                              <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                              <polyline points="14 2 14 8 20 8"></polyline>
                              <line x1="16" y1="13" x2="8" y2="13"></line>
                              <line x1="16" y1="17" x2="8" y2="17"></line>
                              <polyline points="10 9 9 9 8 9"></polyline>
                           </svg>
                           Year-end sale
                        </a>
                     </li>
                  </ul>
               </div>
            </nav>

            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
               <h1>404</h1>
            </main>
         </div>
      </div>

      
      <script type="text/javascript" src="asserts/js/jquery-3.2.1.slim.min.js" ></script>
      <script type="text/javascript" src="asserts/js/popper.min.js" ></script>
      <script type="text/javascript" src="asserts/js/bootstrap.min.js" ></script>

      <!-- Icons -->
      <script type="text/javascript" src="asserts/js/feather.min.js" ></script>
      <script>
         feather.replace()
      </script>

      <!-- Graphs -->
      <script type="text/javascript" src="asserts/js/Chart.min.js" ></script>
      <script>
         var ctx = document.getElementById("myChart");
         var myChart = new Chart(ctx, {
            type: 'line',
            data: {
               labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
               datasets: [{
                  data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
                  lineTension: 0,
                  backgroundColor: 'transparent',
                  borderColor: '#007bff',
                  borderWidth: 4,
                  pointBackgroundColor: '#007bff'
               }]
            },
            options: {
               scales: {
                  yAxes: [{
                     ticks: {
                        beginAtZero: false
                     }
                  }]
               },
               legend: {
                  display: false,
               }
            }
         });
      </script>

   </body>
```



dashboard.html:

```html
<html lang="en" xmlns:th="http://www.thymeleaf.org">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">

      <title>Dashboard Template for Bootstrap</title>
      <!-- Bootstrap core CSS -->
      <link th:href="@{/asserts/css/bootstrap.min.css}" rel="stylesheet">

      <!-- Custom styles for this template -->
      <link th:href="@{/asserts/css/dashboard.css}" rel="stylesheet">
      <style type="text/css">
         /* Chart.js */
         
         @-webkit-keyframes chartjs-render-animation {
            from {
               opacity: 0.99
            }
            to {
               opacity: 1
            }
         }
         
         @keyframes chartjs-render-animation {
            from {
               opacity: 0.99
            }
            to {
               opacity: 1
            }
         }
         
         .chartjs-render-monitor {
            -webkit-animation: chartjs-render-animation 0.001s;
            animation: chartjs-render-animation 0.001s;
         }
      </style>
   </head>

   <body>
      <!--顶部导航栏，因为选哪个板块这里都不会变，是公共的部分，因此可以把它抽取出来,然后在list页面中相同位置插入这个-->
      <!--   <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0" th:fragment="topbar">
         <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">[[${session.loginUser}]]</a>
         <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
         <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
               <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">Sign out</a>
            </li>
         </ul>
      </nav>     -->

      <!--替换成commons里面的顶部导航栏-->
      <div th:replace="~{common/commons::topbar}"></div>

      <div class="container-fluid">
         <div class="row">
            <!--替换成commons里面的侧边栏-->
            <div th:replace="~{common/commons::sidebar(active='main.html')}"></div>           <!--接收哪个按钮被选中了-->

            <!--侧边栏，因为选哪个板块这里都不会变，是公共的部分，因此可以把它抽取出来,然后在list页面中相同位置插入这个-->
             <!-- <nav class="col-md-2 d-none d-md-block bg-light sidebar" th:fragment="sidebar">
               <div class="sidebar-sticky">
                  <ul class="nav flex-column">
                     <li class="nav-item">
                        <a class="nav-link active" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home">
                              <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                              <polyline points="9 22 9 12 15 12 15 22"></polyline>
                           </svg>
                           Dashboard <span class="sr-only">(current)</span>
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file">
                              <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                              <polyline points="13 2 13 9 20 9"></polyline>
                           </svg>
                           Orders
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart">
                              <circle cx="9" cy="21" r="1"></circle>
                              <circle cx="20" cy="21" r="1"></circle>
                              <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                           </svg>
                           Products
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" th:href="@{/emps}">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users">
                              <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                              <circle cx="9" cy="7" r="4"></circle>
                              <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                              <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                           </svg>
                           员工管理
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bar-chart-2">
                              <line x1="18" y1="20" x2="18" y2="10"></line>
                              <line x1="12" y1="20" x2="12" y2="4"></line>
                              <line x1="6" y1="20" x2="6" y2="14"></line>
                           </svg>
                           Reports
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers">
                              <polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>
                              <polyline points="2 17 12 22 22 17"></polyline>
                              <polyline points="2 12 12 17 22 12"></polyline>
                           </svg>
                           Integrations
                        </a>
                     </li>
                  </ul>

                  <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
              <span>Saved reports</span>
              <a class="d-flex align-items-center text-muted" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus-circle"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="8" x2="12" y2="16"></line><line x1="8" y1="12" x2="16" y2="12"></line></svg>
              </a>
            </h6>
                  <ul class="nav flex-column mb-2">
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                              <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                              <polyline points="14 2 14 8 20 8"></polyline>
                              <line x1="16" y1="13" x2="8" y2="13"></line>
                              <line x1="16" y1="17" x2="8" y2="17"></line>
                              <polyline points="10 9 9 9 8 9"></polyline>
                           </svg>
                           Current month
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                              <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                              <polyline points="14 2 14 8 20 8"></polyline>
                              <line x1="16" y1="13" x2="8" y2="13"></line>
                              <line x1="16" y1="17" x2="8" y2="17"></line>
                              <polyline points="10 9 9 9 8 9"></polyline>
                           </svg>
                           Last quarter
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                              <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                              <polyline points="14 2 14 8 20 8"></polyline>
                              <line x1="16" y1="13" x2="8" y2="13"></line>
                              <line x1="16" y1="17" x2="8" y2="17"></line>
                              <polyline points="10 9 9 9 8 9"></polyline>
                           </svg>
                           Social engagement
                        </a>
                     </li>
                     <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                           <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                              <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                              <polyline points="14 2 14 8 20 8"></polyline>
                              <line x1="16" y1="13" x2="8" y2="13"></line>
                              <line x1="16" y1="17" x2="8" y2="17"></line>
                              <polyline points="10 9 9 9 8 9"></polyline>
                           </svg>
                           Year-end sale
                        </a>
                     </li>
                  </ul>
               </div>
              </nav>                -->



            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
               <div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                  <div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                     <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                  </div>
                  <div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                     <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                  </div>
               </div>
               <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                  <h1 class="h2">Dashboard</h1>
                  <div class="btn-toolbar mb-2 mb-md-0">
                     <div class="btn-group mr-2">
                        <button class="btn btn-sm btn-outline-secondary">Share</button>
                        <button class="btn btn-sm btn-outline-secondary">Export</button>
                     </div>
                     <button class="btn btn-sm btn-outline-secondary dropdown-toggle">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-calendar"><rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect><line x1="16" y1="2" x2="16" y2="6"></line><line x1="8" y1="2" x2="8" y2="6"></line><line x1="3" y1="10" x2="21" y2="10"></line></svg>
                This week
              </button>
                  </div>
               </div>

               <canvas class="my-4 chartjs-render-monitor" id="myChart" width="1076" height="454" style="display: block; width: 1076px; height: 454px;"></canvas>

               
            </main>

         </div>
      </div>

   
      <script type="text/javascript" src="asserts/js/jquery-3.2.1.slim.min.js" ></script>
      <script type="text/javascript" src="asserts/js/popper.min.js" ></script>
      <script type="text/javascript" src="asserts/js/bootstrap.min.js" ></script>

      <!-- Icons -->
      <script type="text/javascript" src="asserts/js/feather.min.js" ></script>
      <script>
         feather.replace()
      </script>

      <!-- Graphs -->
      <script type="text/javascript" src="asserts/js/Chart.min.js" ></script>
      <script>
         var ctx = document.getElementById("myChart");
         var myChart = new Chart(ctx, {
            type: 'line',
            data: {
               labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
               datasets: [{
                  data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
                  lineTension: 0,
                  backgroundColor: 'transparent',
                  borderColor: '#007bff',
                  borderWidth: 4,
                  pointBackgroundColor: '#007bff'
               }]
            },
            options: {
               scales: {
                  yAxes: [{
                     ticks: {
                        beginAtZero: false
                     }
                  }]
               },
               legend: {
                  display: false,
               }
            }
         });
      </script>

   </body>
```



commons.html(公共部分):

```html
<!--头部导航栏和侧边栏都是一样的，是公共的部分，因此可以提取出来-->

<!--头部导航栏-->
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0" th:fragment="topbar">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">[[${session.loginUser}]]</a>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" th:href="@{/user/logout}">注销</a>
        </li>
    </ul>
</nav>

<!--侧边栏-->
<nav class="col-md-2 d-none d-md-block bg-light sidebar" th:fragment="sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a th:class="${active=='main.html'?'nav-link active':'nav-link'}" th:href="@{/index.html}"><!--active属性可以配置高亮,此处是判断，收到的请求是main.html就高亮，否则是普通状态-->
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home">
                        <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                        <polyline points="9 22 9 12 15 12 15 22"></polyline>
                    </svg>
                    首页 <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file">
                        <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                        <polyline points="13 2 13 9 20 9"></polyline>
                    </svg>
                    Orders
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart">
                        <circle cx="9" cy="21" r="1"></circle>
                        <circle cx="20" cy="21" r="1"></circle>
                        <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                    </svg>
                    Products
                </a>
            </li>
            <li class="nav-item">
                <a th:class="${active=='list.html'?'nav-link active':'nav-link'}" th:href="@{/emps}">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users">
                        <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                        <circle cx="9" cy="7" r="4"></circle>
                        <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                        <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                    </svg>
                    员工管理
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bar-chart-2">
                        <line x1="18" y1="20" x2="18" y2="10"></line>
                        <line x1="12" y1="20" x2="12" y2="4"></line>
                        <line x1="6" y1="20" x2="6" y2="14"></line>
                    </svg>
                    Reports
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers">
                        <polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>
                        <polyline points="2 17 12 22 22 17"></polyline>
                        <polyline points="2 12 12 17 22 12"></polyline>
                    </svg>
                    Integrations
                </a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Saved reports</span>
            <a class="d-flex align-items-center text-muted" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus-circle"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="8" x2="12" y2="16"></line><line x1="8" y1="12" x2="16" y2="12"></line></svg>
            </a>
        </h6>
        <ul class="nav flex-column mb-2">
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                        <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                        <polyline points="14 2 14 8 20 8"></polyline>
                        <line x1="16" y1="13" x2="8" y2="13"></line>
                        <line x1="16" y1="17" x2="8" y2="17"></line>
                        <polyline points="10 9 9 9 8 9"></polyline>
                    </svg>
                    Current month
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                        <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                        <polyline points="14 2 14 8 20 8"></polyline>
                        <line x1="16" y1="13" x2="8" y2="13"></line>
                        <line x1="16" y1="17" x2="8" y2="17"></line>
                        <polyline points="10 9 9 9 8 9"></polyline>
                    </svg>
                    Last quarter
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                        <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                        <polyline points="14 2 14 8 20 8"></polyline>
                        <line x1="16" y1="13" x2="8" y2="13"></line>
                        <line x1="16" y1="17" x2="8" y2="17"></line>
                        <polyline points="10 9 9 9 8 9"></polyline>
                    </svg>
                    Social engagement
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text">
                        <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                        <polyline points="14 2 14 8 20 8"></polyline>
                        <line x1="16" y1="13" x2="8" y2="13"></line>
                        <line x1="16" y1="17" x2="8" y2="17"></line>
                        <polyline points="10 9 9 9 8 9"></polyline>
                    </svg>
                    Year-end sale
                </a>
            </li>
        </ul>
    </div>
</nav>
```

注意点：所有页面的静态资源都需要使用thymeleaf来接管

##### (4)i18n国际化:

```java
//这个方法控制i18n汉语与英语的切换
public class MyLocaleResolver implements LocaleResolver {
    //模仿源码中的写法

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数链接
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();       //如果没有请求就使用默认的：汉语

        //如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(language)){
            //zh_CN
            String[] split = language.split("_");//进行封装，得到一个数组
            //国家，地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }
    //写完之后把这个放到bean里面

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
```



##### (4)增删改查:

```java
//员工管理控制器
@Controller
public class EmployeeController {
    //查询所有员工
    @Autowired	//自动装配
    EmpolyeeDao empolyeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = empolyeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")           //限定死只能用get提交，restful风格
    public String toAddpage(Model model){
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/add";
    }

    @PostMapping("/emp")           //限定死只能用post提交，restful风格
    public String addEmp(Employee empolyee){
        //添加的操作
        empolyeeDao.save(empolyee);          //调用底层业务方法保存员工的信息

        return "redirect:/emps";
    }

    //去员工的修改页面
    @GetMapping("/emp/{id}")                  //链接形式的都是getmapping
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        //查出原来的数据
        Employee employee = empolyeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        empolyeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") int id){
        empolyeeDao.delete(id);
        return "redirect:/emps";
    }
}
```



# 七.五、拦截器interceptor

```java
//登录的拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，应该有用户的session，如果存在说明这个用户登录了
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null){      //没有登录
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
```

在MVCconfig中进行配置:

```java
//设置拦截器的配置
@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
            .excludePathPatterns("/index.html","/","/user/login","/css/*","/js/**","/img/**");
    //addPathPatterns("/**"),/**来的要拦截
    // excludePathPatterns("/index.html","/","/user/login","/css/*","/js/**","/img/**)，"/index.html","/","/user/login","/css/*","/js/**","/img/**来的不用拦截，

}
```



# 八、整合JDBC

##### (1)springdata

对于数据访问层，无论是SQL(关系型数据库)还是NOSQL(非关系型数据库)，SpringBoot底层都是采用**Spring Data**的方式进行统一处理
SpringData也是和spring boot、spring cloud等齐名的知名项目

  创建项目时依赖记得得勾选关系型数据库---JDBC API和驱动MySQL Driver



##### (2)普通方式连接jdbc：

application.properties配置文件中:

```properties
spring:
  datasource:
    username: root
    password: 123
    url: jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.jdbc.Driver
```

test测试类:

```java
@Autowired     //注入yaml中的datasource
DataSource dataSource;

@Test
void contextLoads() throws SQLException {
    //查看一下默认的数据源
    System.out.println(dataSource.getClass());    //未设置druid时,数据源是:class com.zaxxer.hikari.HikariDataSource(最快的)

    //获得数据库连接
    Connection connection = dataSource.getConnection();
    System.out.println(connection);

 
    connection.close();
    
    //提示:xxxx Template : SpringBoot已经配置好的模板bean，拿来即用.如jdbcTemplate,redisTemplate等
      
}
```



使用jdbc模板:

```java
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;   //JdbcTemplate是Spring对JDBC的封装，目的是使JDBC更加易于使用
    //数据源和配置我们已经完成了，所以可以直接使用

    
    //查询数据库的所有信息
    //没有实体类，数据库中的东西怎么获取？   使用万能的Map类
    @GetMapping("/userList")
    public List<Map<String,Object>> userlist(){
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    //增
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into mybatis.user(id,name,pwd) values (4,'小光','212456') ";
        jdbcTemplate.update(sql);	//不用接收返回值
        return "update-ok";
    }

    //改
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update mybatis.user set name=?,pwd=? where id=" + id;	//这段程序使用的是拼接
        //封装
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "222";
        jdbcTemplate.update(sql,objects);
        return "updateUser-ok";
    }


    //删
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id=?";
        jdbcTemplate.update(sql,id);
        return "deleteUser-ok";
    }
}
```



##### (3)整合自定义数据源:DruidDataSource:

  alibaba开源平台上的一个连接池实现，结合了C3P0 DBCP PROXOOL等DB池的优点，同时加入了日志监控
可以很好地监控DB池连接和SQL执行情况，天生就是针对监控而生地DB连接池

```xml
		<dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.21</version>
        </dependency>
```

hikari和druid是现在最先进的数据源



1、在application.yaml中配置druid:

```properties
spring:
  datasource:
    username: root
    password: 123
    url: jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.jdbc.Driver
    
    #配置druid连接池
    type: com.alibaba.druid.pool.DruidDataSource

    #druid数据源的一些专有配置
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true


    #***监控功能就是druid出众的地方：
      #配置监控统计拦截的filters，stat:监控统计;log4j：日志记录;wall：防御sql注入
      #如果允许时报错  java.lang.ClassNotFoundException: org.apache.log4j.Priority
      #则导入 log4j 依赖即可
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
```

配置druid的监控功能:

```java
@Configuration
public class DruidConfig {
    //与yaml配置文件中的datasource绑定
    @ConfigurationProperties(prefix = "spring.datasource")		//这里是"." 不是 ":"
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控功能，都是死代码.    相当于web.xml
    //因为SpringBoot内置了servlet容器，所有没有web.xml，替代方法:ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        
        //只要访问这个可以直接进入别人写好的后台监控页面
        //后台需要有人登录，账号密码配置
        HashMap<String,String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername","admin");     //登录的key是固定的loginUsername，不要写其他的
        initParameters.put("loginPassword","123456");	//同上

        //允许谁可以访问
        initParameters.put("allow","localhost");     //只有本机的人可以访问,参数为空代表所有人都可以访问

        //禁止谁能访问
        //initParameters.put("deny","192.168.11.123");    禁止这个ip地址的访问

        bean.setInitParameters(initParameters);    //设置初始化参数
        return bean;
        
        //启动后进入http://localhost:8080/druid网页，login和index页面阿里提供，这个页面可以监控我们其他页面的操作
    }


    //过滤功能filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //可以过滤哪些请求呢?
        Map<String,String> initParameters = new HashMap<>();
        initParameters.put("exclusion","*.js,*.css,/druid/*");     //这些不进行统计

        bean.setInitParameters(initParameters);
        return bean;
    }

}
```

启动后进入http://localhost:8080/druid网页，login和index页面阿里提供，这个页面可以监控我们其他页面的操作





# 九、整合mybatis

整合包:mybatis-spring-boot-starter

创建时选中依赖：web+JDBC API+MySQL Driver
pom多加一个mybatis-spring-boot-starter依赖





1、配置文件application.properties:

```properties
# 应用名称
spring.application.name=springboot-07-mybatis
# 应用服务 WEB 访问端口
server.port=8080
# 数据库驱动：
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
# 数据源名称
spring.datasource.name=defaultDataSource
# 数据库连接地址
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
# 数据库用户名&密码：
spring.datasource.username=root
spring.datasource.password=123

#整合mybatis，这就类似之前的mybatis-config.xml配置文件，现在都是整合到application.properties里了
mybatis.type-aliases-package=com.csu.springboot07mybatis.pojo		设置pojo中对应的实体类的别名
mybatis.mapper-locations=classpath:mybatis/mapper/*.xml				mapper.xml放在resources/mybatis/mapper包下
```

2、User实体类，略

3、UserMapper接口:

```java
@Mapper  //表示了这是一个mybatis的mapper类，便于spring扫描
@Repository       //Dao层注解
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
```

4、UserMapper.xml配置，以后这个映射配置最好放在resources包下面:

```xml
<mapper namespace="com.csu.springboot07mybatis.mapper.UserMapper">
    <select id="queryUserList" resultType="User">
        select * from user
    </select>

    <select id="queryUserById" resultType="User" useCache="true">	开启缓存(只是举个例子)
        select * from user where id=#{id}
    </select>

    <insert id="addUser" parameterType="User">
        insert into user (id,name,pwd) values (#{id},#{name},#{pwd})
    </insert>

    <update id="updateUser" parameterType="User">
        update user set name=#{name},pwd=#{pwd} where id=#{id}
    </update>

    <delete id="deleteUser" parameterType="int">
        delete from user where id=#{id}
    </delete>
```

5、controller层:

```java
@RestController		//暂时不与前端关联
public class UserController {

    @Autowired	//自动装配userMapper
    private UserMapper userMapper;

    //查询用户列表
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList){
            System.out.println(user);
        }
        return userList;
    }


    //添加一个用户
    @GetMapping("/addUser")
    public String addUser(){
        userMapper.updateUser(new User(5,"阿毛","123432"));
        return "ok";
    }
    //修改一个用户
    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(5,"阿毛","123221"));
        return "ok";
    }
    //根据id删除用户
    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(5);
        return "ok";
    }

}
```





# 十、SpringSecurity

##### (1)概述:

目前学过的关于安全的技术:过滤器filter、拦截器interceptor、druid

知名的安全框架:shiro/SpringSecurity

二者很像，功能差不多，除了类不一样、名字不一样

相同的功能：认证、授权(vip1、vip2、vip3等)



springsecurity简介：
  springsecurity是针对spring项目的安全框架，也是springboot底层安全模块默认的技术选型，可以实现强大的web安全控制，需要引入spring-boot-starter-security模块，进行少量配置



使用aop的方式横切进去，使用一个配置类自动进行判断

##### (2)实践:

1、依赖:

```xml
<!--导入springsecurity-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>         <!--核心包里有aop-->


```



2、controller层:

```java
@Controller
public class RouterController {
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "views/login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id){
        return "views/level1/" + id;               //根据获取的id选中是去level1中的哪个页面
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id){
        return "views/level2/" + id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id){
        return "views/level3/" + id;
    }
}
```

3、security的配置类:

```java
@EnableWebSecurity    //表示这个类已经被spring托管了
public class SecurityConfig extends WebSecurityConfigurerAdapter {		//继承这个类
    //"链式编程"
    //代码格式见SpringSecurity官方文档

    //一、授权
    @Override          //注意，重写的方法不要选错了
    protected void configure(HttpSecurity http) throws Exception {
        //需求：首页所有人都可以访问，但是功能页需要有相应的权限才能访问
        //认证请求首页可以访问,各等级访问需要各级权限：
        
        http.authorizeRequests()		//认证请求
                .antMatchers("/").permitAll()	//首页允许所有人进入，"/"是首页
                .antMatchers("/level1/**").hasRole("vip1")	//level1的必须要有vip1才能访问
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");     //死代码

        
        //没有权限会转到默认登录页面,需要开启登录的页面:
            //    /login
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");    //用户输入"/toLogin"也会跳转到"/login"

        //网站安全相关:
        http.csrf().disable();         //关闭防止csrf(跨站请求伪造),登出失败可能就是因为有csrf防护

        //注销功能logout,跳到首页,logout与index.html中的注销对应着
        //http.logout().deleteCookies("remove").invalidateHttpSession(true);      //移除完整的cookies，
        http.logout().logoutSuccessUrl("/");        //指定跳转到首页


        //开启记住我功能     实质是cookie的实现   默认保存两周
        http.rememberMe().rememberMeParameter("remember");
        //要在前端login.html中添加记住我的按钮
    }


    //二、认证
    //springsecurity5.0+中，新增了很多的加密方式，需要加密才能访问，无编码容易被反编译
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //以下数据正常应该在数据库中取得
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())          //从内存中验证，也可以选中从jdbc中进行验证.passwordEncoder给密码编码
        .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()          //and()进行拼接
        .withUser("root").password(new BCryptPasswordEncoder().encode("123457")).roles("vip1","vip2","vip3")
                .and()
        .withUser("guest").password(new BCryptPasswordEncoder().encode("123458")).roles("vip1");

    }
}
```

重要的类：
  WebSecurityConfigurerAdapter : 自定义Security策略
  AuthenticationManagerBuilder : 自定义认证策略
  @EnableWebSecurity : 开启WebSecurity模式            springboot中的规律: @Enablexxxx开启某个功能





4、想要实现某权限用户只能看到自己对应权限的内容，看不到别的权限用户的内容，需要将thymeleaf与security整合:

需要先导入相应的整合依赖:

```xml
<!--thymeleaf和springsecurity整合的包,导入后可以尝试在thymeleaf中进行security的操作-->
<dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-springsecurity4</artifactId>
    <version>3.0.4.RELEASE</version>
</dependency>
```

对应的额外的命名空间:

```html
xmlns:th="http://www.thymeleaf.org"
xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4"
```



```html
				<!--如果未登录-->
                <div sec:authorize="!isAuthenticated()">             <!--判断用户是否已经登录过了-->
                    <a class="item" th:href="@{/toLogin}">
                        <i class="address card icon"></i> 登录
                    </a>
                </div>

                <!--如果已登录:用户名+注销-->
                <div sec:authorize="isAuthenticated()">
                    <a class="item" >
                        用户名:<span sec:authentication="name"></span>
                       
                    </a>
                </div>

                <div sec:authorize="isAuthenticated()">
                    <a class="item" th:href="@{/logout}">
                        <i class="sign-out icon"></i> 注销
                    </a>
                </div>

```

```html
<div class="column" sec:authorize="hasRole('vip1')">      <!--假如有vip1的权限就显示这个模块，实现动态菜单的效果，菜单根据用户的角色动态地实现-->
    <div class="ui raised segment">
        <div class="ui">
            <div class="content">
                <h5 class="content">Level 1</h5>
                <hr>
                <div><a th:href="@{/level1/1}"><i class="bullhorn icon"></i> Level-1-1</a></div>
                <div><a th:href="@{/level1/2}"><i class="bullhorn icon"></i> Level-1-2</a></div>
                <div><a th:href="@{/level1/3}"><i class="bullhorn icon"></i> Level-1-3</a></div>
            </div>
        </div>
    </div>
</div>

<div class="column" sec:authorize="hasRole('vip2')">    <!--如果有vip2的权限就显示这个模块-->
    <div class="ui raised segment">
        <div class="ui">
            <div class="content">
                <h5 class="content">Level 2</h5>
                <hr>
                <div><a th:href="@{/level2/1}"><i class="bullhorn icon"></i> Level-2-1</a></div>
                <div><a th:href="@{/level2/2}"><i class="bullhorn icon"></i> Level-2-2</a></div>
                <div><a th:href="@{/level2/3}"><i class="bullhorn icon"></i> Level-2-3</a></div>
            </div>
        </div>
    </div>
</div>

<div class="column" sec:authorize="hasRole('vip3')">      <!--有vip3的权限就显示这个模块-->
    <div class="ui raised segment">
        <div class="ui">
            <div class="content">
                <h5 class="content">Level 3</h5>
                <hr>
                <div><a th:href="@{/level3/1}"><i class="bullhorn icon"></i> Level-3-1</a></div>
                <div><a th:href="@{/level3/2}"><i class="bullhorn icon"></i> Level-3-2</a></div>
                <div><a th:href="@{/level3/3}"><i class="bullhorn icon"></i> Level-3-3</a></div>
            </div>
        </div>
    </div>
</div>
```



5、开启记住我的功能:

本质就是cookie的实现

```java
//开启记住我功能     实质是cookie的实现   默认保存两周
http.rememberMe().rememberMeParameter("remember");
//rememberme丢了一个value进去

//要在前端login.html中添加记住我的按钮
```

```html
<div class="field">
    <input type="checkbox" name="remember"> 记住我
</div>
```





# 十一、Shiro

##### (1)概述:

Apache Shiro是一个java的安全（权限）框架。可以完成认证、授权、加密、会话管理、Web集成、缓存等
可以用在javase、javaee

  三大对象：
 	 Subject		用户
  	SecurityManager	管理所有用户
 	 Realm			连接数据

![image-20210316161651169](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210316161651169.png)









```xml
shiro核心包:
<dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-core</artifactId>
            <version>1.4.1</version>
</dependency>

shiro整合spring:
<dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring</artifactId>
            <version>1.4.1</version>
</dependency>

shiro整合thymeleaf:
<dependency>
            <groupId>com.github.theborakompanioni</groupId>
            <artifactId>thymeleaf-extras-shiro</artifactId>
            <version>2.0.0</version>
</dependency>
```



##### (2)快速入门:

shiro.ini:

```ini
# my luggage!!!" ;)), and role 'president'
presidentskroob = 12345, president
# user 'darkhelmet' with password 'ludicrousspeed' and roles 'darklord' and 'schwartz'
darkhelmet = ludicrousspeed, darklord, schwartz
# user 'lonestarr' with password 'vespa' and roles 'goodguy' and 'schwartz'
lonestarr = vespa, goodguy, schwartz

# -----------------------------------------------------------------------------
# Roles with assigned permissions
#
# Each line conforms to the format defined in the
# org.apache.shiro.realm.text.TextConfigurationRealm#setRoleDefinitions JavaDoc
# -----------------------------------------------------------------------------
[roles]
# 'admin' role has all permissions, indicated by the wildcard '*'
admin = *
# The 'schwartz' role can do anything (*) with any lightsaber:
schwartz = lightsaber:*
# The 'goodguy' role is allowed to 'drive' (action) the winnebago (type) with
# license plate 'eagle5' (instance specific id)
goodguy = winnebago:drive:eagle5
```

log4j.properties:

```properties
log4j.rootLogger=INFO, stdout

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d %p [%c] - %m %n

# General Apache libraries
log4j.logger.org.apache=WARN

# Spring
log4j.logger.org.springframework=WARN

# Default Shiro logging
log4j.logger.org.apache.shiro=INFO

# Disable verbose logging
log4j.logger.org.apache.shiro.util.ThreadContext=WARN
log4j.logger.org.apache.shiro.cache.ehcache.EhCache=WARN
```

Quickstart（不要细看）:

```java
public class Quickstart {

    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);
    
    public static void main(String[] args) {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //获取当前的用户对象：subject
        Subject currentUser = SecurityUtils.getSubject();

        //通过当前用户拿到session：
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("Retrieved the correct value! [" + value + "]");
        }

        //测试当前用户是否被认证：
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");//Token：令牌
            token.setRememberMe(true);        //设置记住我
            try {
                currentUser.login(token);     //执行登录操作
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }

            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //打印当前用户认证码：
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //测试角色：
        if (currentUser.hasRole("schwartz")) {
            log.info("May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }

        //粗粒度权限检查
        //test a typed permission (not instance-level)
        if (currentUser.isPermitted("lightsaber:wield")) {
            log.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //细粒度权限检查
        //a (very powerful) Instance Level permission:
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //注销功能
        currentUser.logout();

        System.exit(0);
    }
}
```

比较重要的方法:

Subject currentUser = SecurityUtils.getSubject()

Session session = currentUser.getSession()

currentUser.isAuthenticated()

currentUser.getPrincipal()

currentUser.hasRole()

currentUser.logout()







##### (3)实际项目:

1、shiro配置类:

```java
@Configuration
public class ShiroConfig {
    //三大核心要素:倒着配置，先创建realm对象，再接管对象DefaultWebSecurity，再连接前端ShiroFilterFactoryBean
    
    //对象一：ShiroFilterFactoryBean                      第3步
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);      //同下一方法

        //添加shiro的内置过滤器
        /*
            anno:无须认证即可访问
            authc:必须认证才可访问
            user:必须拥有 “记住我” 功能才能用
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        //授权，未授权则会报401错误
        filterMap.put("/user/add","perms[user:add]");  //只有user才能访问add页面
        filterMap.put("/user/update","perms[user:update]");

        filterMap.put("/user/*","authc");    //给user下面的页面设置拦截功能，必须认证才能访问user下的网页
        bean.setFilterChainDefinitionMap(filterMap);


        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        
        //设置未授权页面的请求
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    
    //对象二:DefaultWebSecurity                          第2步
    @Bean(name="securityManager")        //方法名是getDefaultWebSecurityManager，太长了，把bean的名字改短
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);        //userRealm已经被spring接管了，不能直接调用，要使用@Qualifier注解

        return securityManager;
    }



    //对象三:创建realm对象，需要自定义类，在UserRealm类中           		第1步        
    @Bean		//将这个类给spring托管
    public UserRealm userRealm(){
        return new UserRealm();
    }



    //整合shiroDialect:用来整合shiro和thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
```

UserRealm:

```java
//自定义的realm，核心类        继承AuthorizingRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //一、授权的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");

        //给用户授予权限:
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:add");    //只要经过这一段就添加这个权限

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();     //拿到User对象了

        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    
    //二、认证的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");

        UsernamePasswordToken userToken =(UsernamePasswordToken) token;
        //连接真实数据库
        User user = userService.queryUserByName(userToken.getUsername());


        if (user == null){      //没有这个用户
            return null;        //UnknownAccountException报异常
        }

        
		// 与前端联动，session为空就显示登录的选项
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser",user);


        //密码可以加密:    MD5    MD5盐值加密
        //密码认证由Shiro自己进行

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
```



controller类:

```java
@Controller
public class MyController {
    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello,Shiro");
        return "index";
    }


    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }


    //跳转到登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据,弄成一个令牌加密
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);  //执行登录的方法，如果没有异常说明ok
            return "index";    //登录成功，进入首页
        }catch (UnknownAccountException e){          //用户名不存在
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){          //密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未经授权，无法访问此页面";
    }
}
```

##### (4)整合mybatis:

application.yaml配置druid:

```yaml
spring:
  datasource:
    username: root
    password: 123
    url: jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource


    #druid数据源专有配置
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

      
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
```

application.properties配置mybatis的映射:

```properties
# 应用名称
spring.application.name=shiro-springboot
# 应用服务 WEB 访问端口
server.port=8080

mybatis.type-aliases-package=com.csu.pojo
mybatis.mapper-locations=classpath:mapper/*.xml
```

```java
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
```

```xml
UserMapper.xml:
<mapper namespace="com.csu.mapper.UserMapper">
    <select id="queryUserByName" parameterType="String" resultType="User">
        select * from mybatis.user where name=#{name}
    </select>

</mapper>
```

```java
public interface UserService {
    public User queryUserByName(String name);
}
```

##### (5)Shiro整合thymeleaf:

```xml
命名空间:
xmlns:th="http://www.thymeleaf.org"
xmlns:shiro="http://www.thymeleaf.org/thymeleaf-extras-shiro">
```

```html
<div th:if="${session.loginUser==null}">        <!--session为空就显示登录的选项-->
        <a th:href="@{/tologin}">登录</a>
</div>


<div shiro:hasPermission="user:add">           <!--假设用户有add权限就显示add标签-->
    <a th:href="@{/user/add}">add</a>
</div>

<div shiro:hasPermission="user:update">
    <a th:href="@{/user/update}">update</a>    <!--假设用户有update权限就显示update标签-->
</div>
```



# 十二、任务

##### (1)异步任务:

比如我们在网站上发送邮件，后台会去发送邮件，此时前台会造成响应不动，直到邮件发送完毕，响应才会成功，所以我们一般会采用多线程的方式去处理这些任务。

我们如果想让用户直接得到消息，就在后台使用多线程的方式进行处理即可，但是每次都需要自己手动去编写多线程的实现的话，太麻烦了，我们只需要用一个简单的办法，在我们的方法上加一个简单的注解即可

三步:

```java
@Service
public class AsyncService {

    @Async		//告诉spring这是一个异步的方法，在运行时会开启线程池
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理...");
    }
}
```

```java
@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello(){
        asyncService.hello();   //停止3秒,转圈
        return "ok";
    }
}
```

```java
@EnableAsync        //开启异步功能的注解
@SpringBootApplication
public class Springboot10TestRenwuApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot10TestRenwuApplication.class, args);
    }

}
```

##### (2)邮件任务:

依赖:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

application.properties配置:

```properties
//想要发送协议，需要在QQ邮箱中开启POP3协议，验证完得到一个授权码，即下面的password(为了不让QQ密码直接暴露)
//这是发送者的配置
#mail配置
spring.mail.username=1402916604@qq.com
spring.mail.password=kvrgkmzelaajbaag
spring.mail.host=smtp.qq.com
#开启加密验证
spring.mail.properties.mail.stmp.ssl.enable=true

```



```java
@SpringBootTest
class Springboot10TestRenwuApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;		//自动导入邮件发送的类

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("新年快乐");
        mailMessage.setText("2021，再小的帆也能远航");
        mailMessage.setTo("1402916604@qq.com");
        mailMessage.setFrom("1402916604@qq.com");

        mailSender.send(mailMessage);
    }


    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        //new MimeMessage();或:
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装~
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        //正文
        helper.setSubject("新年快乐");
        helper.setText("<p style='color:red'>再小的帆也能远航</p>",true);

        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\xfs\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\xfs\\Desktop\\2.jpg"));

        helper.setTo("1402916604@qq.com");
        helper.setFrom("1402916604@qq.com");
        mailSender.send(mimeMessage);

    }


    /**
     * 把发送邮件封装成一个方法，方便调用，以后可以当作一个工具类(重要)
     * @param html 判断是否是html格式
     * @param subject
     * @param text
     * @throws MessagingException
     */
    public void setMailSender(Boolean html,String subject,String text) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);
        helper.setSubject(subject);
        helper.setText(text,true);
        helper.addAttachment("1.jpg",new File("C:\\Users\\xfs\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\xfs\\Desktop\\1.jpg"));
        helper.setTo("1402916604@qq.com");
        helper.setFrom("1402916604@qq.com");
        mailSender.send(mimeMessage);
    }
}
```

邮件任务一般放在controller中



##### (3)定时任务:

需要使用到cron表达式

两个接口:TaskScheduler(任务调度者)、TaskExecutor(任务执行者)。spring已经将其封装好了



启动类需要先行添加相应的注解:

```java
@EnableScheduling   	//开启定时功能的注解
@SpringBootApplication
public class Springboot10TestRenwuApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot10TestRenwuApplication.class, args);
    }
}
```

@Scheduled		确定什么时候执行的注解



```java
@Service
public class ScheduledService {
    //需求：在一段特定的时间执行这个方法     Timer~
    
    //Cron表达式:		
    //秒 分 时 日 月 周		可以在网上查找cron表达式生成器
    @Scheduled(cron = "30 15 10 * * ?")  //意思是每天的10点15分30秒执行一次
    //@Scheduled(cron = "30 0/5 10,18 * * ?")   //每天的10点和18点，每隔5分钟执行一次
    //@Scheduled(cron = "0 15 10 ? * 1-6")    //每个月的周一到周六10.15分执行一次
    public void hello(){
        System.out.println("hello,你被执行了");
    }
}
```

# 十三、短信验证码

阿里云 Accesskey---使用子用户AccessKey---创建用户组---里面的权限管理，添加权限。添加短信权限，搜索(AliyunDysmsReadOnlyAccess)---去用户里创建用户，重点记得开启编程访问

![image-20210320151018557](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210320151018557.png)

控制台搜索短信服务进入





# 十四、Swagger

##### (1)简介:

前后端如何交互？===>API接口
前后端相对独立，松耦合，前后端甚至可以部署再不同的服务器上。
产生一个问题：前后端集成联调，前端人员和后端人员无法做到；即使协商，需要尽早解决，导致问题集中爆发



Swagger：号称世界上最流行的Api框架。
  Restful API文档在线自动生成工具=>API文档与API定义同步更新
  直接运行，在线测试API接口
  支持多种语言：java、php。。。



在项目中使用Swagger需要springbox：swangger2+swaggerui

##### (2)SpringBoot集成swagger：

相关依赖:

```xml
<dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
</dependency>
```

1、新建一个Springboot-web项目
2、导入相关依赖

3、编写一个hello工程
4、配置Swagger==>Config
	

```java
	@Configuration
	@EnableSwagger2      //开启swagger2
	public class SwaggerConfig {
	}
```

5、之后可以测试运行
  访问http://localhost:8080/swagger-ui.html页面,页面会显示Swagger信息、接口信息、实体类信息

![image-20210320121538275](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210320121538275.png)



6、配置Swagger

```java
@Configuration
@EnableSwagger2      //开启swagger2，swagger2是新版的
public class SwaggerConfig {

    //配置了swagger的docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境:
        Profiles profiles = Profiles.of("dev","test");
        //通过环境监听变量environment.acceptsProfiles 判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("firstone")    //API文档分页"Select a spec"
              //.enable(false)         关闭接口，则无法访问swagger
                .enable(flag)         //根据flag的值判断是否开启API
                .select()
                //RequestHandlerSelectors配置要扫描接口的方式
                //basePackage:指定要扫描的包
                //any():扫描全部
                //none():都不扫描
                //withClassAnnotation:扫描类上的注解,参数是一个注解的反射对象
                //withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.csu.swagger.controller"))
                //过滤路径
                .paths(PathSelectors.ant("/csu/**"))
                .build();            //工厂模式，生成接口
    }


    //配置swagger信息=apiInfo,覆盖原来的配置信息
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("csu", "http://localhost:8080", "123456@qq.com");

        return new ApiInfo("SwaggerAPI日记", "这个在这里显示1",
                "v1.0", "http://localhost:8080",
                contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }



    //创建一个docket1，示范多个分组的功能
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
}
```

```java
//@Api(注释)
@ApiModel("用户实体类")          //给生成文档添加注释
public class User {
    @ApiModelProperty("用户名")
    public String username;
    @ApiModelProperty("密码")
    public String password;
}
```

```java
@ApiOperation("Hello控制类")            //Operation接口，放在类上的
@RestController
public class HelloController {
    //一个项目一定会有一个/error默认请求

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    //只要接口中的返回值中存在实体类，他就会被扫描到Swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }


    @ApiOperation("Hello控制类")     //放在方法上的operation接口
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello" + username;
    }

    @ApiOperation("Post测试类")
    @PostMapping(value = "/postt")
    public User postt(@ApiParam("用户名") User user){
        return user;
    }
}
```





十五、实现QQ第三方登录:

QQ互联平台