Spring

# 	一、简介															

一、spring理念:使现有技术更加容易使用，本身是一个大杂烩，整合了现有的技术框架

二、网址:https://repo.spring.io/release/org/springframework/spring/
官方文档地址:https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html

maven依赖：
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>

三、优点：1、spring是一个开源的免费的框架(容器)
      2、是一个轻量级的、非入侵式(不会对原来代码产生任何影响)的框架
      3、***最重要的特点:控制反转(IOC),面向切面编程(AOP)
      4、支持事务的处理，对框架整合的支持(主流的框架几乎都支持)
    总结一句话:Spring就是一个轻量级的控制反转(IOC)和面向切面编程(AOP)的框架

七大模块:核心容器(Spring Core)、Spring 上下文(Spring Context)、Spring AOP、Spring DAO、Spring ORM、Spring Web 模块、Spring MVC 框架


四、拓展:现代化的java开发---基于Spring的开发
     构建一切、协调一切、连接一切
Spring Boot:快速开发的脚手架，基于springboot可以快速开发单个微服务，约定大于配置
SpringCloud:基于springboot实现的
现在大多数公司都在使用springboot进行开发，学习springboot的前提需要完全掌握spring、springMVC

spring发展太久之后，违背了原来的理念：由于容纳太多，配置十分繁琐，人称“配置地狱”



# 二、IOC理论推导

一、在我们之前的业务中，用户的需求变化可能会影响我们原来的代码，我们需要根据用户的需求去修改源代码！
如果程序代码量十分大，修改一次的成本代价十分昂贵

  使用一个set接口实现，已经发送了革命性的变化:

```
    private UserDao userDao;
    //使用set进行动态实现值的注入
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
```


  之前，程序是主动创建对象，控制器在程序员手上！使用了set注入之后，程序不再具有主动性，而是变成了被动地接收对象
之前Dao是死的!

  这种思想从本质上解决了问题，程序员再也不用去管理对象的创建了。系统的耦合性大大降低，可以更加专注在业务的实现上
这是IOC的原型,还不是真正的IOC



二、IOC的本质：
  控制反转(Inversion of Control)是一种描述(XML或注解)并通过第三方去生产或获取特定对象的方式，在spring中实现控制反转的时IoC容器，其实现方法是依赖注入
在没有IoC的程序中，我们使用面向对象编程，对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，
控制反转后将对象的创建转移给第三方，个人认为所谓控制反转就是:获得依赖对象的方式反转了。

  三种实现方式:IoC是Spring框架的核心内容，使用多种方式完美地实现了IoC，可以使用XML配置，也可以使用注解，新版本地Spring也可以零配置实现IoC。采用XML方式配置Bean地时候，Bean地定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在
实现类中，从而达到零配置的目的

Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从IoC容器中取出需要的对象

  见spring-02-hellospring
  	**控制:谁来控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用Spring后，对象是由Spring来创建的**
	  **反转:程序本身不创建对象，而变成被动的接收对象**
  	**依赖注入:利用set方法来注入的**
  	这样，再也不用去程序中改动了，要实现不同操作，只需要在xml配置文件中进行修改
  IOC是一种编程思想，由主动的编程变成被动的接收
  可以通过newClassPathXmlApplicationContext去浏览一下底层源码
IOC总结为一句话:对象由Spring创建、管理、装配





第一个spring程序:

```java
/*
    一个简单的实体类,被spring注册托管了的类旁边会有bean的标志
 */
public class Hello {
    private String str;


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
```

bean.xml(在这个文件中创建对象，这就是控制反转，创建对象不再由程序员负责):

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--使用Spring中来创建，在spring中，这些都称为Bean
        原来创建对象的方式是:
		Hello hello = new Hello();
		类型   变量名 = new 类型()
		
 		bean=对象
        id = 变量名
		class = new 对象
		property相当于给对象中的属性设置一个值
    -->
    <bean id="hello" class="com.csu.pojo.Hello" >       <!--需要是全类名-->
        <property name="str" value="Spring" />      <!--value是设置具体的值，ref是引用spring容器中已创建好的对象-->
    </bean>
    

</beans>
```

Test:

```java
		//获取spring的上下文对象的方式:
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//这句话是固定的，只要用xml配置spring就必须写这句话!!

        //我们的对象现在都在spring中的管理了，要使用，直接去里面取出来就可以了!
        Hello hello = (Hello)context.getBean("hello");	//每一个对象都统称为bean，getBean取出“hello这个对象”
        System.out.println(hello.toString());		//调用查看hello
