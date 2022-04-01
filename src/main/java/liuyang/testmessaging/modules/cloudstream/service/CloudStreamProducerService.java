package liuyang.testmessaging.modules.cloudstream.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuyang(wx)
 * @since 2022/4/1
 */
@Service
@EnableBinding(Source.class)
@Slf4j
public class CloudStreamProducerService {

    @Resource
    MessageChannel output;// 变量名需要与配置文件中一致 @Resource 默认 by id

    public void send(String msg) {
        log.info("stream send = {}", msg);
        output.send(MessageBuilder.withPayload(msg).build());
    }
}
