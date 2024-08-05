package by.artur.service.mongoDB.service;

import by.artur.service.mongoDB.dto.UserActionDto;
import by.artur.service.mongoDB.entity.UserAction;
import by.artur.service.mongoDB.repository.UserActionRepository;
import by.artur.service.mongoDB.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    private final UserActionRepository repository;
    private final ModelMapper mapper;


    @KafkaListener(topics = StringUtil.TOPIC_NAME, groupId = "id1", containerFactory = "filterItemKafkaListenerContainerFactory")
    public void getData(UserActionDto data) {
        log.info("{}", data);
        UserAction userAction = mapper.map(data, UserAction.class);
        userAction.setId(UUID.randomUUID().toString());
        log.info("{}", userAction);
        repository.save(userAction);

    }
}