```

解读以上程序:





# 三、spring使用

**一、springIOC创建对象的方式**
  (1)、使用无参构造方法创建对象(默认的方式)

  (2)、假设要使用有参构造方法

```xml
	<!--第一种:下标赋值-->
    <bean id="user" class="com.csu.pojo.User">
        <constructor-arg index="0" value="zhangsan" />
    </bean> 


    <!--第二种方式，通过类型创建，不建议使用,如果多个参数类型一样会出问题-->
    <bean id="user" class="com.csu.pojo.User" >
        <constructor-arg type="java.lang.String" value="lisi"/>
    </bean>   


    <!--第三种:直接通过参数名，最能理解,建议用这种-->
    <bean id="user" class="com.csu.pojo.User" >
        <constructor-arg name="name" value="wangwu" />
    </bean>
```

Spring容器就类似于婚介网站，在注入spring容器的时候就已经把所有的bean都实例化了，想取什么就取什么





**Spring中的配置:**

```xml
1、别名:
<alias name="user" alias="asdsad" />		给对象设置别名,在容器中取出时可以输入这个名字


2、id:bean的唯一标识符，也就是相当于我们学过的对象名
   class:bean对象所对应的全限定名（全限定名说明是反射！！！）
   name:name也是别名，可以同时取多个别名，alias是一对一，name更好用
	<bean id="user" class="com.csu.pojo.User" name="user2,u2,uu2" />

3、import导入其他的bean.xml配置文件，合并为一个:
<import resource="beans1.xml"/>			<!--适合于团队开发，可以拿到其创建的bean-->
```



# 四、DI依赖注入

DI是实现IOC的一种方式，DI不等于IOC

####  (1)构造器注入(如上所示)

有参、无参的方式





#### （2）Set方式注入

​	**依赖:bean对象的创建依赖于容器**

​	**注入：bean对象的所有属性由容器来注入**

```xml
<!--使用set方法注入-->
    <bean id="address" class="com.csu.pojo.Address" />

    <bean id="student" class="com.csu.pojo.Student" >
        <!--第一种:普通值注入，value-->
        <property name="name" value="lily"/>

        <!--第二种，bean注入，使用ref注入-->
        <property name="address" ref="address" />           <!--引用类型使用ref,address是引用的对象-->

        
        <!--数组注入-->
        <property name="books" >
            <array>
                <value>红楼梦</value>
                <value>水浒传</value>
                <value>西游记</value>
                <value>三国演义</value>
            </array>
        </property>

        <!--list注入-->
        <property name="hobbys" >
            <list>
                <value>听歌</value>
                <value>敲代码</value>
                <value>看电影</value>
            </list>
        </property>

        <!--Map-->
        <property name="card">
            <map>
                <entry key="身份证" value="123456"/>
                <entry key="银行卡" value="654321"/>
            </map>
        </property>

        <!--SET注入-->
        <property name="games">
            <set>
                <value>LOL</value>
                <value>COC</value>
                <value>BOB</value>
            </set>
        </property>

        <!--null,空值-->
        <property name="wife">
            <null></null>
        </property>

        <!--Properties-->
        <property name="info">
            <props>
                <prop key="学号">8102181508</prop>
                <prop key="性别">男</prop>
                <prop key="姓名">小明</prop>
            </props>
        </property>
    </bean>
```







#### （3）其他拓展方式(引入其他的约束完成)

**1、c命名空间（导入c的约束）:**

```xml
	<!--c命名空间注入，通过构造器注入:construct-args,需要提前给类建好有参构造-->
    <bean id="user2" class="com.csu.pojo.User" c:age="18" c:name="john" scope="singleton"/>
```



**2、p命名空间(（导入p的约束）):**

```xml
<!--在上方加上namespace:  xmlns:p="http://www.springframework.org/schema/p"之后,
    下面的可选标签发生了变化，新增了一些
        p命名空间注入可以直接注入属性的值:property
        c命名空间注入对应的是构造器注入方式，p对应的是set方法注入
    -->
    <bean id="user" class="com.csu.pojo.User" p:name="lucy" p:age="18" />
