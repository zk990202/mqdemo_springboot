package top.kaisir.mq_in_spring.middleware.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

public class ReceiveB {
    @Component
    @RabbitListener(queues = "fanout.B")
    public class FanoutReceiverA {

        @RabbitHandler
        public void process(String msg) {
            System.out.println("FanoutReceiverB  : " + msg);
        }

    }
}
