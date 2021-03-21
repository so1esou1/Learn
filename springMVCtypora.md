# 一、回顾MVC

##### （1）**什么是****MVC**

MVC是模型(Model)、视图(View)、控制器(Controller)的简写，是一种软件设计规范。

是将业务逻辑、数据、显示分离的方法来组织代码。

MVC主要作用是**降低了视图与业务逻辑间的双向偶合**。

MVC不是一种设计模式，**MVC****是一种架构模式**。当然不同的MVC存在差异。

**Model****（模型）：**数据模型，提供要展示的数据，因此包含数据和行为，可以认为是领域模型或

JavaBean组件（包含数据和行为），不过现在一般都分离开来：Value Object（数据Dao） 和 服务层

（行为Service）。也就是模型提供了模型数据查询和模型数据的状态更新等功能，包括数据和业务。

**View****（视图）：**负责进行模型的展示，一般就是我们见到的用户界面，客户想看到的东西。

**Controller****（控制器）：**接收用户请求，委托给模型进行处理（状态改变），处理完毕后把返回的模型

数据返回给视图，由视图负责展示。 也就是说控制器做了个调度员的工作



**最典型的****MVC就是JSP + servlet + javabean的模式。****

![image-20210314204720046](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210314204720046.png)

**Model1****时代**：。。。。。。、

**Model2****时代**：包括**视图、控制、模型。**

1. 用户发请求

2. Servlet接收请求数据，并调用对应的业务逻辑方法

3. 业务处理完毕，返回更新后的数据给servlet

4. servlet转向到JSP，由JSP来渲染页面

5. 响应给前端更新后的页面



**Controller****：控制器**

1. 取得表单数据

2. 调用业务逻辑

3. 转向指定的页面

**Model****：模型**

1. 业务逻辑

2. 保存数据的状态

**View****：视图**

1. 显示页面

Model2这样不仅提高的代码的复用率与项目的扩展性，且大大降低了项目的维护成本。Model 1模式的

实现比较简单，适用于快速开发小规模项目，Model1中JSP页面身兼View和Controller两种角色，将控

制逻辑和表现逻辑混杂在一起，从而导致代码的重用性非常低，增加了应用的扩展性和维护的难度。

Model2消除了Model1的缺点。

##### （2）**回顾****Servlet**

###### **MVC****框架要做哪些事情**

\1. 将url映射到java类或java类的方法 .

\2. 封装用户提交的数据 .

\3. 处理请求--调用相关的业务处理--封装响应数据 .

\4. 将响应的数据进行渲染 . jsp / html 等表示层数据 .



# 二、SpringMVC入门：

##### （1）概述：

###### Spring MVC的特点：

\1. 轻量级，简单易学

\2. 高效 , 基于请求响应的MVC框架

\3. 与Spring兼容性好，无缝结合（SpringMVC所有的配置都放到Spring中）

\4. 约定优于配置

\5. 功能强大：RESTful、数据验证、格式化、本地化、主题等

\6. 简洁灵活



Spring的web框架围绕**DispatcherServlet** [ 调度Servlet ] 设计。

DispatcherServlet的作用是将请求分发到不同的处理器。从Spring 2.5开始，使用Java 5或者以上版本的

用户可以采用基于注解形式进行开发，十分简洁；



用户视角：

![image-20210314210528093](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210314210528093.png)



###### springMVC的执行原理(重要需记):

![image-20210314205422812](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210314205422812.png)

##### （2）SpringMVC执行原理：

1、DispatcherServlet表示前置控制器，是整个SpringMVC的控制中心。用户发出请求，DispatcherServlet接收请求并拦截请求
  		假设请求url:http://localhost:8080/SpringMVC/hello   则hello表示控制器

​	DispatcherServlet也继承了Servlet,所以也是一个Servlet程序。

  2、HandlerMapping为处理器映射，DispatcherServlet调用HandlerMapping;HandlerMapping根据请求url查找handler
  3、HandlerExecution表示具体的Handler，其主要作用是根据url查找控制器
  4、HandlerExecution将解析后的信息传递给DispatcherServlet，如解析控制器映射等
  5、HandlerAdapter表示处理器适配器，其按照特定的规则去执行Handler
  6、Handler让具体的Controller执行
  7、Controller将具体的执行信息返回给HandlerAdapter,如ModelAndView
  	a、获取了ModelAndView的数据
        b、解析ModelAndView的视图
        c、拼接视图名字，找到对应的视图 /WEB-INF/jsp/hello
        d、将数据渲染到这个视图上
  8、HandlerAdapter将视图逻辑名或模型传递给DispatcherServlet
  9、DispatcherServlet调用视图解析器(ViewResolver)来解析HandlerAdapter传递的逻辑视图名
  10、视图解析器将解析的逻辑视图名传给DispatcherServlet
  11、DispatcherServlet根据视图解析器解析的视图结果，调用具体的视图
  12、最终视图呈现给用户



# 三、第一个SpringMVC程序**HelloSpring**

