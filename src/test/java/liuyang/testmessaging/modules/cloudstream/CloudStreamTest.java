package liuyang.testmessaging.modules.cloudstream;

import liuyang.testmessaging.modules.cloudstream.service.CloudStreamProducerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author liuyang(wx)
 * @since 2022/4/1
 */
@SpringBootTest
@ActiveProfiles("client")
@Slf4j
public class CloudStreamTest {

    @Autowired
    private CloudStreamProducerService producer;

    //@Test
    @RepeatedTest(4)
    void testSend() {
        String msg = "foo " + System.currentTimeMillis();
        producer.send(msg);
    }
}
