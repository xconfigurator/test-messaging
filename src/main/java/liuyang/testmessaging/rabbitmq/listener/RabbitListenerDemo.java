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
      log.info("liuyang.q = {}", msg);
    }

    @RabbitListener(queues = {"liuyang.q.emps"})
    public void receiveQ2(Object msg) {
        log.info("liuyang.q.emps = {}", msg);
    }

    @RabbitListener(queues = {"liuyang.q.gulixueyuan.news"})
    public void receiveQ3(Object msg) {
        log.info("liuyang.q.gulixueyuan.news = {}", msg);
    }

    @RabbitListener(queues = {"liuyang.q.news"})
    public void receiveQ4(Object msg) {
        log.info("liuyang.q.news = {}", msg);
    }
}