(1)注册web.xml：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <!--DispatcherServlet类是重点-->
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class> 
        <!--关联一个springmvc的配置文件：【spring-name】-servlet.xml-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc-servlet.xml</param-value>
        </init-param>
        <!--启动级别-1-->
        <load-on-startup>1</load-on-startup>
    </servlet>
    
    <!--/ 匹配所有的请求: (不包括.jsp) -->
    <!--/* 匹配所有的请求: (包括.jsp) -->
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    
    
    
</web-app>
```



springmvc-servlet.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans  xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>

    
    <!--视图解析图(ViewResolver)：DispatcherServlet给它的ModelAndView
	它的工作:
        1、获取了ModelAndView的数据
        2、解析ModelAndView的视图
        3、拼接视图名字，找到对应的视图 /WEB-INF/jsp/hello
        4、将数据渲染到这个视图上
    -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
        <!--前缀-->
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <!--后缀-->
        <property name="suffix" value=".jsp"/>
    </bean>

    <!--Handler-->
    <bean id="/hello" class="com.csu.controller.HelloController"/>


</beans>
```



HelloController:

```java
//先实现Controller接口
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        //封装对象，放在ModelAndView中，model
        mv.addObject("msg","HelloSpringMVC!");

        //封装要跳转的视图，放在ModelAndView中
        mv.setViewName("hello");    // : /WEB/INF/jsp/hello.jsp
        return mv;
    }

}
```



注意：启动前一定要在IDEA的项目结构中加入jar包



# 四、重头讲解SpringMVC的建构

##### 一、web.xml配置文件:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <!--配置DispatcherServlet:这个是SpringMVC的核心:请求分发器/前端控制器-->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        
        <!--DispatcherServlet要绑定Spring-MVC的配置文件-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc-servlet.xml</param-value>	和springmvc-servlet.xml文件绑定
        </init-param>
        
        <!--启动级别:1，服务器一启动就跟着启动-->
        <load-on-startup>1</load-on-startup>
    </servlet>

    
     <!--在springmvc中，/和/* 的区别:
            / 只匹配所有的请求，不会去匹配jsp页面
            /* 匹配所有的请求，包括jsp页面	(会跟springmvc发生嵌套死循环)
        -->
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
       
    </servlet-mapping>
</web-app>
```



##### 二、springmvc-servlet.xml文件:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--这个配置文件就相当于是DispatcherServlet请求转发器-->


    <!--讲原理时才用到的处理器映射器、处理器适配器，正常开发中不会进行配置,使用注解替代-->

    <!--1、处理器映射器-->
    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>

    
    <!--2、处理器适配器-->
    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>

    
    <!--3、视图解析器(不能省略):模板引擎 Thymeleaf、Freemarker-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>     <!--prefix是前缀,最后的/要记得加上，因为要进行拼接-->
        <property name="suffix" value=".jsp"/>     <!--suffix是后缀-->
    </bean>

    
    <!--BeanNameUrlHandlerMapping处理器需要根据bean的名字来找，以后也不会用这个处理器-->
    <bean id="/hello" class="com.csu.controller.HelloController" />

</beans>
```



三、Controller（实现了controller(web.mvc包下的)接口的都叫controller）:

```java
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        
        ModelAndView mv = new ModelAndView();
        //业务代码
        String result = "HelloSpringMVC";        //暂时用简单的业务

        mv.addObject("msg",result);        //封装

        //视图跳转
        mv.setViewName("test");      //设置视图的名字，跳转到test页面

        return mv;
    }
}
```



# 五、使用注解开发:

(1)web.xml配置文件，一直不更改:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">


    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc-servlet.xml</param-value>
        </init-param>

        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

</web-app>
```

(2)springmvc-servlet.xml文件进行修改以适应注解:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
        https://www.springframework.org/schema/mvc/spring-mvc.xsd">


    <!--1、注意:自动扫描包，让指定包下的注解生效，由IOC容器统一管理-->
    <context:component-scan base-package="com.csu.controller"/>

    
    <!--2、让Spring MVC不处理静态资源      .css  .js    .html     .mp3     .mp4-->
    <mvc:default-servlet-handler />


    <!--
        3、支持mvc注解驱动
            在spring中一般采用@RequestMapping注解来完成映射关系
            要想使@RequestMapping注解生效
            必须向上下文中注册DefaultAnnotationHandlerMapping
            和一个AnnotationMethodHandlerAdapter实例
            这两个实例分别在类级别和方法级别处理
            而annotation-driven配置帮助我们自动完成上述两个实例的注入
    -->
    <mvc:annotation-driven />

    <!--注意：实际开发中1、2、3其实也不用写出来-->

    <!--4、视图解析器，仍然需要配置-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/jsp/"/>     <!--prefix是前缀-->
    <property name="suffix" value=".jsp"/>     <!--suffix是后缀-->
    </bean>
	视图解析器中我们把所有的视图都放在/WEB-INF/目录下以保证视图安全，客户端不能直接访问


</beans>
```



(3)Controller类，注解主要在这个类中:

```java
@Controller   //controller控制器的注解，自动被spring管理了,也不需要再配bean
//@RestController   写这个的话不会匹配jsp页面，下面代码返回字符串
@RequestMapping("/hello")		//RequestMapping写在类上，代表下面的所有请求都转向hello界面,一般不会写死在这
public class HelloController {			//不需要再实现Controller类了
    @RequestMapping("/h1")    //用来处理请求地址映射，也就是在浏览器地址栏输入http://localhost:8080/springMVC_04_annotation_war_exploded/h1进入h1页面。这个请求指向h1页面
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","Hello,SpringMVCAnnotation!");		//通过model封装数据
        return "hello";    //会被视图解析处理
    }

}
```

以下四个注解都代表组件的意思
@Component      组件
@Service	service
@Controller	controller
@Repository	dao





@Controller:走视图解析器

@RestController:直接返回字符串

# 六、RESTFUL风格

Restful就是一个资源定位及资源操作的风格，不是标注和协议。基于这个风格设计的软件可以更简洁、有层次感，易于实现缓存等机制
相对安全，不会暴露程序的参数(安全)

```java
@Controller
public class RestfulController {
    //原来的方式:http://localhost:8080/springMVC_04_annotation/add?a=1&b=2
    /*@RequestMapping("/add")
    public String test1(int a, int b, Model model){
        int res = a + b;
        model.addAttribute("msg","结果为" + res);
        return "test";
    }*/

    
    //使用restful风格:
    @RequestMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model){       //路径变量,让参数的值可以直接绑定到URI模板变量上
        int res = a + b;
        model.addAttribute("msg","结果为" + res);
        return "test";
    }
    //地址变成:http://localhost:8080/4_Controller/1/2

    //还可以限定请求的类型:
    @RequestMapping(value="/add/{a}/{b}",method=RequestMethod.DELETE)	//限定为delete的方式,这种方式可以改成下面的组合注解，更清楚简单
}
```

方法级别的注解变体有如下几个： 组合注解

@GetMapping 

@PostMapping 

@PutMapping 

@DeleteMapping 

@PatchMapping 



# 七、重定向和转发

##### (1)**ModelAndView**:

正常的方法:

设置ModelAndView对象 , 根据view的名称 , 和视图解析器跳到指定的页面 .

页面唯一的位置 : {视图解析器前缀} + viewName +{视图解析器后缀}

```xml
<!-- 视图解析器 --> 
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"
      id="internalResourceViewResolver"> 
    <!-- 前缀 --> 
    <property name="prefix" value="/WEB-INF/jsp/" /> 
    <!-- 后缀 --> 
    <property name="suffix" value=".jsp" /> 
