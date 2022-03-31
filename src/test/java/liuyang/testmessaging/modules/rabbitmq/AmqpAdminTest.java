package liuyang.testmessaging.modules.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Map;

/**
 * 使用程序创建RabbitMQ中的对象
 * 具体的操作见B站视频：19_尚硅谷_消息-AmqpAdmin管理组件的使用（会用GUI就会用这个工具类了。）
 *
 * @author liuyang(wx)
 * @since 2022/3/31
 */
@SpringBootTest
public class AmqpAdminTest {

    private static final String EXCHANGE_NAME = "exchange.123";

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    void testCreate() {
        amqpAdmin.declareExchange(new DirectExchange(EXCHANGE_NAME));
    }

    @Test
    void testDelete() {
        amqpAdmin.deleteExchange(EXCHANGE_NAME);
    }
}
