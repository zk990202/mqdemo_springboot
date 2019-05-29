package top.kaisir.mq_in_spring.middleware.manyToMany;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender1 {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        String sendMsg = msg + new Date();
        System.out.println("Sender1: " + sendMsg);
        rabbitTemplate.convertAndSend("directExchange", "directKey1", sendMsg);
    }
}
