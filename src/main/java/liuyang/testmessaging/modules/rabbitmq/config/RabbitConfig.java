package liuyang.testmessaging.modules.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置
 * 0. @EnableRabbit
 * 1. RabbitAutoConfiguration   spring-boot-autoconfigre-*.jar o.s.b.autoconfig.amqp.RabbitAutoConfiguration
 *      自动配置类中配置了连接工厂，注意到其中的RabbitProperties，可知该配置与spring.rabbitmq绑定到了一起。
 * 2. 自动配置类向容器中注册了RabbitTemplate。用于发送接收消息。
 * 3. 自动配置类向容器中注册了AmqpAdmin。用于创建exchange，queue，binding
 * 4. @RabbitListener 见RabbitListenerDemo
 *
 * @author liuyang
 * @scine 2021/4/16
 * @update 2021/11/23
 * @update 2022/03/07   在配置文件中创建exchange和queue并执行绑定。
 */
@Configuration
@EnableRabbit // 配合RabbitListener
public class RabbitConfig {

    // 序列化为JSON(默认采用JDK的序列化器)
    // Ctrl + H (IntelliJ 看实现关系)
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

/*
    // 20220307
    // 根据Eric视频，在这个部位可以创建exchange和queue并将其绑定。
    // 1. 创建exchange
    // liuyang.exchange.direct
    @Bean
    public DirectExchange liuyangExchangeDirect() {
        return new DirectExchange("liuyang.exchange.direct", true, false);
    }
    // liuyang.exchange.fanout
    @Bean
    public FanoutExchange liuyangExchangeFanout() {
        return new FanoutExchange("liuyang.exchange.direct", true, false);
    }
    // liuyang.exchange.topic
    @Bean
    public TopicExchange liuyangExchangeTopic() {
        return new TopicExchange("liuyang.exchange.topic", true, false);
    }

    // 2. 创建queue
    @Bean
    public Queue liuyangQ() {
        return new Queue("liuyang.q", true, false, false);
    }

    // 3. 绑定exchange和queue
    //@Bean
    //public Binding binding01(DirectExchange liuyangExchangeDirect, Queue liuyangQ) {
        //return BindingBuilder.bind(liuyangQ).to(liuyangExchangeDirect).;
    //}
*/
}
