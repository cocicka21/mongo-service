package by.artur.service.mongoDB.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static by.artur.service.mongoDB.utils.StringUtil.MQ_QUEUE_NAME;

@Configuration
public class MQConfiguration {

    @Bean
    public Queue myQueue() {
        return new Queue(MQ_QUEUE_NAME, false);
    }

}
