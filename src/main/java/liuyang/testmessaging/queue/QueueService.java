package liuyang.testmessaging.queue;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liuyang(wx)
 * @since 2021/12/2
 */
@Component
@Slf4j
@Data
public class QueueService {
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
}