</bean>
```

对应的controller类 :

```java
public class ControllerTest1 implements Controller { 
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception { 
        //返回一个模型视图对象 
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("msg","ControllerTest1"); 
        mv.setViewName("test");
        return mv; 
    } 
}
```

因此位置是：/WEB-INF/jsp/test.jsp

##### (2)ServletAPI:

传统的方式

通过设置ServletAPI , 不需要视图解析器 .

\1. 通过HttpServletResponse进行输出

\2. 通过HttpServletResponse实现重定向

\3. 通过HttpServletResponse实现转发



```java
@Controller 
public class ResultGo { 
    @RequestMapping("/result/t1") 
    public void test1(HttpServletRequest req, HttpServletResponse rsp) throws IOException { 
        rsp.getWriter().println("Hello,Spring BY servlet API"); 
    }
    @RequestMapping("/result/t2") 
    public void test2(HttpServletRequest req, HttpServletResponse rsp) throws IOException { 
        rsp.sendRedirect("/index.jsp"); 
    }
    @RequestMapping("/result/t3") 
    public void test3(HttpServletRequest req, HttpServletResponse rsp) throws Exception { 
        //转发 
        req.setAttribute("msg","/result/t3");
        req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req,rsp);
    } 
}
```

##### (3)SpringMVC:

**通过****SpringMVC来实现转发和重定向** **-** 

###### 1、**无需视图解析器；**

测试前，需要将视图解析器注释掉(直接替代掉了)

```java
@Controller 
public class ResultSpringMVC { 
    @RequestMapping("/rsm/t1") 
    public String test1(){ 
        //转发 
        return "/WEB-INF/jsp/test.jsp"; 
        //或:
        //return "/index.jsp";		因为test.jsp在相应的包下，而index.jsp直接在web包下
    }
    
    @RequestMapping("/rsm/t2") 
    public String test2(){ 
        //转发二 
        return "forward:/index.jsp";	
    }
    
    @RequestMapping("/rsm/t3")
    public String test3(){ 
        //重定向
        return "redirect:/index.jsp";
    } 
}
```

###### 2、有视图解析器：

重定向 , 不需要视图解析器 , 本质就是重新请求一个新地方嘛 ,是一种拼接, 所以注意路径问题.

可以重定向到另外一个请求实现

```java
@Controller 
public class ResultSpringMVC2 {
    @RequestMapping("/rsm2/t1") 
    public String test1(){ 
        //转发 
        return "test"; 
    }
    
    @RequestMapping("/rsm2/t2") 
    public String test2(){ 
        //重定向 
        return "redirect:/index.jsp"; 			//拼接的结果:/WEB-INF/jsp/redirect:/index.jsp
        
        //return "redirect:hello.do"; 
        //hello.do为另一个请求/ 
    } 
}
```



# 八、接收请求参数及数据回显

##### (1)后端接收请求参数:

**1****、提交的域名称和处理方法的参数名一致**

提交数据 : http://localhost:8080/hello?name=kuangshen

处理方法:

```java
@RequestMapping("/hello") 
public String hello(String name){ 
    System.out.println(name);
    return "hello"; 
}
```



**2****、提交的域名称和处理方法的参数名不一致**

提交数据 : http://localhost:8080/hello?username=kuangshen

处理方法:

```java
//@RequestParam("username") : username提交的域的名称 .
@RequestMapping("/hello") 
public String hello(@RequestParam("username") String name){
    System.out.println(name); 
    return "hello"; 
}
```



**3****、提交的是一个对象**

要求提交的表单域和对象的属性名一致 , 参数使用对象即可

提交数据: http://localhost:8080/mvc04/user?name=kuangshen&id=1&age=15

处理方法:

```java
@RequestMapping("/user") 
public String user(User user){ 
    System.out.println(user); 
    return "hello"; 
}
```

后台输出 : User { id=1, name='kuangshen', age=15 }

执行流程:1、接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用

​				2、假设传递的是一个对象，会去匹配User对象的字段名，如果名字一致则OK，否则匹配不到

注意：如果使用对象的话，前端传递的参数名和对象名必须一致，否则就是null。 



##### （2）前端数据回显:

1、**通过****ModelAndView**

前面一直也是这种方式:



```java
public class ControllerTest1 implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //返回一个模型视图对象 
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","ControllerTest1");
        mv.setViewName("test"); 
        return mv; 
    } 
}
```

2、 **通过****Model**

也已经讲过:

```java
@RequestMapping("/ct2/hello") 
public String hello(@RequestParam("username") String name, Model model){ 
    //封装要显示到视图中的数据 
    //相当于req.setAttribute("name",name); 
    model.addAttribute("msg",name); 
    System.out.println(name); 
    return "test"; }
