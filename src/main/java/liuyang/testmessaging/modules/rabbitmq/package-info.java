/**
 * 运行先决条件，RabbitMQ上应具备如下组件（如不具备则项目启动会报错）：
 * 参考视频：16_尚硅谷_消息-RabbitMQ安装测试
 * 1. exchange
 *      liuyang.exchange.direct
 *      liuyang.exchange.fanout
 *      liuyang.exchange.topic
 * 2. queue
 *      liuyang.q
 *      liuyang.q.news
 *      liuyang.q.emps
 *      liuyang.q2.news
 * 3. 绑定规则
 *      在exchange上操作
 *      三个exchange分别绑定前部四个queue
 *      exchange                    queue           routing key
 *      liuyang.exchange.direct     liuyang.q       liuyang.q
 *                                  liuyang.q.news  liuyang.q.news
 *                                  liuyang.q.emps  liuyang.q.emps
 *                                  liuyang.q2.news liuyang.q2.news
 *      liuyang.exchange.fanout     liuyang.q       liuyang.q(指不指定无所谓)
 *                                  liuyang.q.news  liuyang.q.news（指不指定无所谓）
 *                                  liuyang.q.emps  liuyang.q.emps（指不指定无所谓）
 *                                  liuyang.q2.news liuyang.q2.news（指不指定无所谓）
 *      liuyang.exchange.topic      liuyang.q       q.#
 *                                  liuyang.q.news  q.#
 *                                  liuyang.q.news  *.newx
 *                                  liuyang.q.emps  q.#
 *                                  liuyang.q2.news *.news
 *
 * 3. 路由规则
 *      在liuyang.exchange.topic定义q.#, *.news
 *
 * @author liuyang(wx)
 * @since 2022/3/31
 */
package liuyang.testmessaging.modules.rabbitmq;