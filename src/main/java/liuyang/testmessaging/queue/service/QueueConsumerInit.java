package liuyang.testmessaging.queue.service;

import liuyang.testmessaging.queue.QueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author liuyang(wx)
 * @since 2021/12/2
 */
@Component
@Slf4j
public class QueueConsumerInit {

    @Autowired
    QueueConsumerService queueConsumerService;

    @PostConstruct
    public void doSomethingSequentially() {
        queueConsumerService.doService();
    }
}
