/**
 * https://spring.io/projects/spring-cloud-stream
 * 周阳老师讲的时候还只是支持RabbitMQ和Kafka, 目前（20220401）看官网列表发现已经包含了RocketMQ。
 *
 * Source Channel Binder -> RabbitMQ/Kafka -> Binder Channel Sink
 *
 * Binder           方便连接中间件，屏蔽差异。
 *                  可以动态的改变消息类型（Kafka的topic和RabbitMQ的exchange），可通过配置文件来实现。
 * Channel          通道，是队列的一种抽象，在消息通信系统中就是实现存储转发的媒介。通过channel对队列进行配置。
 * Soruce/Sink      可简单理解为Spring Cloud Stream自身，从Stream发布消息就是输出，接受消息就是输入。
 * @Input           接收消息
 * @Output          发布消息
 * @StreamListener
 * @EnableBinding   指信道channel和exchange绑定在一起
 *
 * 注：所有的差异化、个性化的东西被放在了配置文件中。而使用的消息生产、消费的代码是同一套（且不涉及下面的MQ的特性）。
 *
 * @author liuyang(wx)
 * @since 2022/4/1
 */
package liuyang.testmessaging.modules.cloudstream;