```





# 五、Bean的作用域:

```xml
<bean id="student" class="com.csu.pojo.Student" scope="" >
    scope就是设置这个bean的作用域
   
    作用域种类:
    1、单例模式(spring的默认机制，几乎所有东西都是单例的)
    <bean id="user2" class="com.csu.pojo.User" c:age="18" c:name="john" scope="singleton"/>

    2、原型模式:每次从容器中get的时候,都会产生一个新对象!
    <bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/>

    3、需要掌握上面两种，其余的request、session、application这些只能在web开发中使用到
```





# 六、自动装配Autowired

（1）*自动装配是Spring满足bean依赖的一种方式，spring会在上下文中自动寻找并自动给bean装配属性*
*在实际开发中会大量用到自动装配，不会手写太多bean*



##### （2）在spring中有三种自动装配的方式：

  1、在xml中显示配置
  2、在java中显示配置
  3、隐式的自动装配【重要】



##### **（3）主要使用byname和bytype两种自动装配**,还有注解的方式

环境搭建,一个实体类例子,一个人有两个宠物:

```java
	@Autowired         //自动装配注解,使用反射机制实现的，可以不用set、get方法了
    @Qualifier(value = "cat111")   //如果自动装配环境比较复杂，自动装配无法通过一个注解【@Autowired】完成的时候，可以使用@Qualifier(value="cat111")去配合@Autowired的使用
    private Cat cat;
    
	@Autowired(required = false)//如果显示定义了Autowired的required属性为false，说明这个对象可以为null，否则不允许为空
    @Resource
    private Dog dog;
    private String name;
```

bean.xml中的自动装配示范:

```xml
	<context:annotation-config/>   <!--注解的支持，不写这个的话不能使用注解-->


    <bean id="cat" class="com.csu.pojo.Cat"/>		<!--先将这两个宠物对象创建-->
    <bean id="dog" class="com.csu.pojo.Dog"/>


	<!--非自动装配的方式:-->
    <bean id="people" class="com.csu.pojo.People">
        <property name="name" value="小李"/>
        <property name="dog" ref="dog" />
        <property name="cat" ref="cat" />
    </bean> 


    <!--一、采用自动装配的方式:-->
    <!--通过name进行自动装配,byName会自动在容器中寻找和自己对象set方法后面的值对应的beanid!-->
    <bean id="people" class="com.csu.pojo.People" autowire="byName">
        <property name="name" value="小李"/>
    </bean>

    <!--二、通过type进行自动装配,byType会自动在容器中寻找和自己对象属性类型相同的bean (class的值)!-->
	<!--使用这种方式必须保证类型全局只有一个，要是有两个相同类型的引用对象则会报错-->
    <bean id="people" class="com.csu.pojo.People" autowire="byType">
        <property name="name" value="小李"/>
    </bean>


    <!--三、通过注解进行自动装配,需要提前加注解的支持和约束-->
    <bean id="people" class="com.csu.pojo.People" />

    <bean id="cat111" class="com.csu.pojo.Cat" />
