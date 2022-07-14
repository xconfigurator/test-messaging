package liuyang.testmessaging.modules.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author liuyang
 * @scine 2021/4/16
 *
 * 注：202203311445 实测 如果MQ中这些队列不存在则项目启动会报错。
 *
 */
//@Service
@Slf4j
public class RabbitDemoListener {

    // 最好明确指定类型 这样MessageConverter就可以完成反序列化
    //@RabbitListener(queues = {"liuyang.q"})
    public void receiveQ01(Object msg) {// 参数类型可以直接写成传输的DTO
    // public void receive(Message msg) { // 可以拿到消息头信息 msg.getBody(); msg.getMessageProperties();
      log.info("liuyang.q = {}", msg);
    }

    //@RabbitListener(queues = {"liuyang.q.emps"})
    public void receiveQ2(Object msg) {
        log.info("liuyang.q.emps = {}", msg);
    }

    //@RabbitListener(queues = {"liuyang.q2.news"})
    public void receiveQ3(Object msg) {
        log.info("liuyang.q2.news = {}", msg);
    }

    //@RabbitListener(queues = {"liuyang.q.news"})
    public void receiveQ4(Object msg) {
        log.info("liuyang.q.news = {}", msg);
    }
}
