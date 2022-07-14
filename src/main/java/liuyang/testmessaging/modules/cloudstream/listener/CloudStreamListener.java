package liuyang.testmessaging.modules.cloudstream.listener;

import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuyang(wx)
 * @since 2022/4/1
 */
//@Service
//@EnableBinding(Sink.class)
@Slf4j
public class CloudStreamListener {

    //@Resource
    private MessageChannel input;// 变量名需要与配置文件中一致

    //@StreamListener(Sink.INPUT)// 监听哪个队列已经在配置文件中搞定
    public void consumer(Message<String> msg) {
        log.info("msg = {}", msg.getPayload());
    }
}