```

几种注解介绍:

@Autowired 直接在属性上使用即可，也可以在set方法上使用
使用Autowired，我们可以不用编写Set方法了，前提是你这个自动装配的属性在IOC(Spring)容器中存在且名字一样

@Nullable 字段标记了这个注解，说明这个字段可以为Null

@Autowired(required = false)    //如果显示定义了Autowired的required属性为false，说明这个对象可以为null，否则不允许为空

@Qualifier 如果自动装配环境比较复杂，自动装配无法通过一个注解【@Autowired】完成的时候，
可以使用@Qualifier(value="cat111")去配合@Autowired的使用,指定一个唯一的bean对象注入

@Resource注解与 @Autowired的区别：
  二者都是自动装配，都可以放在属性字段上
  @Autowired通过ByType的方式实现，然后是byName实现，而且必须要求这个对象存在，不然就空指针了
  @Resource默认通过ByName的方式实现，如果找不到名字，则通过byType实现





# 七、使用注解开发Spring

(1)在spring4之后，要使用注解开发，必须保证aop的包导入了；使用注解需要导入context约束，增加注解的支持

<context:annotation-config />                             支持注解的驱动，放在xml文件	

<context:component-scan base-package="com.csu.pojo" />    		指定要扫描的包，这个包下的注解就会生效,这个注解要放在xml文件中



(2)主要的注解的介绍:

@Component   //等价于<bean id="user" class="com.csu.pojo.User" />，放在类上，说明这个类被spring管理了，就是bean

 @Value("lily")    //相当于<properties name="name" value="lily" />，给bean的属性赋值也可以放在上面定义name时

@Autowired、@Nullable、@Resource	自动装配相关

@Scope（“”）	作用域



衍生的注解
@Component有几个衍生注解，我们在Web开发中，会按照MVC三层架构分层:
	dao 层 --- @Repository 
	service层  --- @Service
	controller层 --- @Controller
这四个注解的功能是一样的，都是代表将某个类注册到spring容器中装配



(3)小结:
  xml与注解：
    xml更加万能，适用于任何场合，维护简单方便。
    注解不是自己的类使用不了，维护相对复杂。
  最佳实践：xml用来管理bean；注解只负责完成属性的注入
  我们在使用过程中只需要注意一个问题:必须让注解生效，就需要开启注解的支持
  SpringBoot中，几乎是全注解开发







# 八、JavaConfig实现配置

（1）介绍：使用Java的方式配置Spring：
  我们现在要完全不使用Spring的XML配置了，完全交给java来做,可以完全摒弃xml配置，这是新特性
  javaconfig是Spring的一个子项目，在Spring4之后，它成为了一个核心功能(@Configuration)



（2）使用:

创建一个普通的java的实体类:

```java
@Component   //这个注解的意思就是说明这个类被spring接管了(注册到了容器中)（据说这个注解在这加不加都一样）
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("harry")      //给这个属性注入值
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

创建两个java类:

```java
@Configuration    //这个也会被spring容器托管，注册到容器中，因为它本来就是一个@Component
                  //@Configuration 代表这是一个配置类，就和我们之前看的beans.xml是一样的，能做beans.xml能做的一切
@ComponentScan("com.csu.pojo")                //扫描这个包下的所有的
@Import(MyConfig2.class)       //引入另一个配置文件，进行融合
public class MyConfig {
    @Bean      //就相当于我们之前写的一个bean标签，这个方法的名字就相当于bean标签中的id属性，这个方法的返回值就相当于bean标签中的class属性
    public User getUser(){
        return new User();        //返回当前要注入到bean的对象
    }
}


@Configuration			//这个config也需要加上Configuration注解
public class MyConfig2 {
}
```



测试类:

```java
//如果完全使用配置类方式去做，我们就只能通过AnnotationConfig上下文来获取容器，然后通过配置类的class对象加载

        //使用注解配置类获取
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User getUser = (User)context.getBean("getUser");
        System.out.println(getUser.getName());
```

这种纯java的配置方式在SpringBoot中随处可见!!!!!





# 九、代理模式

##### (1)、静态代理:

```java
//租房行为的接口
public interface Rent {
    public void rent();
}

//房东
public class Host implements Rent{
//房东要出租房子
    public void rent() {
        System.out.println("房东要出租房子");
    }
}

//代理者类
public class Proxy implements Rent{
    private Host host;
    public Proxy() {
    }
    public Proxy(Host host) {
        this.host = host;
    }
    public void rent() {
        //代理出租房子
        seeHouse();
        host.rent();
        hetong();
        fare();
    
    //看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    //签租赁合同
    public void hetong(){
        System.out.println("签租赁合同");
    }

    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }
}
  
    
public class Client {
    public static void main(String[] args) {
        //房东要租房子
        Host host = new Host();
        //代理，中介帮房东出租房子，但是代理角色一般会有一些附属操作(看房、签合同、收中介费)
        Proxy proxy = new Proxy(host);

        //你不用面对房东，直接找中介即可
        proxy.rent();
    }
}
```





##### (2)动态代理：

1、底层是反射机制，是去解决静态代理的代码量的缺点的

2、动态代理和静态代理的角色一样：抽象角色、代理角色、真实角色、客户

3、动态代理的代理类是动态生成的，不是程序员直接写好的

4、动态代理分为两大类:
 	 a、基于接口的动态代理
    	基于接口---JDK动态代理
  	b、基于类的动态代理
    	基于类---cglib、java字节码实现

需要了解两个类:**Proxy(代理)**、**InvocationHandler(调用处理程序，反射包下的)**

5、动态代理的好处:
  1、一个动态代理类代理的是一个接口，一般就是对应的一类业务
  2、一个动态代理类可以代理多个类，只要是实现了同一个接口即可



