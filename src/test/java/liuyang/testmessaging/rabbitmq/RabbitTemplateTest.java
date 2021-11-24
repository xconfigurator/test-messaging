package liuyang.testmessaging.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        // message  需要自己定制序列化规则
        // rabbitTemplate.send(exchange, routeKey, message);

        // ///////////////////////////////////////////////////////////
        // 常用：convertAndSend 当然需要注册MessageConverter，参见RabbitConfig
        // obj会被自动序列化转换成message
        // rabbitTemplate.convertAndSend(exchange, routeKey, obj);

        // String
        rabbitTemplate.convertAndSend("liuyang.exchange.direct", "liuyang.q.gulixueyuan.news", String.format(String.format("hello, rabbittemplate " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))));

        // Object
        Map<String, String> param = new HashMap<>();
        param.put("k1", "foo");
        param.put("k2", "bar");
        param.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        rabbitTemplate.convertAndSend("liuyang.exchange.direct", "liuyang.q", param);// 如果选择fanout的exchange，则填什么routingKey是无所谓的。
    }

    // 接收
    @RepeatedTest(2)
    @Test
    public void testResiveAndConvert() {
        Object o = rabbitTemplate.receiveAndConvert("liuyang.q.gulixueyuan.news");
        log.info("o.getClass() = " + o.getClass());
        System.out.println(o);
    }
}
