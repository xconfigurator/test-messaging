package liuyang.testmessaging.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuyang
 * @scine 2021/4/16
 * @update 2021/11/23
 */
@Configuration
@EnableRabbit // 配合RabbitListener
public class RabbitConfig {

    // 序列化为JSON(默认采用JDK的序列化器)
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
