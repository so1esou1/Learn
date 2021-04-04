# 一、安装:



1、安装nginx的tar.gz包

2、需要提前安装的素材:

pcre、openssl、zlib

![image-20210401160758812](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401160758812.png)

![image-20210401160812418](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401160812418.png)

![image-20210401160820888](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401160820888.png)

3、安装nginx:

![image-20210401161835960](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401161835960.png)



nginx会在local文件夹下设置一个nginx的目录

![image-20210401162414793](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401162414793.png)



### 启动:

在nginx文件夹中，有一个启动脚本nginx

输入命令:

```shell
./nginx
```

即可启动

ps -ef | grep nginx	命令检查是否启动成功





nginx.conf中:

![image-20210401165152735](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401165152735.png)



![image-20210401165323184](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401165323184.png)

至此，安装成功

设置防火墙:

```shell
#查看开放的端口号:
firewall-cmd --list-all

#设置开放的端口号
firewall-cmd --add-service=http -permanent
firewall-cmd --add-port=80/tcp --permanent		//开放80端口

#重启防火墙:
firewall-cmd --reload
```





# 二、简介:

![image-20210401162627200](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401162627200.png)

特点:占用内存少，并发能力强。专为性能优化而开发，性能是最重要的考量，能经受高负载的考验



# 三、相关概念介绍:

### (1)反向代理:

正向代理:如果把局域网外的Internet想象成一个巨大的资源库，则局域网中的客户端要访问Internet，则需要通过代理服务器来访问，这样的代理服务就称为正向代理

反向代理:

![image-20210401163321510](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401163321510.png)



反向代理：

![image-20210401163422959](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401163422959.png)





### (2)负载均衡:

![image-20210401163804881](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401163804881.png)



### (3)动静分离:

为了加快网站的解析速度，可以把动态页面和静态页面由不同的服务器来解析，加快解析速度。降低原来单个服务器的压力





# 四、nginx操作中的常用命令:

必须要进入到nginx的目录下才能使用命令



1、查看nginx版本号:	./nginx -v

```shell
[root@iZ8vb0nk0megjn2x4xgc4xZ nginx]# ./nginx -v
nginx version: nginx/1.18.0
```

2、启动nginx:

./nginx

3、关闭nginx:	./nginx -s stop

```shell
[root@iZ8vb0nk0megjn2x4xgc4xZ nginx]# ./nginx -s stop
```

4、重新加载nginx:	./nginx -s reload

配置文件需要重启才能生效

这个命令不需要停掉nginx就可以修改配置，热加载

```shell
[root@iZ8vb0nk0megjn2x4xgc4xZ nginx]# ./nginx -s reload
```





# 五、nginx的配置文件:

nginx文件夹下的nginx.conf

nginx的配置文件有3部分组成

### (1)全局块:

从配置文件开始到 events 块之间的内容，**主要会设置一些影响 Nginx 服务器整体运行的配置指令**，主要包括

1. 配置运行 Nginx 服务器的用户（组）、
2. 允许生成的 worker process 数，
3. 进程 PID 存放路径、
4. 日志存放路径和类型
5. 配置文件的引入.....

![image-20210401184718207](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401184718207.png)

worker_processes 1;	1代表并发处理的值，值越大，可以支持处理并发的数量也就越多



### (2)events块

events 块涉及的指令主要影响 Nginx 服务器与用户的网络连接，常用的设置包括是否开启对多 work process 下的网络连接进行序列化，是否允许同时接收多个网络连接，选取哪种事件驱动模型来处理连接请求，每个 work process 可以同时支持的最大连接数等。

这部分的配置对 Nginx 的性能影响较大，在实际中应该灵活配置

![image-20210401184905046](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401184905046.png)

worker_connections  1024;		表示每个 work process 支持的最大连接数为 1024.



### (3)http块

![image-20210401185024379](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401185024379.png)

是 Nginx 服务器配置中最频繁的部分，代理、缓存和日志定义等绝大多数功能和第三方模块的配置都在这里

还分为**http全局块和server块**

![image-20210401185325743](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401185325743.png)



server块内部还分为**全局 server 块和多个 locaton 块**：

![image-20210401185443545](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401185443545.png)

![image-20210401185536785](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401185536785.png)

listen       80;		目前监听的端口号是80

server_name  localhost;		服务名





# 六、Nginx反向代理配置实例:

#### (1)案例1

想要实现的效果:

​	浏览器地址栏输入地址 www.123.com，跳转到系统 tomcat主页面中localhost:8080



具体实现:

1、需要安装并启动tomcat:

启动方式:tomcat的bin目录中输入命令:     ./startup.sh

注意:要确保这个8080端口是开着的，防火墙处设置





2、在C:\Windows\System32\drivers\etc\hosts处修改主机ip地址，加上这个规则(我没加):ip地址+域名

![image-20210401193814347](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401193814347.png)



