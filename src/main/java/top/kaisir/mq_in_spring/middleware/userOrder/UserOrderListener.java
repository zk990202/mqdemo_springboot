package top.kaisir.mq_in_spring.middleware.userOrder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("userOrderListener")
//public class UserOrderListener implements ChannelAwareMessageListener {
//    private static final Logger log = LoggerFactory.getLogger(UserOrderListener.class);
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private
//}
