package by.artur.service.mongoDB.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class AppConfiguration {

    @Bean
    ModelMapper mapper() {
        return new ModelMapper();
    }

}
