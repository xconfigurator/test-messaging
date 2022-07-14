package liuyang.testmessaging.modules.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * 发送：JmsMessagingTemplate
 * 监听：@JmsListener
 *
 * @author liuyang(wx)
 * @since 2022/3/30
 */
@Configuration
@EnableJms
public class ActiveMQConfig {

    @Bean
    Queue queue() {
        return new ActiveMQQueue("amq");
    }
}
