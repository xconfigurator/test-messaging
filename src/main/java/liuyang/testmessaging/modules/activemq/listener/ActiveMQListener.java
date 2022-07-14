package liuyang.testmessaging.modules.activemq.listener;

import liuyang.testmessaging.modules.activemq.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author liuyang(wx)
 * @since 2022/7/14
 */
@Component
@Slf4j
public class ActiveMQListener {

    @JmsListener(destination = "amq")// amq 是在ActiveMQConfig中声明的
    public void receive(Message message) {
        log.info("message from amq = {}", message);
    }
}
