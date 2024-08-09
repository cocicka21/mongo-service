package by.artur.service.mongoDB.service;

import by.artur.service.mongoDB.dto.UserActionDto;
import by.artur.service.mongoDB.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    private final UserActionService userActionService;


    @KafkaListener(topics = StringUtil.TOPIC_NAME, groupId = "id1", containerFactory = "filterItemKafkaListenerContainerFactory")
    public void getData(UserActionDto data) {
        log.info("{}", data);
        userActionService.saveUserAction(data);
    }
}

