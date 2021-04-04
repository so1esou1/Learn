# 一、中间件介绍

#### (1)什么是中间件:

![image-20210328222803102](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328222803102.png)

#### (2)为什么要使用消息中间件:

![image-20210328222923269](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328222923269.png)

#### (3)中间件特点:

![image-20210328223055433](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328223055433.png)

#### (4)什么项目中需要使用中间件:

![image-20210328223211574](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328223211574.png)



#### (5)主流的中间件介绍:

![image-20210328223705482](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328223705482.png)

![image-20210328223915088](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328223915088.png)

#### (6)单体架构介绍:

![image-20210328224219035](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328224219035.png)

#### (7)分布式的改变:

![image-20210328224403485](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328224403485.png)

![image-20210328224647978](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328224647978.png)

#### (8)基于消息中间件的分布式系统的架构:

![image-20210328225000166](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328225000166.png)



#### (9)消息中间件应用的场景:

![image-20210328225109210](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328225109210.png)

#### (10)消息中间件的本质:

是一种接受数据，接受请求、存储数据、发送数据等功能的技术服务。

MQ消息队列：负责数据的传接受，存储和传递，所以性能要过于普通服务和技术



#### (11)消息中间件的核心组成部分:

1：消息的协议
2：消息的持久化机制
3：消息的分发策略
4：消息的高可用，高可靠
5：消息的容错机制





# 二、消息队列的协议:

#### (1)什么是协议:

![image-20210328225756723](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328225756723.png)



#### (2)网络协议的三要素:

1.语法。语法是用户数据与控制信息的结构与格式,以及数据出现的顺序。
2.语义。语义是解释控制信息每个部分的意义。它规定了需要发出何种控制信息,以及完成的动作与做出什么样的响应。
3.时序。时序是对事件发生顺序的详细说明。

消息中间件采用的并不是http协议，而常见的消息中间件协议有：OpenWire、AMQP、MQTT、Kafka，OpenMessage协议



![image-20210328230015510](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328230015510.png)



#### (3)rabbitMQ的协议:

1、AMQP协议:

![image-20210328230649528](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328230649528.png)

2、MQTT协议:

![image-20210328230726224](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328230726224.png)

OpenMessage协议、Kafka协议等不支持rabbitMQ





# 三、消息队列持久化

#### 常见的持久化方式:

![image-20210328231042119](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328231042119.png)



# 四、消息的分发策略:

![image-20210328231332079](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328231332079.png)

**消息分发策略的机制和对比:**

![image-20210328231718048](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328231718048.png)





# 五、消息队列高可用和高可靠：

#### (1)什么是高可用机制:

![image-20210328232123373](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328232123373.png)

也需要从高可用和高可靠方面来评价一款中间件



#### (2)集群模式1 - Master-slave主从共享数据的部署方式

![image-20210328232358033](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328232358033.png)

生产者讲消费发送到Master节点，所有的都连接这个消息队列共享这块数据区域，Master节点负责写入，一旦Master挂掉，slave节点继续服务,从而形成高可用.在小规模集群中可以使用，大规模业务中使用较少

#### (3)集群模式2 - Master- slave主从同步部署方式：

![image-20210328232616400](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328232616400.png)

写入消息同样在Master主节点上，但是主节点会同步数据到slave节点形成副本，和zookeeper或者redis主从机制很类同。这样可以达到负载均衡的效果，如果消费者有多个这样就可以去不同的节点就行消费，以为消息的拷贝和同步会暂用很大的带宽和网络资源。在后续的rabbtmq中会有使用。



#### (4)集群模式3 - 多主集群同步部署模式

![image-20210328232746425](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328232746425.png)

和上面的区别不是特别的大，但是它的写入可以往任意节点去写入。



#### (5)集群模式4 - 多主集群转发部署模式

![image-20210328232909250](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328232909250.png)

![image-20210328232941925](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328232941925.png)

#### (6)集群模式5 Master-slave与Breoker-cluster组合的方案

![image-20210328233045780](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328233045780.png)

实现多主多从的热备机制来完成消息的高可用以及数据的热备机制，在生产规模达到一定的阶段的时候，这种使用的频率比较高。

