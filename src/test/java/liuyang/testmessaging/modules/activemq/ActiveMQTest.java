package liuyang.testmessaging.modules.activemq;

import liuyang.testmessaging.modules.activemq.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

/**
 * @author liuyang(wx)
 * @since 2022/7/14
 */
@SpringBootTest
@ActiveProfiles({"client", "activemq"})
@Slf4j
public class ActiveMQTest {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Test
    void helloActiveMQ() {
        Message message = new Message();
        message.setContent("hello, activemq");
        message.setDate(new Date());
        jmsMessagingTemplate.convertAndSend("amq", message);
    }
}
