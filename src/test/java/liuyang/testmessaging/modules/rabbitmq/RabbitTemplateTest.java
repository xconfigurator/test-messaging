package liuyang.testmessaging.modules.rabbitmq;

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
 * @update 2022/3/31 补充示例 并测试通过
 *
 * 注：单纯使用RabbitTemplate不需要使用@EnableRabbit
 * 注：20220331 liuyang: RabbitMQ的使用中，可以吧exchange+routing key视为一般语义上的“队列名称”， RabbitMQ通过exchange + routing key的方式提供了在服务器端更多的组合方式。
 */
@SpringBootTest
@ActiveProfiles("client")// 主要是避开默认端口，这样就可以配合测试@RabbitListener
@Slf4j
public class RabbitTemplateTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testDirect() {
        rabbitTemplate.convertAndSend("liuyang.exchange.direct", "liuyang.q", "to liuyang.q " + System.currentTimeMillis());
        rabbitTemplate.convertAndSend("liuyang.exchange.direct", "liuyang.q.emps", "to liuyang.q.emps " + System.currentTimeMillis());
        rabbitTemplate.convertAndSend("liuyang.exchange.direct", "liuyang.q.news", "to liuyang.q.news " + System.currentTimeMillis());
        rabbitTemplate.convertAndSend("liuyang.exchange.direct", "liuyang.q2.news", "to liuyang.q2.news " + System.currentTimeMillis());
    }

    @Test
    public void testFanout() {
        //rabbitTemplate.convertAndSend("liuyang.exchange.fanout","foo " + System.currentTimeMillis());// 202203311556 这样收不到
        //rabbitTemplate.convertAndSend("liuyang.exchange.fanout", "随便写什么，与fanout类型的exchange绑定的queue都会接收到。但这个参数必须写！","foo " + System.currentTimeMillis());// ok
        rabbitTemplate.convertAndSend("liuyang.exchange.fanout", null, "foo " + System.currentTimeMillis());// 传null也可以
    }

    @Test
    public void testTopic01News() {
        // 预期有两个队列监听器响应
        rabbitTemplate.convertAndSend("liuyang.exchange.topic", "foo.news", "news " + System.currentTimeMillis());
    }

    @Test
    public void testTopic02Q() {
        // 预期有三个队列监听器响应
        rabbitTemplate.convertAndSend("liuyang.exchange.topic", "q.bar", "q " + System.currentTimeMillis());
    }

    // ///////////////////////////////////////////////////////
    // old .................
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
        rabbitTemplate.convertAndSend("liuyang.exchange.direct", "liuyang.q2.news", String.format(String.format("hello, rabbittemplate " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))));

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
        Object o = rabbitTemplate.receiveAndConvert("liuyang.q2.news");
        log.info("o.getClass() = " + o.getClass());
        System.out.println(o);
    }


}
