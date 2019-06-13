package top.kaisir.mq_in_spring.middleware;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:prop.properties")
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

    // -------------------
    // --Fanout Exchange--
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindingExchangeA() {
        return BindingBuilder.bind(AMessage()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeB() {
        return BindingBuilder.bind(BMessage()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeC() {
        return BindingBuilder.bind(CMessage()).to(fanoutExchange());
    }

    // --userQueue--
    @Bean
    public Queue userQueue(){
        return new Queue("userQueue");
    }


    // ----用户商城抢单----
//    @Autowired
//    private Environment env;
//
//    @Bean(name = "userOrderQueue")
//    public Queue userOrderQueue() {
//        return new Queue(env.getProperty("user.order.queue.name"), true);
//    }
//
//    @Bean
//    public TopicExchange userOrderExchange() {
//        return new TopicExchange(env.getProperty("user.order.exchange.name"), true , false);
//    }
//
//    @Bean
//    public Binding userOrderBinging() {
//        return BindingBuilder.bind(userQueue()).to(userOrderExchange()).with(env.getProperty("user.order.routing.key.name"));
//    }
}
