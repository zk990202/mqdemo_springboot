package top.kaisir.mq_in_spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kaisir.mq_in_spring.middleware.callback.Producer;
import top.kaisir.mq_in_spring.middleware.manyToMany.Sender1;
import top.kaisir.mq_in_spring.middleware.manyToMany.Sender2;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private Producer producer;
    @Autowired
    private Sender1 sender1;
    @Autowired
    private Sender2 sender2;

    @PostMapping("/test1")
    public String test1() {
        String msg = "HeLlO WoRlD!";
        producer.send(msg);
        return "success";
    }

    @PostMapping("/test2")
    public String test2() {
        String msg = "Hello World Again!";
        sender1.send(msg);
        sender2.send(msg);
        return "success";
    }
}