```java
public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色，不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setTarget(userService);    //设置要代理的对象

        //动态生成代理类
        UserService proxy = (UserService)pih.getProxy();

        proxy.add();
    }
}

public interface UserService {
    public void add();
    public void delete();
    public void update();
    public void query();
}

public class UserServiceImpl implements UserService{
    public void add() {
        System.out.println("增加了一个用户");
    }

    public void delete() {
        System.out.println("删除了一个用户");
    }

    public void update() {
        System.out.println("更新了一个用户");
    }

    public void query() {
        System.out.println("查询了一个用户");
    }
}

//代理角色实现增删改查
public class UserServiceProxy implements UserService{

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    public void update() {
        log("update");
        userService.update();
    }

    public void query() {
        log("query");
        userService.query();
    }

    //日志方法
    public void log(String msg){
        System.out.println("使用了" + msg + "方法");
    }
}


public class ProxyInvocationHandler implements InvocationHandler {
        //被代理的接口
        private Object target;

        public void setTarget(Object target) {
            this.target = target;
        }

        //生成得到代理类
        public Object getProxy(){
            return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),this );
        }

        //处理代理实例,并返回结果
        //固定的代码:
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log("add");
            //动态代理的本质，就是通过反射实现的
            Object result = method.invoke(target, args);

            return result;
        }

        public void log(String msg){
            System.out.println("执行了" + msg + "方法");
        }
}
```





# 十、AOP

##### （1）介绍：

Aspect Orientes Programming,面向切面编程，通过预编译方式和运行期动态代理实现程序功能的一种统一维护的一种技术，AOP是OOP的延续



##### (2)使用aop:

1、导入AOP织入包
	<dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.4</version>
        </dependency>



  2、方式一:使用spring的API接口:主要是spring接口实现
       方式二:使用自定义来实现AOP:主要是切面定义
       方式三:注解实现



​		要求:加入日志功能:

UserService接口和UserServiceImpl实现类:

```java
public interface UserService {
    public void add();
    public void delete();
    public void update();
    public void select();
}
public class UserServiceImpl implements UserService{
    public void add() {
        System.out.println("增加了一个用户");
    }
    public void delete() {
        System.out.println("删除了一个用户");
    }
    public void update() {
        System.out.println("修改了一个用户");
    }
    public void select() {
        System.out.println("查询了一个用户");
    }
}
```

写一个对应的log日志类:

```java
public class Log implements MethodBeforeAdvice {
    //method:要执行的目标对象的方法
    //Objects:参数
    //target:目标对象
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "的" + method.getName() + "被执行了");
        //会输出:什么类的什么方法被执行了
    }
}
```

写一个log日志执行后的类:

```java
public class AfterLog implements AfterReturningAdvice {
    //returnValue:返回值
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("执行了" + method.getName() + "返回结果为:" + returnValue);
        //会输出：执行了什么方法，返回结果是什么
    }
}
```

重点:在spring中将这两个类注册上去:

```xml
<!--注册bean-->
<bean id="userService" class="com.csu.service.UserServiceImpl" />
<bean id="log" class="com.csu.log.Log" />
<bean id="afterLog" class="com.csu.log.AfterLog"/>

<!--配置AOP,需要导入aop的约束-->


<!--方式一:使用原生的API接口-->

<aop:config>      aop的配置
    切入点:需要到哪执行   expression执行表达式:execution(要执行的位置:* * * * *),格式是固定的
    <aop:pointcut id="pointcut" expression="execution(* com.csu.service.UserServiceImpl.*(..))"/>
    将UserServiceImpl下的所有方法都设置为pointcut切入点
    

    执行环绕增加
    <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>     意思是把log类切入到UserServiceImpl方法上面
    <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/> 意思是把afterLog类切入到UserServiceImpl方法上面
</aop:config>





<!--方式二:自定义类，推荐-->
<bean id="diy" class="com.csu.diy.DiyPointCut" />	<!--diy了一个DiyPointCut类,里面定义before、after方法，可以在下面自定义它们执行的时间-->

<aop:config>
    <!--自定义切面，是一个类,ref是要引用的类-->
    <aop:aspect ref="diy">
        <!--切入点-->
        <aop:pointcut id="point" expression="execution(* com.csu.service.UserServiceImpl.*(..))"/>
        <!--通知-->
        <aop:before method="before" pointcut-ref="point" />
        <aop:after method="after" pointcut-ref="point" />
        
        <!--第二种方式比第一种方式更容易、更明确-->
    </aop:aspect>
</aop:config>




<!--方式三,使用注解实现aop插入-->
<bean id="annotationPointCut" class="com.csu.diy.AnnotationPointCut" />
<!--必须开启注解支持     JDK(默认 proxy-target-class="false")、cglib(proxy-target-class="true")-->
<aop:aspectj-autoproxy />                  <!--自动代理-->
<!--注解方式很简短-->
```