```



3、**通过****ModelMap**



```java
@RequestMapping("/hello") 
public String hello(@RequestParam("username") String name, ModelMap model){ 	//注意这里的model的类型
    //封装要显示到视图中的数据 
    //相当于req.setAttribute("name",name); 
    model.addAttribute("name",name); 
    System.out.println(name); 
    return "hello"; }
```

Model是精简版(大部分时候直接使用Model，方法少，适合存储数据)，ModelMap继承了LinkedHashMap，所有拥有LinkedHashMap的全部功能。
ModelAndView可以在存储数据的同时，进行设置返回的逻辑视图，进行控制展示层的跳转（一般只在实现接口时使用）

使用最多的是Model





##### （3）乱码过滤器:

配置SpringMVC提供的乱码过滤器:

```xml
<!--配置SpringMVC提供的乱码过滤器-->
<filter>
    <filter-name>encoding</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>encoding</filter-name>
    <url-pattern>/</url-pattern>
</filter-mapping>
```

# 九、JSON

jsontest.html:

```html
<script type="text/javascript">
    //编写一个javascript对象
    var user = {
        name:"lily",
        age:3,
        sex:"男"
    };

    //将js对象转换为json对象:
    var json = JSON.stringify(user);

    console.log(user);

    //将JSON对象转换为JavaScript对象
    var obj = JSON.parse(json);
    console.log(obj);

</script>
```



##### (1)jackson:

```java
@RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")
//@ResponseBody    //加上这个注解就不会走视图解析器，不会更改页面，会直接返回一个字符串，在@Controller有效，在@Rest Controller下就没有意义了

public String json1() throws IOException {
    
    //jackson下的ObjectMapper包
    ObjectMapper mapper = new ObjectMapper();
    //创建一个对象
    User user = new User("lily",3,"男");
    String str = mapper.writeValueAsString(user);	//把一个值变成字符串

    return user.toString();
}


//返回多个json对象
    @RequestMapping("/j2")
    public String json2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = new ArrayList<User>();
        User user1 = new User("lily",3,"男");
        User user2 = new User("lily",3,"男");
        User user3 = new User("lily",3,"男");
        User user4 = new User("lily",3,"男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str = mapper.writeValueAsString(userList);

        return str;
    }


//使用jackson输出日期
@RequestMapping("/j3")
    public String json3() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //使用ObjectMapper 来格式化输出
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);   //关闭原来的时间戳方式

        //自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        mapper.setDateFormat(sdf);

        Date date = new Date();
        return mapper.writeValueAsString(date);
    }
