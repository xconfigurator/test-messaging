# RabbitMQ JMS & AMQP

## Spring Boot环境摘要
### 发送消息
JmsTemplate  
RabbitTemplate  

### 接收消息
@JmsListener  
@RabbitListener
注解在方法上监听消息代理发布的消息

### Application上的注解
```java
@EnableJms
@EnableRabbit
```

### Spring Boot 自动配置
JmsAutoConfiguration  
RabbitAutoConfiguraton


## 雷丰阳老师视频
[Spring Boot AMPQ](https://www.bilibili.com/video/BV1KW411F7oX?p=13)    
- 1. ok JMS & AMQP简介
- 2. ok RabbitMQ简介
    - 组件介绍
- 3. RabbitMQ运行机制
    - Exchange Binding Queue之间关系
    - direct - peer to peer
    - fanout - pub/sub
    - topic 
        - e.g. 被绑定在“usa.news”模式上的消息会被投送到标注usa.# 和 #.news的Queue上。
        - #匹配0个或者多个单词，*匹配一个单词。
- headers
    - 与direct交换器完全一致，但性能差很多，几乎用不到了。通过AMQP的header信息内容工作。
- 4. [RabbitMQ安装测试](https://www.bilibili.com/video/BV1KW411F7oX?p=16)
```shell
# ###########################################################
# RabbitMQ
# 环境：CentOS 7
# v20210415
## 拉取镜像
docker pull rabbitmq:3-management


## 创建并启动容器
docker run \
-p 5672:5672 \
-p 15672:15672 \
--name liuyang_rabbitmq_3 \
-d rabbitmq:3-management


## 开机自启动（默认不会开机自动启动）确保容器运行时执行这条语句
## docker start liuyang_redis_6.0.9_001
docker update liuyang_rabbitmq_3 --restart=always
```

- 5. RabbitTemplate
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-amqp</artifactId>
        </dependency>
```
RabbitAutoConfiguration  
RabbitTemplate  
AmqpAdmin  
- 序列化默认使用jdk序列化
- 配置使用json序列化，答：参见RabbitConfig（test-messaging工程中）

- 6. @RabbitListener & EnableRabbit
```java
@Service
@Slf4j
public class RabbitListenerDemo {

    // 最好指定Object的类型 这样MessageConverter就可以完成反序列化
    @RabbitListener(queues = {"liuyang.q"})
    public void receive(Object msg) {
    // public void receive(Message msg) { // 可以拿到消息头信息 msg.getBody(); msg.getMessageProperties();
      log.info("RabbitListenerDemo.receive");
      // 处理消息...
      System.out.println(msg);
    }
}
```

- 7. AmqpAdmin  
在Java程序中创建exchange\queue的方法。  
用到的时候再看。目前都是在management中手动创建相关基础设施。