3、在nginx中进行设置:

进行请求转发的配置:

在nginx.conf配置文件中进行修改:

![image-20210401194306007](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401194306007.png)

![image-20210401194504223](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401194504223.png)

这样的话，如果是80端口，会转发到http:39.103.151.171:8080这个地址

修改完成

之后输入www.123.com会跳到http:39.103.151.171:8080





#### (2)案例2:

想要实现的效果:使用nginx反向代理，根据访问的路径跳转到不同端口的服务中

​							nginx监听端口是9001

​							访问http://39.103.151.171:9001/edu/	直接跳到39.103.151.171:8080

​							访问http://39.103.151.171:9001/vod/	直接跳到39.103.151.171:8081



准备工作:

​	1、需要准备两个tomcat端口，8080端口和8081端口

​	在配置文件conf目录下的server.xml,修改这个文件:

![image-20210401213112708](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401213112708.png)

![image-20210401213154702](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401213154702.png)

​	2、创建文件夹和测试页面

​	3、具体配置:

​	找到nginx配置文件，进行反向代理配置

添加新的规则:

![image-20210401214254823](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401214254823.png)

将这个再复制一个，如下设置:

![image-20210401214526168](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401214526168.png)

需要开放对外访问的端口号 9001   8080   8081端口，在防火墙设置



# 七、实现负载均衡:

想要实现效果:

浏览器地址栏输入地址`http://127.0.0.1/helloworld`，负载均衡效果，平均 8081和 8082 端口中



#### (1)实现负载均衡:

1、准备两条tomcat服务器，8080+8081

2、在两条tomcat里面webapps目录中，分别创建edu文件夹，在edu文件夹中创建页面a.html，用于测试

3、在nginx的配置文件中进行负载均衡的配置

![image-20210401215357593](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401215357593.png)





#### (2)几种负载均衡的策略:

#### 1、轮询

这是Ngnix负载均衡默认分配策略。每个请求按时间顺序逐一分配到不同的后端服务器，如果后端服务器 down 掉，能自动剔除

#### 2、加权

weight 代表权重，默认为 1，权重越高被分配的客户端越多。指定轮询几率，weight和访问比率成正比，用于后端服务器性能不均的情况

![image-20210401220051030](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401220051030.png)

#### 3、ip_hash

每个请求按访问 ip 的 hash 结果分配，这样每个访客固定访问一个后端服务器，可以解决 session 的问题

![image-20210401220134185](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401220134185.png)

#### 4、fair

这是Ngnix负载均衡第三方分配策略。按后端服务器的响应时间来分配请求，响应时间短的优先分配。

![image-20210401220238699](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210401220238699.png)



# 八、动静分离:

#### (1)简介:

![image-20210402075357398](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402075357398.png)

目的：提高访问的效率，使请求更高效



#### (2)案例:

​	

​		1、在linux系统中准备静态资源，用于进行访问

​		2、nginx配置文件进行配置

![image-20210402080354960](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402080354960.png)

![image-20210402081028712](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402081028712.png)



![image-20210402081048203](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402081048203.png)





# 九、Nginx的集群高可用的配置:

为什么要配置nginx高可用？以防单一nginx挂了，另一个nginx能担当重任。





![image-20210402081648166](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402081648166.png)

准备工作:需要至少配置两台Nginx(两个虚拟机)、需要安装keepalived、需要虚拟ip

安装keepalived的命令:		yum install keepalived –y

​	安装之后，在 etc 里面生成目录 keepalived，有文件 keepalived.conf



#### (1)主服务器

具体的高可用的配置(主从配置)其实就是进行 keepalived.conf的配置

![image-20210402083449272](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402083449272.png)

nginx_check.sh文件的设置内容:

![image-20210402083307887](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402083307887.png)





#### (2)从服务器

只需要这里改成BACKUP就行，脚本也不动

![image-20210402083533979](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402083533979.png)



![image-20210402083838493](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402083838493.png)



#### (3)高可用配置文件详解:

配置文件:

![image-20210402084749398](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402084749398.png)

脚本文件:

![image-20210402084916438](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402084916438.png)



# 十、nginx原理解析:

![image-20210402085057133](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402085057133.png)



worker如何进行工作的:

![image-20210402085209124](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402085209124.png)

![image-20210402085531414](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402085531414.png)



![image-20210402085658851](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402085658851.png)



问题一: 发送请求，占用worker的几个连接数?	2个或4个。client会向worker发送请求，worker也会回请求给client，如果nginx有和tomcat交互，那么worker向tomcat发送请求，tomcat回请求给worker，那么就有4个连接

问题二: nginx有一个master，四个worker，每个worker支持最大的连接数据1024，支持的最大并发数是多少(即每个worker可以支持多少个线程)?			

![image-20210402090407492](C:\Users\xfs\AppData\Roaming\Typora\typora-user-images\image-20210402090407492.png)











