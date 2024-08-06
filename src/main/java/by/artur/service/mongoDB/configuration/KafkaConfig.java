package by.artur.service.mongoDB.configuration;

import by.artur.service.mongoDB.dto.UserActionDto;
import by.artur.service.mongoDB.utils.Utils;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, UserActionDto> filterItemConsumerFactory() {
        Map<String, Object> config = Utils.consumerConfigs();
//        config.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, Boolean.FALSE);
//        config.put(JsonDeserializer.VALUE_DEFAULT_TYPE, UserActionDto.class.getName());
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(UserActionDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserActionDto> filterItemKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserActionDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(filterItemConsumerFactory());
        return factory;
    }
}