```

可以创建一个utils工具类，获取日期的话直接调用方法即可:

```java
public class JsonUtils {
    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }
    
    public static String getJson(Object object,String dateFormate){
        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳的方式:
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //自定义日期的格式:
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```



在springmvc-servlet.xml中解决jackson乱码问题(死代码):

```xml
<mvc:annotation-driven>
    <mvc:message-converters register-defaults="true">
        <bean class="org.springframework.http.converter.StringHttpMessageConverter">
            <constructor-arg value="UTF-8"/>
        </bean>
        <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
            <property name="objectMapper">
                <bean class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                    <property name="failOnEmptyBeans" value="false"/>
                </bean>
            </property>
        </bean>
    </mvc:message-converters>
</mvc:annotation-driven>
```





##### (2)fastjson:

alibaba出品

```java
@RequestMapping("/j4")    //FASTJSON使用示范,更简单
public String json4() throws IOException{

    List<User> userList = new ArrayList<User>();
    User user1 = new User("lily",3,"男");
    User user2 = new User("lily",3,"男");
    User user3 = new User("lily",3,"男");
    User user4 = new User("lily",3,"男");
    userList.add(user1);
    userList.add(user2);
    userList.add(user3);
    userList.add(user4);

    String string = JSON.toJSONString(userList);
    return string;
}
```



# 十、SSM整合1-mybatis层

##### (1)搭建环境

实体类:

```java
public class Books {
    private int bookID;
    private String bookName;
    private int booCounts;
    private String detail;
    public Books() {
    }
    public Books(int bookID, String bookName, int booCounts, String detail) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.booCounts = booCounts;
        this.detail = detail;
    }
    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public int getBooCounts() {
        return booCounts;
    }
    public void setBooCounts(int booCounts) {
        this.booCounts = booCounts;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    @Override
    public String toString() {
        return "Books{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", booCounts=" + booCounts +
                ", detail='" + detail + '\'' +
                '}';
    }
}
```

写接口和实现类:

```java
public interface BookMapper {
    //增加书
    int addBook(Books books);
    //删除书
    int deleteBookById(@Param("bookID") int id);
    //更新书
    int updateBook(Books books);
    //查询书
    Books queryBookById(int id);
    //查询全部书
    List<Books> queryAllBook();

    //搜索书籍
    Books queryBookByName(@Param("bookName") String bookName);
}


public interface BookService {
    //增加书
    int addBook(Books books);
    //删除书
    int deleteBookById(int id);
    //更新书
    int updateBook(Books books);
    //查询书
    Books queryBookById(int id);
    //查询全部书
    List<Books> queryAllBook();

    //搜索书籍
    Books queryBookByName(String bookName);
}


public class BookServiceImpl implements BookService{

    //service调dao层:组合Dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
```



BookMapper.xml配置:

```xml
<mapper namespace="com.csu.dao.BookMapper">
    <insert id="addBook" parameterType="Books">
        insert into ssmbuild.books (bookName,booCounts,detail)
        values (#{bookName},#{booCounts},#{detail});
    </insert>

    <delete id="deleteBookById" parameterType="int">
        delete from ssmbuild.books where bookID=#{bookID}
    </delete>

    <update id="updateBook" parameterType="Books">
        update ssmbuild.books set bookName=#{bookName},
        booCounts=#{booCounts},
        detail=#{detail}
        where bookID=#{bookID};
    </update>

    <select id="queryBookById" resultType="Books">
        select * from ssmbuild.books where bookID=#{bookID}
    </select>

    <select id="queryAllBook" resultType="Books">
        select * from ssmbuild.books
    </select>

    <select id="queryBookByName" resultType="Books">
        select * from ssmbuild.books where bookName = #{bookName}
    </select>
</mapper>
```



# 十一、SSM整合2-spring层

1. 配置**Spring****整合****MyBatis**，我们这里数据源使用c3p0连接池；

2. 我们去编写Spring整合Mybatis的相关的配置文件； spring-dao.xml

    spring-dao.xml：

   ```xml
   <!--1、关联数据库配置文件-->
   <context:property-placeholder location="classpath:database.properties"/>      <!--专门用来导入配置文件，可以写死-->  <!--直接是通过mybatis来读取配置文件的，现在我们用spring来读取了-->
   
   
   <!--2、连接池
       数据库连接池有:dbcp:半自动化操作，不能自动连接，需要手动连接
                     c3p0:自动化操作(自动化地加载配置文件，并且可以自动设置到对象中)
                     druid
                     hikari
   -->
   <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
       <property name="driverClass" value="${jdbc.driver}"/>
       <property name="jdbcUrl" value="${jdbc.url}"/>
       <property name="user" value="${jdbc.username}"/>
       <property name="password" value="${jdbc.password}"/>
       <!--以下是c3p0连接池的一部分独有的私有的属性-->
       <property name="maxPoolSize" value="30"/>   <!--设置最大连接池-->
       <property name="minPoolSize" value="10"/>   <!--设置最小连接池-->
       <property name="autoCommitOnClose" value="false"/>  <!--关闭连接后不自动commit-->
       <property name="checkoutTimeout" value="10000"/>   <!--获取连接超时时间-->
       <property name="acquireRetryAttempts" value="2"/>   <!--当获取连接失败重试次数-->
   
   </bean>
   
   
   <!--3、sqlSessionFactory-->
   <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
       <property name="dataSource" ref="dataSource"/>
       <!--绑定mybatis的配置文件-->
       <property name="configLocation" value="classpath:mybatis-config.xml"/>
   </bean>
   
   
   <!--4、可以配置dao接口扫描包，动态地实现Dao接口可以注入到Spring容器中,不用再写BookMapperImpl类了-->
   <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer" >
       <!--注入sqlSessionFactory-->
       <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
       <!--要扫描的dao包-->
       <property name="basePackage" value="com.csu.dao"/>
       <!--dao包下就不用再配置实现类了-->
   </bean>
   ```

3、 Spring整合service层(spring-service.xml)

```xml
<!--1、扫描service下的包-->
<context:component-scan base-package="com.csu.service"/>

<!--2、将我们的所有业务类注入到Spring，可以通过配置或者注解实现-->
<bean id="BookServiceImpl" class="com.csu.service.BookServiceImpl">
    <property name="bookMapper" ref="bookMapper"/>
</bean>

<!--3、声明式事务配置-->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <!--注入数据源-->
    <property name="dataSource" ref="dataSource"/>
</bean>

<!--4、aop连接事务支持-->
<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <tx:attributes>
        <tx:method name="*" propagation="REQUIRED"/>
    </tx:attributes>
</tx:advice>
<!--配置事务切入，可以在最后项目完毕前添加事务-->
<aop:config>
    <aop:pointcut id="txPointCut" expression="execution(* com.csu.dao.*.*(..))"/>
    <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>
</aop:config>
```



applicationContext.xml整合所有的配置文件到一个配置文件中:

```xml
<import resource="classpath:spring-dao.xml"/>
<import resource="classpath:spring-service.xml"/>
<import resource="classpath:spring-mvc.xml"/>
明显的三层架构
```



# 十二、SSM整合3-springMVC层

spring-mvc.xml配置文件:

```xml
<!--1、注解驱动-->
<mvc:annotation-driven/>

<!--2、静态资源过滤-->
<mvc:default-servlet-handler />               <!--这里要导入相应约束，不然识别不了-->

<!--3、扫描包:controller-->
<context:component-scan base-package="com.csu.controller"/>
<!--4、视图解析器-->
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/jsp"/>
    <property name="suffix" value=".jsp"/>
</bean>
```



最终的web.xml：

```xml
<!--注册DispatcherServlet-->
<servlet>
    <servlet-name>springmvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
    </init-param>
</servlet>
<servlet-mapping>
    <servlet-name>springmvc</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>

<!--乱码过滤-->
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>


<!--Session-->
<session-config>
    <session-timeout>15</session-timeout>
</session-config>
```





# 十三、SSM整合4-功能实现

1、所有书籍的页面:

```jsp
 <%--BootStrop美化页面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>书籍列表——————显示所有书籍</small>
                    </h1>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">		<%--4=12/3,只显示页面的三分之一--%>
                <%--toAddBook--%>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
            </div>
            <div class="col-md-4 column"></div>
            <!--临时新增一个搜索功能-->
            <div class="col-md-4 column">
                <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float: right">
                    <span style="color: red ; font-weight: bold">${error}</span>    <!--提示用户未搜到-->
                    <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称">
                    <%--placeholder属性在输入字段为空时显示，获得焦点时消失--%>
                    <input type="submit" value="查询" class="btn btn-primary">
                </form>
            </div>
        </div>

        <div class="row clearfix">
            <div class="row clearfix">
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <th>书籍编号</th>
                            <th>书籍名称</th>
                            <th>书籍数量</th>
                            <th>书籍详情</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%--书籍从数据库查询出来,从这个list中遍历出来 : foreach--%>
                        <c:forEach var="book" items="${list}">
                            <tr>
                                <td>${book.bookID}</td>
                                <td>${book.bookName}</td>
                                <td>${book.booCounts}</td>
                                <td>${book.detail}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/book/toUpdate?id=${book.bookID}">修改</a>			跳转到修改书籍的页面
                                    &nbsp; |  &nbsp;
                                    <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
```



添加书籍页面:

```jsp
<%--BootStrop美化页面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        <div class="form-group">
            <label >书籍名称:</label>
            <input type="text" name="bookName" class="form-control" required>    <!--有了required，必须填完才能提交表单-->
        </div>
        <div class="form-group">
            <label>书籍数量:</label>
            <input type="text" name="booCounts" class="form-control" required>
        </div>
        <div class="form-group">
            <label>书籍描述:</label>
            <input type="text" name="detail" class="form-control" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>
    </form>
</div>
</body>
```



更改书籍页面:

```jsp
<%--BootStrop美化页面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/" method="post">
        <%--出现的问题:我们提交了修改的sql请求
            初次考虑是事务问题，配置完毕事务依旧失败
            第二次查看SQL语句能否执行成功  SQL执行失败，修改未完成
        --%>
        <%--前端传递隐藏域--%>
        <input type="hidden" name="bookID" value="${QBook.bookID}">      <!--前台无法修改ID了，只能自增-->

        <div class="form-group">
            <label >书籍名称:</label>
            <input type="text" name="bookName" class="form-control" value="${QBook.bookName}" required>    <!--有了required，必须填完才能提交表单-->
        </div>
        <div class="form-group">
            <label>书籍数量:</label>
            <input type="text" name="booCounts" class="form-control" value="${QBook.booCounts}" required>
        </div>
        <div class="form-group">
            <label>书籍描述:</label>
            <input type="text" name="detail" class="form-control" value="${QBook.detail}" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>

    </form>

</div>
</body>
```



controller类:

```java
@Controller
@RequestMapping("/book")
public class BookController {
    //controller调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "/allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "/addBook";
    }

    //添加书籍的请求(使客户添加书籍的数据操作影响到数据库)
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>" + books);
        bookService.addBook(books);
        return "redirect:/book/allBook";   //重定向，回到首页(allBook请求)
    }

    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "/updateBook";
    }


    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>" + books);
        int i = bookService.updateBook(books);
        if (i > 0){
            System.out.println("添加books成功" + books);
        }
        //修改为回到主页
        return "redirect:/book/allBook";
    }


    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }


    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        System.err.println("queryBook=>" + books);

        List<Books> list = new ArrayList<Books>();
        list.add(books);

        if (books == null){
            list = bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }

        model.addAttribute("list",list);
        return "/allBook";
    }
}
```

设计从上往下，开发从下往上

建议在编写功能时尽量按顺序:dao-->service-->controller-->前端  这样的顺序写





# 十四、AJAX

jQuery.ajax(...) 

​	部分参数：

​	url：请求地址 

​	type：请求方式，GET、POST（1.9.0之后用method） 

​	headers：请求头 

​	data：要发送的数据 

​	contentType：即将发送信息至服务器的内容编码类型(默认: "application/x-www- 

​	form-urlencoded; charset=UTF-8") 

​	async：是否异步 

​	timeout：设置请求超时时间（毫秒） 

​	beforeSend：发送请求前执行的函数(全局) 

​	complete：完成之后执行的回调函数(全局) 

​	success：成功之后执行的回调函数(全局) 

​	error：失败之后执行的回调函数(全局) 

​	accepts：通过请求头发送给服务器，告诉服务器当前客户端课接受的数据类型 

​	dataType：将服务器端返回的数据转换成指定类型 

​	"xml": 将服务器端返回的内容转换成xml格式 

​	"text": 将服务器端返回的内容转换成普通文本格式 

​	"html": 将服务器端返回的内容转换成普通文本格式，在插入DOM中时，如果包含 

​	JavaScript标签，则会尝试去执行。 

​	"script": 尝试将返回值当作JavaScript去执行，然后再将服务器端返回的内容转换成 

​	普通文本格式 

​	"json": 将服务器端返回的内容转换成相应的JavaScript对象 

​	"jsonp": JSONP 格式使用 JSONP 形式调用函数时，如 "myurl?callback=?" 

​	jQuery 将自动替换 ? 为正确的函数名，以执行回调函数 



注意：需要导入jquery.js文件

```xml
<!--使用jquery需要配置静态资源过滤-->
<mvc:default-servlet-handler />
<!--需要使用视图解析器视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
```



首页index.jsp(失去焦点发生事件):

```jsp
 <head>
    <title>$Title$</title>

    <!--注意要导入jQuery!!!-->
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.js"></script>

    <script>
      function a(){           /*a函数调用AJAX方法*/
        $.post({			/*这个post会调用ajax函数*/
            /*以下的参数都是源码里要求要写入的*/
          url:"${pageContext.request.contextPath}/a1",			/*传给后端的a1，对比controller类看*/
          data:{"name":$("username").val()},			/*data属性可省略，省略即为undefined*/
            /*$("username").val()能取得输入框的值
            
            $(selector).val()   返回 value 属性：		
			$(selector).val(value) 	设置 value 属性
			$(selector).val(function(index,currentvalue))	 通过函数设置 value 属性：
            */
            
          success:function (data,status){
            console.log("data=" + data);
            console.log("status=" + status);   //200   300   400   500
          },
          error:function (){

          }
        })
      }

    </script>
  </head>
  <body>

  <!--失去焦点的时候调用a函数，发起一个请求（携带信息）到后台-->
  用户名:<input type="text" id="username" onblur="a()">

  </body>