diy自定义的DiyPointCut:

```java
public class DiyPointCut {
    public void before(){
        System.out.println("==========方法执行前=============");
    }

    public void after(){
        System.out.println("==========方法执行后=============");
    }
}
```

注解实现的切面类:

```java
@Aspect     //标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.csu.service.UserServiceImpl.*(..))")     //这个before导包要和junit包中的before分开
    public void before(){
        System.out.println("======方法执行前========");
    }


    //在UserServiceImpl所有方法执行的后面的执行方法
    @After("execution(* com.csu.service.UserServiceImpl.*(..))")	
    public void after(){
        System.out.println("=======方法执行后=======");
    }

    
    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点（了解）
    @Around("execution(* com.csu.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("环绕前");

        Signature signature = jp.getSignature();//获得签名
        System.out.println("signature:" + signature);

        Object proceed = jp.proceed();          //执行方法

        System.out.println("环绕后");

        System.out.println(proceed);
    }
}
```



测试类:

```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//动态代理代理的是接口
UserService userService = (UserService) context.getBean("userService");
//这个userService不是接口，是UserServiceImpl在applicationContext中注册好的类,但是要转换成接口的类型

userService.add();
```







# 十一、整合Mybatis

##### （1）、步骤：

  1、导入jar包：junit、mybatis、mysql、spring、aop织入、mybatis-spring(专门整合mybatis和spring的)
  2、编写配置文件
  3、测试

mybatis-spring:帮助将MyBatis代码无缝地整合到Sspring中。它将允许 Myfatis 参与到sping的事务管理当中，创建映射器 mapper和sglessionm 并注入到been中，以及将 Myatis的异常转换为Spring的 DataAccessException。最终，可以做到应用代码不依赖于MyBatis，Spring或 MyBatis-Spring. 		(mybatis的事务管理很笨重，需要手动添加,spring可以使用aop添加)

##### （2）使用、

Mybatis的相关配置略



spring-dao.xml(需要引入spring-jdbc的依赖):

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--配置的重点是sqlSessionFactory和SqlSessionTemplate部分-->

    <!--DataSource:使用spring的数据源替换mybatis的配置  c3p0 dbcp druid
        我们这里使用spring提供的JDBC
    -->
    
    <!--配置连接,驱动管理数据源-->
    <bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
        <property name="username" value="root" />
        <property name="password" value="123" />
    </bean>

    
    <!--sqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--注入数据源-->
        <property name="dataSource" ref="datasource"/>
        <!--绑定mybatis配置文件，下面是mybatis的相关配置选项-->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>	配置文件
        <property name="mapperLocations" value="classpath:com/csu/mapper/UserMapper.xml"/>	映射地址
    </bean>

    
    <!--创建一个SqlSessionTemplate:就是我们之前使用的sqlsession-->
    <!--SqlSessionTemplate是MyBatis-Spring 的核心。可以使用它无缝代替你代码中已经在使用的SqlSession-->
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate" >
        <!--只能使用构造器注入sqlSessionFactory，因为它没有set方法-->
        <constructor-arg index="0" ref="sqlSessionFactory" />	sqlsession注入的参数只有一个:sqlSessionFactory
    </bean>
    <!--将实现类注入到spring中去:-->
    <bean id="userMapper" class="com.csu.mapper.UserMapperImpl" >
        <property name="sqlSession" ref="sqlSession"/>
    </bean>
