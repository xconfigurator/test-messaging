package liuyang.testmessaging.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyang
 * @scine 2021/4/16
 *
 * 注：单纯使用RabbitTemplate不需要使用@EnableRabbit
 */
@SpringBootTest
@ActiveProfiles("test")// 主要是避开默认端口，这样就可以配合测试@RabbitListener
@Slf4j
public class RabbitTemplateTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 发送
    @Test
    public void testConvertAndSend() {
        log.info("hello, rabbitmq");
        // exchange
        // routeKey
        // message
        // rabbitTemplate.send(exchange, routeKey, message);

        // ///////////////////////////////////////////////////////////
        // 常用：
        // obj会被自动序列化转换成message
        // rabbitTemplate.convertAndSend(exchange, routeKey, obj);

        // String
        // rabbitTemplate.convertAndSend("liuyang.exchange.direct", "liuyang.q", "hello, rabbittemplate");

        // Object
        Map<String, String> param = new HashMap<>();
        param.put("k1", "foo");
        param.put("k2", "bar");
        rabbitTemplate.convertAndSend("liuyang.exchange.direct", "liuyang.q", param);
    }

    // 接收
    // @RepeatedTest(7)
    @Test
    public void testResiveAndConvert() {
        Object o = rabbitTemplate.receiveAndConvert("liuyang.q");
        log.info("o.getClass() = " + o.getClass());
        System.out.println(o);
    }
}