```

追加ajax异步的示例:

```jsp
<head>
    <title>Title</title>
<%--实现ajax异步--%>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.js"></script>
    <script>
        /*jquery:*/
        $(function (){
            $("#btn").click(function (){
                //$.post (url,param[参数可以省略],success回调函数)
                $.post("${pageContext.request.contextPath}/a2",function (data){		//对应controller类的a2
                    /*下面是追加节点的方式*/
                    var html="<>";
                    for (let i = 0;i < data.length;i ++){       /*let的好处是让i限定在这个for循环中，更安全的写法*/
                        html += "<tr>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "<td>" + data[i].sex + "</td>" +
                            "</tr>"

                    }

                    $("#content").html(html);
                })

            })
        });
    </script>
</head>
<body>

    <input type="button" value="加载数据" id="btn">     <%--上面的ajax对应这里的点击事件--%>
    <table>
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
        </tr>
        <tbody id="content">
            <!--数据在后台，前端无法直接拿到-->

        </tbody>
    </table>

</body>
```



登录页面(失去焦点进行校验):

```jsp
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.js"></script>

    <script>
        function a1(){
            $.post({
                url:"${pageContext.request.contextPath}/a3",		//对应controller类的a3
                data:{"name":$("#name").val()},
                success:function (data) {
                    if (data.toString()==='ok'){
                        $("#userInfo").css("color","green");
                    }else {
                        $("#userInfor").css("color","red");
                    }
                    $("#userInfo").html(data);
                }
            })
        }
    </script>

    <script>
        function a2(){
            $.post({
                url:"${pageContext.request.contextPath}/a3",		//对应controller类的a3
                data:{"pwd":$("#pwd").val()},
                success:function (data) {
                    if (data.toString()==='ok'){
                        $("#pwdInfo").css("color","green");
                    }else {
                        $("#pwdInfor").css("color","red");
                    }
                    $("#pwdrInfo").html(data);
                }
            })
        }
    </script>
