package top.kaisir.mq_in_spring.middleware.manyToMany;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender2 {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        String sendMsg = msg + new Date();
        System.out.println("Sender2: " + sendMsg);
        rabbitTemplate.convertAndSend("topicExchange", "key.2", msg);
    }
}
