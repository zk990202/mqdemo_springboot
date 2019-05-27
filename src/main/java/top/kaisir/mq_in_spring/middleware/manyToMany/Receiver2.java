package top.kaisir.mq_in_spring.middleware.manyToMany;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver2 {

    @RabbitListener(queues = "hello.queue1")
    public String processMessage1(String msg) {
        System.out.println("Receiver2: 接收到来自hello.queue1队列的消息：" + msg);
        return msg.toUpperCase();
    }

    @RabbitListener(queues = "hello.queue2")
    public void processMessage2(String msg) {
        System.out.println("Receiver2: 接收到来自hello.queue2队列的消息：" + msg);
    }

}