</head>
<body>


    <p>
        用户名:<input type="text" id="name" onblur="a1()">
        <span id="userInfo"></span>
    </p>

    <p>
        密码:<input type="text" id="pwd" onblur="a2()">
        <span id="pwdInfo"></span>
    </p>

</body>
```

controller类:

```java
@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }


    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>" + name);
        if ("kuangshen".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }


    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<User>();
        //添加数据
        userList.add(new User("smith",1,"男"));
        userList.add(new User("dog",1,"女"));
        userList.add(new User("cat",1,"男"));

        return userList;
    }


    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg = "";
        if (name != null){
            //admin数据在实际开发中应该在数据库中查
            if ("admin".equals(name)){
                msg = "ok";
            }else {
                msg = "用户名有误";
            }
        }

        if (pwd != null){
            //123456数据在实际开发中应该在数据库中查
            if ("123456".equals(name)){
                msg = "ok";
            }else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
```



${pageContext.request.contextPath}解读:pageContext.getRequest()得到HttpServletRequest对象，这是第一步，第二步是利用拿到的HttpServletRequest调用getContextPath方法。

　　作用是：取出部署的应用程序名，这样不管如何部署，所用路径都是正确的。



# 十五、拦截器Interceptor

##### (1)概述:

SpringMVC的处理器拦截器类似于Servlet开发中的过滤器Filter,用于对处理器进行预处理和后处理。开

发者可以自己定义一些拦截器来实现特定的功能



 过滤器与拦截器的区别:拦截器是AOP思想的具体应用，不影响原来的应用
过滤器是servlet规范的一部分，任何javaweb工程都可以使用；在url-pattern中配置了/*之后，可以对所有要访问的资源进行拦截
拦截器是SpringMVC框架自己的，只要使用了SpringMVC框架的工程才能使用；拦截器会拦截访问的控制器方法，如果访问的是jsp/html/css/image/js是不会进行拦截的



##### (2)自定义一个拦截器

让需要的类实现**HandlerInterceptor接口**



springmvc-servlet.xml中配置拦截器:

```xml
<!--配置拦截器-->
<mvc:interceptors>
    <mvc:interceptor>
        <!--/** :包括这个请求下面的所有东西都进行处理-->
        <mvc:mapping path="/**"/>
        <bean class="com.csu.config.MyInterceptor"/>    <!--告诉程序谁负责去拦截-->
    </mvc:interceptor>

    <mvc:interceptor>
        <mvc:mapping path="/user/**"/>      <!--经过user的都会被拦截进行处理-->
        <bean class="com.csu.config.LoginInterceptor"/>
    </mvc:interceptor>
</mvc:interceptors>
```



一个正常拦截器的内容:

```java
public class MyInterceptor implements HandlerInterceptor {

    //return true会放行，执行下一个拦截器
    //return false不会执行下一个拦截器
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("====处理前======");
        return false;
    }

    //拦截日志
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("=====处理后=====");
    }

    
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("======清理======");
    }
}
```



写一个网站登录拦截:

```java
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();		//把用户的session传进来
    //进行放行判断(如果容器为空或不为空)
    //登录页面也会放行
    if (request.getRequestURI().contains("goLogin")){
        return true;
    }
    //说明我在提交登录
    if (request.getRequestURI().contains("login")){
        return true;
    }
    //第一次登录，也是没有session的:
    if(session.getAttribute("userLoginInfo")!=null){
        return true;
    }
    //判断什么情况下没有登录，没登录就跳到登录页面
    request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
    return false;
}
```

登录的页面:

```jsp
<!--*****在WEB-INF下面的所有页面或者资源只能通过controller或servlet进行访问-->
    <h1>登录页面</h1>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        用户名:<input type="text" name="username">
        密码:<input type="text" name="password">
        <input type="submit" value="提交">
    </form>
```

主页面:

```jsp
<h1>首页</h1>

<span>${username}</span>

<p><a href="${pageContext.request.contextPath}/user/goOut">注销</a> </p>
```

controller类:

```java
@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/goLogin")
    public String login(){
        return "login";
    }


    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        //把用户的信息存在session中，需要session类
        session.setAttribute("userLoginInfo",username);

        model.addAttribute("username",username);
        return "main";
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession session){
        //session.invalidate();    最好不要采用毁掉的方法，采用下一种方法
        session.removeAttribute("userLoginInfo");

        return "main";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
```



# 十六、文件上传、下载

##### （1）准备工作

```jsp
必须使用这样的格式:
<form action="" enctype="multipart/form-data" method="post">
	<input type="file" name="file"/> 
    <input type="submit">
</form>
```

Spring MVC则提供了更简单的封装。

Spring MVC为文件上传提供了直接的支持，这种支持是用即插即用的MultipartResolver实现的。

Spring MVC使用Apache Commons FileUpload技术实现了一个MultipartResolver实现类：

**CommonsMultipartResolver**。因此，SpringMVC的文件上传还需要依赖Apache Commons

FileUpload的组件

##### (2)文件上传

导入相关依赖:

```xml
<!--文件上传的包--> 
<dependency> 
    <groupId>commons-fileupload</groupId> 
    <artifactId>commons-fileupload</artifactId> 
    <version>1.3.3</version> 
</dependency> 
<!--servlet-api--> 
<dependency> 
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version> 
</dependency>
```

springmvc-servlet.xml中配置MultipartResolver:

```xml
<!--文件上传配置--> 
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolve r"> <!-- 请求的编码格式，必须和jSP的pageEncoding属性一致，以便正确读取表单的内容， 默认为ISO-8859-1 --> 
<!--id必须是multipartResolver，其他的会报错-->
    <property name="defaultEncoding" value="utf-8"/> 
    <!-- 上传文件大小上限，单位为字节（10485760=10M） --> 
    <property name="maxUploadSize" value="10485760"/> 
    <property name="maxInMemorySize" value="40960"/>
</bean>
```



前端上传表单:

```jsp
<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
  
  上传文件<p/><input type="file" name="file">  <p/>

  <p/><input type="submit"> | <input type="reset"><p/>
```



CommonsMultipartFile 的 常用方法：

​		**String getOriginalFilename()****：获取上传文件的原名**

​		InputStream getInputStream()****：获取文件流**

​		void transferTo(File dest)****：将上传文件保存到一个目录文件中**



###### 1、方式一：

fileController类:

```java
@Controller 
public class FileController { 
    //@RequestParam("file") 将name=file控件得到的文件封装成 CommonsMultipartFile 对象 
    //批量上传CommonsMultipartFile则为数组即可 
    @RequestMapping("/upload") 
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file , HttpServletRequest request) throws IOException { 
        //获取文件名 : 
        file.getOriginalFilename(); 
        String uploadFileName = file.getOriginalFilename(); 
        //如果文件名为空，直接回到首页！ 
        if ("".equals(uploadFileName)){ 
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名 : "+uploadFileName); 
        //上传路径保存设置		（文件路径最好设置一个UUID，防止重名）
        String path = request.getServletContext().getRealPath("/upload"); 
        //如果路径不存在，创建一个 
        File realPath = new File(path); 
        if (!realPath.exists()){ 
            realPath.mkdir(); 
        }
        System.out.println("上传文件保存地址："+realPath);
        InputStream is = file.getInputStream(); 
        //文件输入流 
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName));	 //文件输出流
        
        //读取写出 
        int len=0; 
        byte[] buffer = new byte[1024]; 
        while ((len=is.read(buffer))!=-1){ 
            os.write(buffer,0,len); 
            os.flush();
        }
        os.close(); 
        is.close(); 
        return "redirect:/index.jsp"; 
    } 
}
```

###### 2、方式二：

采用**fifile.Transto**来保存上传的文件

```java
/** 采用file.Transto 来保存上传的文件 */ 
@RequestMapping("/upload2") 
public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException { 
    //上传路径保存设置 
    String path = request.getServletContext().getRealPath("/upload"); 
    File realPath = new File(path); 
    if (!realPath.exists()){ 
        realPath.mkdir(); 
    }
    //上传文件地址 
    System.out.println("上传文件保存地址："+realPath); 
    //通过CommonsMultipartFile的方法直接写文件（注意这个时候） 
    file.transferTo(new File(realPath +"/"+ file.getOriginalFilename())); 
    return "redirect:/index.jsp"; 
}
```

##### (3)文件下载:

步骤:

​	1. 设置 response 响应头

​	2. 读取文件 -- InputStream

​	3. 写出文件 -- OutputStream

​	4. 执行操作

​	5. 关闭流 （先开后关）

```java
@RequestMapping(value="/download") 
public String downloads(HttpServletResponse response ,HttpServletRequest request) throws Exception{ 
    //要下载的图片地址 
    String path = request.getServletContext().getRealPath("/upload"); 
    String fileName = "基础语法.jpg"; 
    //1、设置response 响应头 response.reset(); 
    //设置页面不缓存,清空buffer 
    response.setCharacterEncoding("UTF-8"); 
    //字符编码 
    response.setContentType("multipart/form-data"); 
    //二进制传输数据 
    //设置响应头 
    response.setHeader("Content-Disposition", "attachment;fileName="+URLEncoder.encode(fileName, "UTF-8"));
    File file = new File(path,fileName); 
    
    //2、 读取文件--输入流
    InputStream input=new FileInputStream(file); 
    
    //3、 写出文件--输出流 
    OutputStream out = response.getOutputStream(); 
    byte[] buff =new byte[1024]; int index=0; 
    //4、执行 写出操作 
    while((index= input.read(buff))!= -1){ 
        out.write(buff, 0, index); 
        out.flush(); 
    }
    out.close(); 
    input.close(); 
    return null;
}
```

