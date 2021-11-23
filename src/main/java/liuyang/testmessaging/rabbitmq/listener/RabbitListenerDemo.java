package liuyang.testmessaging.rabbitmq.listener;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author liuyang
 * @scine 2021/4/16
 */
@Service
@Slf4j
public class RabbitListenerDemo {

    // 最好指定Object的类型 这样MessageConverter就可以完成反序列化
    @RabbitListener(queues = {"liuyang.q"})
    public void receiveQ01(Object msg) {
    // public void receive(Message msg) { // 可以拿到消息头信息 msg.getBody(); msg.getMessageProperties();
      log.info("RabbitListenerDemo.receive liuyang.q");
      // 处理消息...
      System.out.println(msg);
    }

    @RabbitListener(queues = {"liuyang.q.emps", "liuyang.q.news"})
    public void receiveQ2(Object msg) {
        log.info("RabbitListenerDemo.receive liuyang.q.emps liuyang.q.news");
        // 处理消息...
        log.info("msg = {}", msg);
        log.info("msg = {}", JSON.toJSONString(msg));
    }
}