这么集群模式，具体在后续的课程中会进行一个分析和讲解。他们的最终目的都是为保证：消息服务器不会挂掉，出现了故障依然可以抱着消息服务继续使用



![image-20210328233133451](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328233133451.png)



#### (7)什么是高可靠机制

![image-20210328233234156](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210328233234156.png)





# 六、安装RabbitMQ:

略

启动服务> systemctl start rabbitmq-server

 查看服务状态> systemctl status rabbitmq-server

停止服务> systemctl stop rabbitmq-server

开机启动服务> systemctl enable rabbitmq-server

![image-20210329075943890](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329075943890.png)



rabbitmq的配置:RabbitMQ默认情况下有一个配置文件，定义了RabbitMQ的相关配置信息，默认情况下能够满足日常的开发需求。如果需要修改需要，需要自己创建一个配置文件进行覆盖。



# 七、rabbitmq的图形化管理界面:

rabbitmqweb

![image-20210329080155942](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329080155942.png)

![image-20210329082645237](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329082645237.png)





##### 使用docker安装:

​	启动docker:systemctl start docker

​	查看镜像:docker ps -a

docker run -di --name myrabbit -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -p 15672:15672 -p 5672:5672 -p 25672:25672 -p 61613:61613 -p 1883:1883 rabbitmq:management

查看日志:docker logs -f myrabbit

启动:docker start 容器名

可视化平台用户名密码都是admin、admin



![image-20210329090932471](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329090932471.png)



# 八、角色分类:

![image-20210329091235299](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329091235299.png)

![image-20210329091312912](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329091312912.png)

![image-20210329091348132](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329091348132.png)





# 九、快速入门案例(简单模式):

1、创建一个maven工程

2、导入依赖:

![image-20210329091752281](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329091752281.png)



3、代码:

```java
/*
    简单模式:生产者类
 */
public class Producer {
    public static void main(String[] args) {
        //所有的中间件技术都是基于tcp/ip协议基础上的，只不过rabbitmq遵循的是amqp
        //必须要有ip和port端口

        //1、创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.103.151.171");        //填写主机ip地址
        connectionFactory.setPort(5672);            //设置端口号为5672
        connectionFactory.setUsername("admin");     //设置用户名
        connectionFactory.setPassword("admin");     //设置密码
        connectionFactory.setVirtualHost("/");      //设置虚拟主机
        Connection connection = null;
        Channel channel = null;
        try {
            //2、创建连接Connection
            connection = connectionFactory.newConnection("生产者");

            //3、通过连接获取通道Channel，可以发现后面的操作都是基于通道而不是连接来处理的
            channel = connection.createChannel();

            //4、通过通道创建交换机、声明队列、绑定关系、路由key、发送消息和接收消息
            String queueName = "queue1";        //声明队列名

            channel.queueDeclare(queueName,false,false,false,null);
            //几个参数分别是:是否要持久化? 是否要具有排他性? 是否自动删除? 携带的额外参数

            //5、准备消息内容
            String message = "helloworld";

            //6、发送消息给队列queue
            channel.basicPublish("",queueName, null,message.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            //7、关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }

            //8、关闭连接:
            if (connection != null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

```java
/*
    简单模式:消费者类,第4步之前和消费者大体一样
 */
