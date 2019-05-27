package top.kaisir.mq_in_spring.middleware.manyToMany;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver1 {

    @RabbitListener(queues = "hello.queue1")
    public void processMessage1(String msg) {
        System.out.println("Receiver1: 接收到来自hello.queue1队列的消息：" + msg);
    }

    @RabbitListener(queues = "hello.queue2")
    public void processMessage2(String msg) {
        System.out.println("Receiver1: 接收到来自hello.queue2队列的消息：" + msg);
    }

}
