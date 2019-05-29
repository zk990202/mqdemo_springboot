package top.kaisir.mq_in_spring.middleware;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // --TopicExchange--
    @Bean
    public Queue queue1() {
        return new Queue("hello.queue1", true); // true表示队列持久化
    }

    @Bean
    public Queue queue2() {
        return new Queue("hello.queue2", true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("key.1");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#");
    }


    // --DirectExchange--
    @Bean
    public Queue queue3() {
        return new Queue("queue3", true);
    }

    @Bean
    public Queue queue4() {
        return new Queue("queue4", true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(directExchange()).with("directKey1");
    }

    @Bean
    public Binding binding4() {
        return BindingBuilder.bind(queue4()).to(directExchange()).with("directKey2");
    }

}