public class Consumer {
    public static void main(String[] args) {


        //1、创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.103.151.171");        //填写主机ip地址
        connectionFactory.setPort(5672);            //设置端口号为5672
        connectionFactory.setUsername("admin");     //设置用户名
        connectionFactory.setPassword("admin");     //设置密码
        connectionFactory.setVirtualHost("/");      //设置虚拟主机
        Connection connection = null;
        Channel channel = null;
        try {
            //2、创建连接Connection
            connection = connectionFactory.newConnection("生产者");

            //3、通过连接获取通道Channel
            channel = connection.createChannel();

            //4、通过通道创建交换机、声明队列、绑定关系、路由key、发送消息和接收消息
            channel.basicConsume("queue1", true, new DeliverCallback() {    //接收消息成功的类
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println("收到消息是:" + new String(delivery.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {   //接收消息失败的类
                public void handle(String s) throws IOException {
                    System.out.println("接收消息失败");
                }
            });
            System.out.println("开始接收消息");
            System.in.read();
            

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            //5、关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }

            //6、关闭连接:
            if (connection != null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



# 十、什么是AMQP?

![image-20210329094424861](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329094424861.png)

![image-20210329094642327](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329094642327.png)



面试题:为什么rabbitmq基于通道channel而不是连接connection去处理?	自己去寻找答案



# 十一、rabbitmq的核心组件:

##### 组件:

![image-20210329100648759](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329100648759.png)

![image-20210329101444193](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329101444193.png)



![image-20210329100459779](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329100459779.png)

最好在开发中指定交换机，少用默认的交换机

![image-20210329101709685](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329101709685.png)









![image-20210329101155892](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329101155892.png)





##### rabbitmq的整体架构：

![image-20210329102003664](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329102003664.png)



##### rabbitmq的运行流程:

![image-20210329102134693](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329102134693.png)



##### rabbitmq的5种主要的模式:

simple简单模式、work queue工作模式、publish/subscribe发布模式、routing模式、topic主题/通配符模式，RPC机制一般不用

三种Exchange模式：fanout,direct,topic



# 十二、简单模式理解:

![image-20210329102515070](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329102515070.png)





# 十三、Fanout模式理解：

发布订阅模式，是一种广播模式，没有路由key的模式

![image-20210329103246761](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329103246761.png)

![image-20210329103444465](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329103444465.png)

![image-20210329103710111](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329103710111.png)



#### 代码详解:

```java
public class Producer {
    public static void main(String[] args) {

        //1、创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.103.151.171");        //填写主机ip地址
        connectionFactory.setPort(5672);            //设置端口号为5672
        connectionFactory.setUsername("admin");     //设置用户名
        connectionFactory.setPassword("admin");     //设置密码
        connectionFactory.setVirtualHost("/");      //设置虚拟主机
        Connection connection = null;
        Channel channel = null;
        try {
            //2、创建连接Connection
            connection = connectionFactory.newConnection("生产者");

            //3、通过连接获取通道Channel
            channel = connection.createChannel();


            //4、准备消息内容
            String message = "helloworld";

            //5、准备交换机
            String exchangeName = "fanout-exchange";
            //6、定义路由key
            String rountkey = "";
            //7、指定交换机的类型:
            String type = "fanout";

            //8、发送消息给中间件rabbitmq-server
            channel.basicPublish(exchangeName,rountkey,null,message.getBytes());
            System.out.println("消息发送成功");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("消息发送异常");
        }finally {
            //9、关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }

            //10、关闭连接:
            if (connection != null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

```



```java
public class Consumer {
    private static Runnable runnable = new Runnable() {
        public void run() {
            //1、创建连接工厂
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("39.103.151.171");        //填写主机ip地址
            connectionFactory.setPort(5672);            //设置端口号为5672
            connectionFactory.setUsername("admin");     //设置用户名
            connectionFactory.setPassword("admin");     //设置密码
            //获取队列的名称:
            final String queueName = Thread.currentThread().getName();

            Connection connection = null;
            Channel channel = null;
            try {
                //2、从工厂中获取连接
                connection = connectionFactory.newConnection("生产者");

                //3、通过连接获取通道Channel
                channel = connection.createChannel();

                //4、申明队列queue存储消息:
                /*
                    如果队列不存在，则会创建
                    如果queue已经被创建过一次了，可以不需要定义
                 */
                //channel.queueDeclare("queue1",false,false,false,null);

                //5、定义接收消息的回调:
                Channel finalChannel = channel;
                finalChannel.basicConsume(queueName, true, new DeliverCallback() {
                    public void handle(String s, Delivery delivery) throws IOException {
                        System.out.println(delivery.getEnvelope().getDeliveryTag());
                        System.out.println(queueName + ":收到的消息是:" + new String(delivery.getBody(), "UTF-8"));
                    }
                }, new CancelCallback() {
                    public void handle(String s) throws IOException {
                    }
                });

                System.out.println(queueName + "开始接收消息");
                System.in.read();


            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }finally {
                //6、关闭通道
                if (channel != null && channel.isOpen()){
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                }

                //7、关闭连接:
                if (connection != null && connection.isOpen()){
                    try {
                        connection.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };



    //设置三个线程来伪造三个队列queue
    public static void main(String[] args) {
        new Thread(runnable,"queue1").start();
        new Thread(runnable,"queue2").start();
        new Thread(runnable,"queue3").start();
    }
}
```





# 十四、Direct模式:



![image-20210329104148538](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329104148538.png)

![image-20210329104258557](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329104258557.png)



![image-20210329104440358](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329104440358.png)

![image-20210329104532519](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329104532519.png)

![image-20210329105001986](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329105001986.png)



#### 代码详解:

与fanout类似

producer更改部分:

![image-20210329133551737](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329133551737.png)







# 十五、topics主题模式:

![image-20210329105150743](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329105150743.png)

与用户模糊匹配的routing key

![image-20210329105314807](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329105314807.png)

![image-20210329105535891](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329105535891.png)

![image-20210329105657006](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329105657006.png)

![image-20210329215731103](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329215731103.png)





#### 代码详解:

更改部分:

producer:

![image-20210329133829941](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329133829941.png)





# 十六、Headers模式:

![image-20210329110253127](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329110253127.png)

![image-20210329110503802](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329110503802.png)



#### 代码详解:





# 十七、Work模式:

#### (1)轮询模式:

![image-20210329184327155](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329184327155.png)

轮询分发模式:一个消费者只能消费一条消息，按均分配

```java
/*
    轮询分发模式的生产者类
 */
public class Producer {
    public static void main(String[] args) {
        //1、创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2、设置连接属性
        connectionFactory.setHost("39.103.151.171");        //填写主机ip地址
        connectionFactory.setPort(5672);            //设置端口号为5672
        connectionFactory.setUsername("admin");     //设置用户名
        connectionFactory.setPassword("admin");     //设置密码
        connectionFactory.setVirtualHost("/");      //设置虚拟主机
        Connection connection = null;
        Channel channel = null;

        try {
            //3、从连接工厂中获取连接
            connection = connectionFactory.newConnection("消费者-Work2");
            //4、从连接中获取通道channel
            channel = connection.createChannel();
            //5、准备发送消息的内容:

            //=======================end topic模式======================//
            for (int i = 1; i < 20; i++) {
                String msg = "你好" + i;
                channel.basicPublish("","queue1",null,msg.getBytes());
            }
            System.out.println("消息发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发送消息出现异常....");
        } finally {
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/*
    虚拟机结点1
 */
public class Work1 {
    public static void main(String[] args) {
        //1、创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.103.151.171");        //填写主机ip地址
        connectionFactory.setPort(5672);            //设置端口号为5672
        connectionFactory.setUsername("admin");     //设置用户名
        connectionFactory.setPassword("admin");     //设置密码
        connectionFactory.setVirtualHost("/");      //设置虚拟主机
        Connection connection = null;
        Channel channel = null;
        try {
            //2、创建连接Connection
            connection = connectionFactory.newConnection("生产者");

            //3、通过连接获取通道Channel
            channel = connection.createChannel();

            //4、通过通道创建交换机、声明队列、绑定关系、路由key、发送消息和接收消息
            Channel finalChannel = channel;
            //finalChannel.basicQos(1);
            channel.basicConsume("queue1", true, new DeliverCallback() {    //接收消息成功的类
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println("work-1收到消息是:" + new String(delivery.getBody(), "UTF-8"));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, new CancelCallback() {   //接收消息失败的类
                public void handle(String s) throws IOException {
                }
            });
            System.out.println("work-1开始接收消息");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            //5、关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }

            //6、关闭连接:
            if (connection != null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/*
    虚拟机结点2
 */
public class Work2 {
    public static void main(String[] args) {
        //1、创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.103.151.171");        //填写主机ip地址
        connectionFactory.setPort(5672);            //设置端口号为5672
        connectionFactory.setUsername("admin");     //设置用户名
        connectionFactory.setPassword("admin");     //设置密码
        connectionFactory.setVirtualHost("/");      //设置虚拟主机
        Connection connection = null;
        Channel channel = null;
        try {
            //2、创建连接Connection
            connection = connectionFactory.newConnection("生产者");

            //3、通过连接获取通道Channel
            channel = connection.createChannel();

            //4、通过通道创建交换机、声明队列、绑定关系、路由key、发送消息和接收消息
            Channel finalChannel = channel;
            //finalChannel.basicQos(1);
            channel.basicConsume("queue1", true, new DeliverCallback() {    //接收消息成功的类
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println("work-1收到消息是:" + new String(delivery.getBody(), "UTF-8"));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, new CancelCallback() {   //接收消息失败的类
                public void handle(String s) throws IOException {
                }
            });
            System.out.println("work-1开始接收消息");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            //5、关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }

            //6、关闭连接:
            if (connection != null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```





#### (2)公平分发模式:

公平分发:根据消费者能力进行公平分发，处理快的处理得多，处理得慢的处理得少，能者多劳

公平分发代码与轮询分发类似:把work结点的轮询机制改为手动即可

```java
/*
    虚拟机结点1
 */
public class Work1 {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.103.151.171");        //填写主机ip地址
        connectionFactory.setPort(5672);            //设置端口号为5672
        connectionFactory.setUsername("admin");     //设置用户名
        connectionFactory.setPassword("admin");     //设置密码
        connectionFactory.setVirtualHost("/");      //设置虚拟主机
        Connection connection = null;
        Channel channel = null;
        try {
            connection = connectionFactory.newConnection("生产者");

            channel = connection.createChannel();

            final Channel finalChannel = channel;
            finalChannel.basicQos(1);	//这里设置Qos
            channel.basicConsume("queue1", false, new DeliverCallback() {    //改成false
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println("work-1收到消息是:" + new String(delivery.getBody(), "UTF-8"));
                    try {
                        Thread.sleep(2000);
                        finalChannel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);//这里修改
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, new CancelCallback() {   
                public void handle(String s) throws IOException {
                }
            });
            System.out.println("work-1开始接收消息");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```





# 十八、完整的声明创建方式:

之前的方式是可视化界面+代码的方式

![image-20210329134212005](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329134212005.png)



自己创建一个交换机,不通过可视化界面:

```java
/*
    一个完整的声明创建过程,生产者类
 */
public class Producer {
    public static void main(String[] args) {

        //1、创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.103.151.171");        //填写主机ip地址
        connectionFactory.setPort(5672);            //设置端口号为5672
        connectionFactory.setUsername("admin");     //设置用户名
        connectionFactory.setPassword("admin");     //设置密码
        connectionFactory.setVirtualHost("/");      //设置虚拟主机
        Connection connection = null;
        Channel channel = null;
        try {
            //2、创建连接Connection
            connection = connectionFactory.newConnection("生产者");

            //3、通过连接获取通道Channel
            channel = connection.createChannel();


            //4、准备消息内容
            String message = "helloworld";

            //5、准备交换机
            String exchangeName = "direct_message_exchange";    //自定义一个交换机的名字
            //6、指定交换机的类型:
            String exchangeType = "direct";

            //7、声明一个交换机(这些声明的关系既可以在生产者声明也可以在消费者声明,因为都是一个信道):
            channel.exchangeDeclare(exchangeName,exchangeType,true);    //三个参数:交换机的名字、类型、是否持久化


            //8、声明队列
            channel.queueDeclare("queue5",true,false,false,null);
            channel.queueDeclare("queue6",true,false,false,null);
            channel.queueDeclare("queue7",true,false,false,null);
            //参数:队列名、是否持久化、是否有排他性、是否自动删除、参数

            //9、绑定队列与交换机的关系:
            channel.queueBind("queue5",exchangeName,"order");
            channel.queueBind("queue6",exchangeName,"order");
            channel.queueBind("queue7",exchangeName,"course");
            //参数:队列名、交换机名字、路由key

            //10、发送消息给中间件rabbitmq-server
            channel.basicPublish(exchangeName,"order",null,message.getBytes());
            System.out.println("消息发送成功");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("消息发送异常");
        }finally {
            //8、关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }

            //9、关闭连接:
            if (connection != null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```





# 十九、RabbitMQ的应用场景:

工作中工作模式和direct路由模式使用最多的

解耦、削峰、异步





# 二十、整合springboot:

要求实现:

![image-20210329222906861](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329222906861.png)

## A、fanout模式:

### 一)生产者部分:

#### (1)依赖:

![image-20210329222357740](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210329222357740.png)



#### (2)application.yaml配置:

```yaml
# 服务端口
server:
  port: 8080

spring:
  rabbitmq:
    username: admin
    password: admin
    virtual-host: /
    host: 39.103.151.171
    port: 5672
```



#### (3)实现类:

```java
@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     *  模拟用户下单
     * @param userid
     * @param productid
     * @param num
     */
    public void makeOrder(String userid,String productid,int num){
        //1、根据商品的id查询库存是否充足
        //2、保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功" + orderId);

        //3、通过消息队列完成消息的分发
        //参数1:交换机  参数2:路由key/queue队列名称  参数3:消息内容
        String exchangeName = "fanout_order_exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);
    }
}
```

```java
/*
    springboot自带的rabbit配置类
 */
@Configuration
public class RabbitMQConfiguration {
    //1、声明注册fanout模式的交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout_order_exchange",true,false);
    }
    //2、声明队列sms.fanout.queue  email.fanout.queue  duanxin.fanout.queue
    @Bean
    public Queue smsQueue(){
        return new Queue("sms.fanout.queue",true);
    }
    @Bean
    public Queue duanxinQueue(){
        return new Queue("sms.fanout.queue",true);
    }
    @Bean
    public Queue emailQueue(){
        return new Queue("sms.fanout.queue",true);
    }

    //3、完成绑定关系，把队列和交换机绑定
    @Bean
    public Binding smsBinding(){
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding duanxinBinding(){
        return BindingBuilder.bind(duanxinQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding emailBinding(){
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }
}
```

测试类:

```java
@SpringBootTest
class RabbitmqApplicationTests {
    @Autowired
    private OrderService orderService;
    
    @Test
    void contextLoads() {
        orderService.makeOrder("1","1",12);
    }
}
```



### 二)消费者部分:

新建一个工程

#### (1)依赖

与上一样

#### (2)application.yaml配置

只改了端口号:

```java
# 服务端口
server:
  port: 8081

spring:
  rabbitmq:
    username: admin
    password: admin
    virtual-host: /
    host: 39.103.151.171
    port: 5672
```



#### (3)实现类:

```java
/*
    短信接收类
 */
@Service
@RabbitListener(queues = {"duanxin.fanout.queue"})
public class DuanxinConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("duanxin fanout---接收到了订单信息是:->" + message);
    }
}


/*
    sms接收类
 */
@Service
@RabbitListener(queues = {"sms.fanout.queue"})
public class SmsConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("sms fanout---接收到了订单信息是:->" + message);
    }
}


/*
    邮件接收类
 */
@Service
@RabbitListener(queues = {"email.fanout.queue"})
public class EmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("email fanout---接收到了订单信息是:->" + message);
    }
}
```



## B、direct模式:

### 一)生产者部分:

```java
/*
    direct模式的配置
 */
public class DirectRabbitMQConfiguration {
    //1、声明注册direct模式的交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_order_exchange",true,false);
    }
    //2、声明队列
    @Bean
    public Queue smsQueue(){
        return new Queue("sms.direct.queue",true);
    }
    @Bean
    public Queue duanxinQueue(){
        return new Queue("duanxin.direct.queue",true);
    }
    @Bean
    public Queue emailQueue(){
        return new Queue("email.direct.queue",true);
    }

    //3、完成绑定关系，把队列和交换机绑定
    @Bean
    public Binding smsBinding(){
        return BindingBuilder.bind(smsQueue()).to(directExchange()).with("sms");    //需要多加一个路由key
    }
    @Bean
    public Binding duanxinBinding(){
        return BindingBuilder.bind(duanxinQueue()).to(directExchange()).with("duanxin");
    }
    @Bean
    public Binding emailBinding(){
        return BindingBuilder.bind(emailQueue()).to(directExchange()).with("email");
    }
}
```

```java
@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrderDirect(String userid,String productid,int num){
        //1、根据商品的id查询库存是否充足
        //2、保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功" + orderId);

        //3、通过消息队列完成消息的分发
        //参数1:交换机  参数2:路由key/queue队列名称  参数3:消息内容
        String exchangeName = "direct_order_exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchangeName,"email",orderId);    //只给邮件和短信发送
        rabbitTemplate.convertAndSend(exchangeName,"duanxin",orderId);
    }
}

```

测试类:

```java
@SpringBootTest
class RabbitmqApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    void testOrderDirect() {
        orderService.makeOrderDirect("1","1",12);
    }
}
```



### 二)消费者模式:

```java
/*
    短信接收类
 */
@Service
@RabbitListener(queues = {"duanxin.direct.queue"})
public class DuanxinConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("duanxin direct---接收到了订单信息是:->" + message);
    }
}

/*
    邮件接收类
 */
@Service
@RabbitListener(queues = {"email.direct.queue"})
public class EmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("email direct---接收到了订单信息是:->" + message);
    }
}

/*
    sms接收类
 */
@Service
@RabbitListener(queues = {"sms.direct.queue"})
public class SmsConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("sms direct---接收到了订单信息是:->" + message);
    }
}
```



## C、topic模式:

### 一)生产者部分:

```java
@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrderTopic(String userid,String productid,int num){
        //1、根据商品的id查询库存是否充足
        //2、保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功" + orderId);

        //3、通过消息队列完成消息的分发
        //参数1:交换机  参数2:路由key/queue队列名称  参数3:消息内容
        String exchangeName = "topic_order_exchange";

        //给短信和email发送消息
        String routingKey = "com.duanxin";

        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);
    }
}
```

测试类:

```java
@SpringBootTest
class RabbitmqApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    void testOrderTopic() {
        orderService.makeOrderTopic("1","1",12);
    }
}
```



### 二)消费者部分:

在消费者部分使用注解的方式完成绑定操作:

```java
/*
    sms接收类
 */
@Service
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "sms.topic.queue",durable = "true",autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC),
        key = "#.sms.#"
))
public class SmsConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("sms topic---接收到了订单信息是:->" + message);
    }
}


/*
    邮件接收类
 */
@Service
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "email.topic.queue",durable = "true",autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC),
        key = "#.email.#"
))
public class EmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("email topic---接收到了订单信息是:->" + message);
    }
}


/*
    短信接收类
 */
@Service
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "duanxin.topic.queue",durable = "true",autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC),
        key = "#.duanxin.#"
))
public class DuanxinConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("duanxin topic---接收到了订单信息是:->" + message);
    }
}
```

注解有时候会显得很鸡肋





# 二十一、TTL队列过期时间:

![image-20210330065658277](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210330065658277.png)



##### 1、给整个队列设置过期时间:

生产者:

```java
public void makeOrderTtl(String userid,String productid,int num){
    //1、根据商品的id查询库存是否充足
    //2、保存订单
    String orderId = UUID.randomUUID().toString();
    System.out.println("订单生成成功" + orderId);

    //3、通过消息队列完成消息的分发
    //参数1:交换机  参数2:路由key/queue队列名称  参数3:消息内容
    String exchangeName = "ttl_order_exchange";

    //给短信和email发送消息
    String routingKey = "ttl";


    rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);
}
```

消费:

```java
public class TTLRabbitMQConfiguration {
    //1、声明注册direct模式的交换机
    @Bean
    public DirectExchange ttldirectExchange(){
        return new DirectExchange("ttl_direct_exchange",true,false);
    }
    //2、声明队列
    //声明队列的过期时间:
    @Bean
    public Queue directttlDirect(){
        //设置队列的过期时间:
        Map<String,Object> args = new HashMap<>();
        args.put("x-message-ttl",5000); //这里一定是一个int类型,5秒
        return new Queue("ttl.direct.queue",true,false,false,args);
    }


    //3、完成绑定关系，把队列和交换机绑定
    @Bean
    public Binding smsBinding(){
        return BindingBuilder.bind(ttldirectExchange()).to(directttlDirect()).with("ttl");    //需要多加一个路由key
    }
}
```



##### 2、给单独的信息设置过期时间：

生产端:

```java
public class TTLRabbitMQConfiguration {
    //1、声明注册direct模式的交换机
    @Bean
    public DirectExchange ttldirectExchange(){
        return new DirectExchange("ttl_direct_exchange",true,false);
    }
    //2、声明队列
    //声明队列的过期时间:
    @Bean
    public Queue directttlDirect(){
        //设置队列的过期时间:
        Map<String,Object> args = new HashMap<>();
        args.put("x-message-ttl",5000); //这里一定是一个int类型
        return new Queue("ttl.direct.queue",true,false,false,args);
    }

    @Bean
    public Queue directttlMessageDirect(){
        //设置队列的过期时间:

        return new Queue("ttl.message.direct.queue",true);
    }


    //3、完成绑定关系，把队列和交换机绑定
    @Bean
    public Binding smsBinding(){
        return BindingBuilder.bind(ttldirectExchange()).to(directttlDirect()).with("ttl");    
    }

    @Bean
    public Binding ttlmsBinding(){
        return BindingBuilder.bind(directttlMessageDirect()).to(ttldirectExchange()).with("ttl");
    }
}
```

消费端:

```java
public void makeOrderTtlMessage(String userid,String productid,int num){
    //1、根据商品的id查询库存是否充足
    //2、保存订单
    String orderId = UUID.randomUUID().toString();
    System.out.println("订单生成成功" + orderId);

    //3、通过消息队列完成消息的分发
    //参数1:交换机  参数2:路由key/queue队列名称  参数3:消息内容
    String exchangeName = "ttl_direct_exchange";

    String routingKey = "ttlmessage";

    //给消息设置过期时间:
    MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
        @Override
        public Message postProcessMessage(Message message) throws AmqpException {
            message.getMessageProperties().setExpiration("5000");   //设置过期时间
            message.getMessageProperties().setContentEncoding("UTF-8"); //设置编码
            return message;
        }
    };

    rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId,messagePostProcessor);
}
```





# 二十二、死信队列

![image-20210330074317068](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210330074317068.png)

代码:

设置队列过期时间并绑定死信队列:

```java
@Bean
public Queue directttlDirect(){
    //设置队列的过期时间:
    Map<String,Object> args = new HashMap<>();
    args.put("x-message-ttl",5000);
    args.put("x-dead-letter-exchange","dead_direct_exchange");
    args.put("x-dead-letter-routing-key","dead");       //fanout模式不需要配
    return new Queue("ttl.direct.queue",true,false,false,args);
}
```

设置死信队列:

```java
public class DeadRabbitMQConfiguration {
    //1、声明注册死信的交换机
    @Bean
    public DirectExchange deadDirectExchange(){
        return new DirectExchange("dead_direct_exchange",true,false);
    }
    //2、声明死信队列
    //声明队列的过期时间:
    @Bean
    public Queue deadQueue(){

        return new Queue("dead.direct.queue",true);
    }


    //3、完成绑定关系，把队列和交换机绑定

    @Bean
    public Binding deadbinds(){
        return BindingBuilder.bind(deadQueue()).to(deadDirectExchange()).with("dead");
    }

}
```



# 二十三、内存磁盘的监控:

![image-20210330081300353](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210330081300353.png)

![image-20210330081329212](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210330081329212.png)

当内存使用超过配置的阈值或者磁盘空间剩余空间对于配置的阈值时，RabbitMQ会暂时阻塞客户端的连接，并且停止接收从客户端发来的消息，以此避免服务器的崩溃，客户端与服务端的心态检测机制也会失效。

#### 1、内存控制:

参考文档:

##### (1)命令的方式:

```shell
rabbitmqctl set_vm_memory_high_watermark <fraction>
rabbitmqctl set_vm_memory_high_watermark absolute 50MB	#设置内存的绝对值为50MB
#或者:
rabbitmqctl set_vm_memory_high_watermark relative 0.6	#设置内存的相对值
```

![image-20210330081959288](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210330081959288.png)



##### (2)配置文件的方式:

![image-20210330082218661](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210330082218661.png)



#### 2、内存换页:

![image-20210330082522578](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210330082522578.png)

#### 3、磁盘预警:

![image-20210330082609508](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210330082609508.png)





# 二十四、集群搭建:

![image-20210330083210473](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210330083210473.png)







