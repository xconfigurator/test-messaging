package liuyang.testmessaging.modules.activemq.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuyang(wx)
 * @since 2022/7/14
 */
@Data
public class Message implements Serializable {// 必须实现序列化接口！！
    private String content;
    private Date date;
}