</beans>
```

这个文件写了之后可以完全替代掉原来的mybatis相关配置文件,mybatis内部集成了

```java
public class UserMapperImpl implements UserMapper{
    //我们的所有操作原来都使用sqlSession来执行。现在都使用SqlSessionTemplate
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
```

applicationContext.xml:

```xml
<import resource="spring-dao.xml"/>    <!--把spring-dao.xml导进来，这个文件就彻底独立了，成为总的配置文件的一部分，解耦合-->

<!--第一种方式-->
<bean id="userMapper" class="com.csu.mapper.UserMapperImpl" >
    <property name="sqlSession" ref="sqlSession"/>
</bean>


<!--使用第二种方式SqlSessionDaoSupport进行整合-->	
<bean id="userMapper2" class="com.csu.log.UserMapperImpl2" >
    <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
</bean>
使用第二种方式的话在spring-dao.xml中就不用创建一个SqlSessionTemplate并将实现类注入到spring中去了
```



# 十二、声明式事务

##### 一、事务:

  事务特性：把一组业务当成一个业务来做，要么都成功，要么都失败，在项目开发中很重要，涉及到数据的一致性问题。确保完整性和一致性
  事务的ACID原则:原子性、一致性、隔离性、持久性

##### 二、使用事务机制:

spring中的事务分为两类:声明式事务（AOP的应用，事务插入不影响程序）、编程式事务（在代码中进行事务的管理）

```xml
要开启 Spring 的事务处理功能，在 Spring 的配置文件中创建一个 DataSourceTransactionManager 对象
  <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <constructor-arg ref="dataSource" />
  </bean>
```





```java
public interface UserMapper {
    //查询用户
    public List<User> selectUser();

    //添加一个用户
    public int addUser(User user);

    //删除一个用户
    public int deleteUser(int id);
}


public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{

    public List<User> selectUser() {
        User user = new User(5, "小王", "1232112");

        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);

        mapper.addUser(user);
        mapper.deleteUser(5);

        return mapper.selectUser();		//测试事务状况
    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
```

UserMapper.xml:

```xml
<mapper namespace="com.csu.mapper.UserMapper">

    <select id="selectUser" resultType="user">
        select * from mybatis.user;
    </select>

    <!--添加一个用户-->
    <insert id="addUser" parameterType="user">
        insert into mybatis.user (id , name , pwd) values (#{id},#{name},#{pwd});
    </insert>

    <!--删除一个用户-->
    <delete id="deleteUser" parameterType="int">
        delete from mybatis.user where id=#{id}
    </delete>
</mapper>
```

**spring-dao.xml****使用aop配置声明式事务**:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/tx
        https://www.springframework.org/schema/tx/spring-tx.xsd">

<bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">  需要先创建这个对象
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
    <property name="username" value="root" />
    <property name="password" value="123" />
</bean>


<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">

    <property name="dataSource" ref="datasource"/>
    <property name="configLocation" value="classpath:mybatis-config.xml"/>
    <property name="mapperLocations" value="classpath:com/csu/mapper/UserMapper.xml"/>
</bean>


<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate" >
    <constructor-arg index="0" ref="sqlSessionFactory" />
</bean>



<!--配置声明式事务-->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="datasource"/>
</bean>

    
<!--结合AOP实现事务的植入-->
<!--配置事务通知-->
<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <!--1、给哪些方法配置事务-->
    <!--2、配置事务的传播特性propagation,一般设置为REQUIRED(支持当前事务),其他的自己上网看看-->
    <tx:attributes>
        <tx:method name="add" propagation="REQUIRED"/>
        <tx:method name="delete" propagation="REQUIRED"/>
        <tx:method name="update" propagation="REQUIRED"/>         <!--给所有的add、delete、update、query配置事务-->
        <tx:method name="query" read-only="true"/>          <!--只读，不能对数据库进行增删改的操作-->
        <tx:method name="*" propagation="REQUIRED"/>         <!--给所有方法配置事务，这样很简便-->
    </tx:attributes>
</tx:advice>

<!--配置事务切入-->
<aop:config>
    <aop:pointcut id="txPointCut" expression="execution(* com.csu.mapper.*.*(..))"/>
    <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>
</aop:config>
    
</beans>    
```

applicationContext.xml:

```xml
<import resource="spring-dao.xml"/>		已经导入了spring-dao.xml，所以这个才是总的配置文件

<!--bean-->
<bean id="userMapper" class="com.csu.mapper.UserMapperImpl">
    <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
</bean>
```

思考:为什么需要事务?
  *如果不配置事务，可能存在数据提交不一致的情况下;
  *如果不在Spring中去配置声明式事务，我们就需要在代码中手动配置事务
  *事务在项目开发中十分重要，涉及到数据的一致性和完整性问题，不能马虎