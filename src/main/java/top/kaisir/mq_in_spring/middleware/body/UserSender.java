package top.kaisir.mq_in_spring.middleware.body;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        User user=new User();
        user.setName("zhangkai");
        user.setPwd("123456789");
        System.out.println("user send : " + user.getName()+ "/" + user.getPwd());
        this.rabbitTemplate.convertAndSend("userQueue", user);
    }
}
