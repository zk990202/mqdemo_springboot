package top.kaisir.mq_in_spring.middleware.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

public class ReceiveC {
    @Component
    @RabbitListener(queues = "fanout.C")
    public class FanoutReceiverA {

        @RabbitHandler
        public void process(String msg) {
            System.out.println("FanoutReceiverC  : " + msg);
        }
    }
}
