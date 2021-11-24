package liuyang.testmessaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1. RabbitAutoConfiguration   spring-boot-autoconfigre-*.jar o.s.b.autoconfig.amqp.RabbitAutoConfiguration
 *      自动配置类中配置了连接工厂，注意到其中的RabbitProperties，可知该配置与spring.rabbitmq绑定到了一起。
 * 2. 自动配置类向容器中注册了RabbitTemplate。用于发送接收消息。
 * 3. 自动配置类向容器中注册了AmqpAdmin。用于创建exchange，queue，binding
 */
@SpringBootApplication
public class TestMessagingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMessagingApplication.class, args);
    }

}
