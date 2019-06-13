package top.kaisir.mq_in_spring.middleware.manyToMany;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue3")
public class Receiver1 {

    @RabbitHandler
    public void processMessage1(String msg) {
        System.out.println("Receiver1: 接收到来自queue3队列的消息：" + msg);
    }

//    @RabbitListener(queues = "queue3")
//    public void processMessage1(String msg) {
//        System.out.println("Receiver1: 接收到来自queue3队列的消息：" + msg);
//    }
//
//    @RabbitListener(queues = "queue4")
//    public void processMessage2(String msg) {
//        System.out.println("Receiver1: 接收到来自queue4队列的消息：" + msg);
//    }

}
